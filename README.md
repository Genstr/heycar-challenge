# heycar-challenge
hey.car backend challenge

## To build
```
mvn clean package -P docker
```
or simply run build.bat in the root project directory (Windows).

## Run as a Spring Boot application
```
java -jar -Dspring.profiles.active=simplified target/dockerbuild/heycar-challenge.jar
```
or run boot-run.bat in the root project directory (Windows)

## Run as a Docker container
```
docker run -p 8080:8080 genstr/heycar:1.0
```
or simply docker-run.bat in the root project directory (Windows)

## Request/response examples
(Fiddler *.saz and HTTPArchive v1.2 *.har) can be found in the examples/ project sub-directory.