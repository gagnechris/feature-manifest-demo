# feature-manifest-demo
Example implementation of feature manifests in Java

## Builing and Running

`mvn compile` will build the project

`mvn spring-boot:run` will run it locally

## API
http://localhost:8080/greeting

http://localhost:8080/greeting?name=Chris

## Changing manifests

### Staging
http://localhost:8080/manifest/Staging

### Production
http://localhost:8080/manifest/Production

### Features
http://localhost:8080/manifest/F001

http://localhost:8080/manifest/F002

## Manifests Definition
/src/main/java/demo/ManifestDictionary.java
