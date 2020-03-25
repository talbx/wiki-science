# WikiScience | base.camp | University Of Hamburg
This project is a students research project for the base.camp software-development internship of the university of Hamburg, Germany.
WikiScience is a data science project which goal is to analyze dumps from wikipedia and collect data from it.
It consists of a 
* map-reduce application, which is capable to map & reduce wiki-data via hadoop, 
* spring-boot backend - which connects to a database, holding most of the information extracted from the map-reduce jobs, aswell as
serving as REST api for the frontend
* flutter frontend - which is responsible for the display of the analytical results.
 
You can find a running version of this project @ http://basecamp-demos.informatik.uni-hamburg.de:8080/wiki-science-backend-1.0.2.RELEASE/#/
## map-reduce
### Setup
#### Input Data
Make sure you have downloaded one of the recent wikipedia dumps from https://dumps.wikimedia.org/.
Currently, the map-reduce application supports two types of dumps:
 * Wikipedia XML format
 * Wikipedia preprocessed JSON format
 * Wikipedia Title List Plain Text

Make sure that your dump is in one of these formats.
In order to convert the basic Wikipedia XML format to JSON you can use the wikiextractor: https://github.com/attardi/wikiextractor.

> Note: It might happen that the XML jobs will fail, this is probably due to the format itself. 
The jobs require to have one article per line, starting and ending with a xml tag.
#### Build
In order to work with the map-reduce application, you'll need to build the sources first.
Make sure to have maven & java 8 installed.

run ```mvn clean install -f map-reduce ```. This will trigger the compile and packaging of the sources.

> Note: You can also run ```mvn clean install``` on root level, the aggregator pom.xml will trigger builds for map-reduce AND backend application.
#### Run on Hadoop Cluster
Copy the generated map-reduce-<VERSION>.jar onto your Hadoop cluster.
Make sure, your dumps are also on the cluster so you can start the procedure.

To start a job, you first need to decide which map-reduce job you want to execute.

To start a job run ```hadoop jar map-reduce-<VERSION>.jar <JOB-NAME> <INPUT-DIR> <OUTPUT-DIR>```

> Example: ```hadoop jar map-reduce-1.0.2.RELEASE.jar most-edited-articles ENWIKI_PAGES_FILTERED/* ENWIKI_PAGES_MREDUCED/most-edited-articles```

A full curated list of jobs can be found below.
#### Job Overview
##### XML Jobs
* word-count
* contributor-count
* most-redirects 
* article-length 
* article-count
* category 
* premium-contributor
* most-edited-articles

##### JSON Jobs
* article-length-json
* redirects-json
* real-article-count-json
* topics-json
* total-article-count-json
* word-count-json

##### Plain Text Jobs
* article-count-plain
## backend
### Setup
#### Build
n order to work with the backend application you'll need to have maven & java 8 installed.

run ```mvn clean install -f backend ```. or just ```mvn clean install``` This will trigger the compile and packaging of the sources (excluding or including the map-reduce application).

#### Run
Via ```mvn spring-boot:run -f backend``` you'll start the backend spring boot application. It will etablish a database connection upon startup.

> Important Note: You'll need to have access to the bascecamp db of the university of hamburg in order to start in prod mode.
> You can still etablish a connection via the "dev" profile which requires a mysql database on localhost:3306.

When the application is started, you can visit the REST api @ http://localhost:8080/swagger-ui.html.
## frontend
### Setup
#### Install Flutter
Make sure you have correctly installed Flutter on your computer.

For more information and a detailed tutorial check out https://flutter.dev/docs/get-started/install.

#### Enable web support
As far as now, web support for Flutter is still in beta, but you can enable web support for the Flutter version on your computer manually.

Check out https://flutter.dev/docs/get-started/web for a step for step guide to use the latest version of the Flutter SDK from the beta channel and enable web support.

#### Run
When you have web support enabled, you can run your project on the Chrome browser with the following command: ```flutter run -d chrome```.
#### Build
Run the following command to generate a release build: ```flutter build web```.

This will create a 'build' folder in your project folder. You can find the index.html and other necessary documents under 'projectFolder'/build/web/

### Deploy
To deploy the frontend, just copy all sources below build/web/ into the static resources of the backend application.
A resource handler will expose the frontend application to the servlet. The running live demo is also deployed this way.
