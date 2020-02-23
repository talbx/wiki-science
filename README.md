# Wiki Sience | base.camp UHH 2020

## Dataset
### Downloading

**warning:** After unpacking and pre-processing, several TB of storage space are required. During the download and pre processing you will be able to take a few (or many) coffee breaks.

The script `scripts/wiki-download-helper.py` produces wget helper commands from wikipedia dumpstatus.json. 

**usage:**  `wiki-download-helper.py < url_to_dumpstatus.json>`

*note:* The generated download bash script ([example](scripts/download_20200201.bash)) does not contain a shebang, each line contains a simple 'wget < url >'.

**Example usage** for wikipedia dump 20200201:
`python scripts/wiki-download-helper.py https://dumps.wikimedia.org/enwiki/20200201/dumpstatus.json > scripts/download_20200201.bash && chmod +x scripts/download_20200201.bash`.
Copy the generated download script to your desired download directory and simple start it with `./download_20200201.bash`.
Since wikipedia is limiting max connections per ip, do not try to parallize the download process with the standard mirror.

## Development
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

