# upvote-with-reactjs-springboot

This is an example of blog with posts that can be upvoted, with the use of spring-boot and reactjs. 

## Prerequisites 

Docker

## Building

In the root folder of the project run the above command

```
docker-compose build
```

## Running 

```
docker-compose up
```

In a browser you can access the above url

```
localhost:5000
```

## Running tests

### Server tests

```
docker-compose run upvote-server make tests
```

### App tests

```
docker-compose run upvote-app make tests
```

## Build with

* [Postgresql](https://www.postgresql.org/) - Database
* [Maven](https://maven.apache.org/) - Dependency management and tests
* [Spring.io](https://spring.io/) - JDBC-backed config seerver
* [Reactjs](https://reactjs.org/) - Javascript framework for user interfaces
* [Jest](https://facebook.github.io/jest/) - Javascript testing framework
* [Docker](https://www.docker.com) - Container platform
