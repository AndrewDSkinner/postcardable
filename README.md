## Run Locally
**Prerequisites**
1. Java 17
2. Git
3. Docker

### Running in IntelliJ
1. Enable database migrations by uncommenting:
    ````
    #application.properties
    spring.liquibase.enabled=true
    ````
2. Start docker from project's root directory:
    ````
    docker-compose up -d db    
   
    ````
3. Add local database within Intellij using the Database tool window:
    ````
    Database -> New(+) -> Data Source -> PostgreSql
    Host: localhost
    User: username
    Password: password
    Database: postcardable_db
    URL: jdbc:postgresql://localhost:5432/postcardable_db
   
    ````
4. In the Database tool window, right-click the newly created postcardable_db database and click new -> query console. Execute the following commands:
    ````
    create schema if not exists postcardable;
    set search path to postcardable; 
   
    ````
5. Run the application.
   ````
   http://localhost:8080/actuator/health
   
   ````