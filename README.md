### Description
It's a simple project bases on CQRS architecture


### Requirements
1. Java 11
2. Docker
3. Docker Compose

### How to start it
1. We need the start the external components using the command: `$ docker-compose up -d `
2. And then compile the application with command: `$ ./gradlew clean build `
3. Finally, just up the application with command: `$ java -jar ./build/libs/simple-architecture-cqrs-0.0.1-SNAPSHOT.jar `

### Important libraries
* [Flyway](https://flywaydb.org/documentation/)
* [Axon Frameworks](https://docs.axoniq.io/)
* [Kotlin 1.6+](https://kotlinlang.org/docs/whatsnew16.html)
* [kapt](https://kotlinlang.org/docs/kapt.html)
* [MapStruct](https://mapstruct.org/)