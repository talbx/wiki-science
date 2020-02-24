# Wiki Sience | base.camp UHH 2020

## Pre-Processing Requirements
### Standard Dataset Requirements
 - several ~200GB of free storage
 - pre-proccessing server with a lot of power (~ 48 cores 256 GB RAM)
 - ~1d time

### WIP: Full Dataset Requirements
 - several TB (20 TB, if less you need to stop some cronjobs for a while) of free working storage, resulting in ~ 1-3TB
 - pre-proccessing server with a lot of power (~ 48 cores 64 GB RAM)
 - powerfull hadoop cluster
 - multiple days of time (downloading will take at least 3d 7h, extracting, pre-processing)
 - cronjobs for automation (just setup downloading and wait ~ 4d)
## Dataset

### Wording: 
- Full Dataset: enwiki-YYYYMM01-pages-meta-history **standard + all revisions, w/ meta** 
- Standard Dataset: enwiki-latest-pages-articles **all articles w/ latest revisions** @deprecated

### Full Dataset Downloading !CURRENTLY RUNNING ON BASECPU1!

*note:* This should be run on a pre-proccessing server

**warning:** After unpacking and pre-processing, several TB of storage space are required. During the download and pre processing you will be able to take a few (or many) coffee breaks.

The script `scripts/wiki-download-helper.py` produces wget helper commands from wikipedia dumpstatus.json. 

**usage:**  `wiki-download-helper.py < url_to_dumpstatus.json>`

*note:* The generated download bash script ([example](scripts/download_20200201.bash)) does not contain a shebang, each line contains a simple 'wget < url >'.

**Example usage** for wikipedia dump 20200201:
`python scripts/wiki-download-helper.py https://dumps.wikimedia.org/enwiki/20200201/dumpstatus.json > scripts/download_20200201.bash && chmod +x scripts/download_20200201.bash`.
Copy the generated download script to your desired download directory and simple start it with `./download_20200201.bash` (run in screen!).
Since wikipedia is limiting max connections per ip, do not try to parallize the download process with the standard mirror.

###Full Dataset Extracting & Preperation !CURRENTLY RUNNING ON BASECPU1!

*note:* This should be run on a pre-proccessing server

**warning:** The script page-extractor.py **deletes** the source file after processing. Pay attention to complete and correct script paths! (if necessary, add an echo in the scripts to test first!). This is source file deletion is necessary, otherwise over 20TB of storage space would be required (or even more). The extractor.sh script also deletes the source file (.bz2), but this is not dangerous since it only abstracts `bzip2 -d`. 

*note:* For the extraction step you should use the cronjobs in parallel to the downloading, otherwise you have to wait completely for the download (~ 3d 7h). With cronjobs, the download does not get faster, but data that has already been downloaded can be processed.

// only register cronjobs!

usage: `extractor.sh extractor-worker.sh download_dir`
usage: `page-extractor-runner.py page-extractor-worker.sh page-extractor.py download_dir`

`crontab -e`:
```
* * * * * /full/path/to/scripts/extractor.sh /full/path/to/scripts/extractor-worker.sh /full/path/to/download/dir/
* * * * * /full/path/to/scripts/page-extractor-runner.py /full/path/to/scripts/page-extractor-worker.sh /full/path/to/scripts/page-extractor.py /full/path/to/download/dir/
```

### Full Dataset Upload (to hadoop fs) !CURRENTLY RUNNING ON BASECPU1!

**warning:** automatic ssh key login to hadoop server required.

*note:* This section assumes that pre-proccessing server and hadoop cluster are not the same server. 

*note:* This step can also be started in parallel to the previous ones. Files already copied are renamed to .hadoop

Since we assume that this step is started at the beginning, is the fastest (internal network) and is the last in the process chain, this is not carried out in parallel.
The files will be uploaded to `wiki-sience-full-dataset`.

// only register the cronjob!

`crontab -e`:
```
0 * * * * /full/path/to/scripts/uploader-runner.sh /full/path/to/download/dir/ user@hadoopserver /full/path/to/scripts/uploader.sh
```

## Standard Dataset Downloading, Extracting and Uploading (enwiki-latest-pages-articles)

**deprecated:** Since we got a grip on the storage consumption (only 2-3 TB now) of the full data set, we have not considered the standard dataset any further. Limited functionality is to be expected. Basically, after the pre-processing, the standard data set on the hadoop cluster can be used with the same MapReduce jobs if these jobs do not use data from the full dataset.

downloading:

`mkdir dataset-download-dir && cd dataset-download-dir`

`wget https://dumps.wikimedia.org/enwiki/latest/enwiki-latest-pages-articles.xml.bz2` (~ 16GB, ~ max 5MB/s -> ~1h)

extracting:

`bzip2 -d enwiki-latest-pages-articles.xml.bz2` (~ 30min)

pre-processing:

`python /path/to/page-extractor-standard..py enwiki-latest-pages-articles.xml enwiki-latest-pages-articles.ws`  (~ **6h**)

uploading: 
`cat enwiki-latest-pages-articles.ws.gz | ssh user@hadoop "hadoop fs -put - wiki-sience-standard-dataset/enwiki-latest-pages-articles.ws.gz" && mv enwiki-latest-pages-articles.ws.gz "enwiki-latest-pages-articles.ws.gz.hadoop"` 

### Hadoop Dataset Usage

Usage:
 - hadoop jar jarfile [parameter] input output

just choose `wiki-sience-full-dataset` or `wiki-sience-standard-dataset` as 'input'. Even though `wiki-sience-full-dataset` is directory containing multiple compressed `ws.gz` files and `wiki-sience-standard-dataset` is a directory with just one uncompress `ws` file, hadoop can use this as an input stream!

Examples (replace c.jar by your jar and job parameter):
- hadoop jar c.jar **wiki-sience-standard-dataset** contributors
- hadoop jar c.jar **wiki-sience-full-dataset** contributors

## Development

### MOTD :: CURRENTLY RUNNING ON BASECPU1
The download, extraction and hadoop fs upload is currently running on basecpu1, please do not hinder with filelocks or other huge processes.

### Compile
```mvn clean install``` for running compiling, packaging and tests
```mvn clean install -DskipTests``` for running compiling, packaging without running tests

### Default Startup
start spring-boot test run: 
```mvn spring-boot:run```

### Custom Startup
start the spring-boot job dispatcher with an specific job:
```mvn spring-boot:run -Dspring-boot.run.arguments="--jobName=<JobName> --jobInput=<FileName> --jobOuput=<OutputName>"```

## Deploy
### Default Startup
start the spring-boot job dispatcher from jar: 
```java -jar target/wiki-science-0.0.1-SNAPSHOT.jar --jobName=<JobName> --jobInput=<FileName> --jobOutput=<OutputName>```

