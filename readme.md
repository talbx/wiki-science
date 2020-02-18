# startup

## Dev
### Default Startup
um mittels maven und default parametern zu starten (zum test) lass folgendes laufen:
```mvn spring-boot:run```

### Custom Startup
Um Job name / parameter zu ändern muss man die defaults überschreiben:
```mvn spring-boot:run -Dspring-boot.run.arguments="--jobName=<JobName> --jobInput=<FileName> --jobOuput=<OutputName>"```

## Deploy
### Default Startup
```java -jar target/wiki-science-0.0.1-SNAPSHOT.jar --jobName=<JobName> --jobInput=<FileName> --jobOutput=<OutputName>```

