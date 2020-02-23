# Wiki Sience | base.camp UHH 2020

## Dataset
### Downloading

**warning:** After unpacking and pre-processing, several TB of storage space are required. During the download and pre processing you will be able to take a few (or very many) coffee breaks.

The script `scripts/wiki-download-helper.py` produces wget helper commands from wikipedia dumpstatus.json. 

**usage:**  `wiki-download-helper.py < url_to_dumpstatus.json>`

*note:* The generated download bash script does not contain a shebang, each line contains a simple 'wget < url >'.

**Example usage** for wikipedia dump 20200201: `python scripts/wiki-download-helper.py https://dumps.wikimedia.org/enwiki/20200201/dumpstatus.json > scripts/download_20200201.bash && chmod +x scripts/download_20200201.bash`
copy the generated download script to your desired download directory and simple start it with `./download_20200201.bash`. Since wikipedia is limiting max connections per ip, do not try to parallize the download process with the standard mirror.

## Dev
### Compile
```mvn clean install``` für compilen + packaging + tests
```mvn clean install -DskipTests```für compile + packaging aber ohne ausführen von tests

### Default Startup
um mittels maven und default parametern zu starten (zum test) lass folgendes laufen:
```mvn spring-boot:run```

### Custom Startup
Um Job name / parameter zu ändern muss man die defaults überschreiben:
```mvn spring-boot:run -Dspring-boot.run.arguments="--jobName=<JobName> --jobInput=<FileName> --jobOuput=<OutputName>"```

## Deploy
### Default Startup
```java -jar target/wiki-science-0.0.1-SNAPSHOT.jar --jobName=<JobName> --jobInput=<FileName> --jobOutput=<OutputName>```

