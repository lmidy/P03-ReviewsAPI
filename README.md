# Reviews API 
Supports operations for writing reviews and listing reviews for a product but with no sorting or filtering.
Pulls id from mysql and saves reviews in mongodb. Gets reviews from mongodb

### Prerequisites
MySQL needs to be installed and configured with schema called reviewsdb and username and password that is application.properties file

### Getting Started - JPA
* Configure the MySQL Datasource in application.properties.
* Add Flyway scripts in src/main/resources/db/migration.
* Define JPA Entities and relationships.
* Define Spring Data JPA Repositories.
* Add tests for JPA Repositories.

### How I tested this
* Configure mongodb locally 'use mongo_reviewdb' 
* Test against JPA repos are failing IN SPITE OF...testing against swagger
* Validate ability to create products, comments and reviews via swagger http://localhost:8080/swagger-ui.html#/
* After using swagger to create a review against productid=1
* validate db.reviews.find().pretty to see reviews saved in mongodb

### Changes made for MongoDB
* Configure the Mongo URI in application.properties.
* Define mongo document models in models folder
* Updated review and comment controllers
* Defined MongoReviewRepository 
* Add tests for MongoDB Repositories.
* Am I missing some config for telling the app where to go for what Mongo vs JPA properties? >_<

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Spring boot Flyway database migration example](https://www.callicoder.com/spring-boot-flyway-database-migration-example/)
