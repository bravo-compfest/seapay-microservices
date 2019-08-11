# SEA Pay Microservices
```
      .   ____          _            __ _ _
     /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
     \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
      '  |____| .__|_| |_|_| |_\__, | / / / /
     =========|_|==============|___/=/_/_/_/
```
## Description
Microservices for SEA Pay web application.

- User Management Service: responsible for
- Payment service: responsible for
- Shopping service: responsible for
- Catalog service: responsible for
- Voucher service: responsible for

## Usage

### Prerequisites
1. Java JDK version >11
2. PostgreSQL version 11.4

### How to Build
1. Fill the configurations on file`application.properties` in `seapay-((service_name))/src/main/resources/application.properties` directory.

2. Clean build all services by this command:

        ./gradlew clean build

    or just simply run

        make all

### How to Run

1. To run each service,

    - Run user-management service
        
          make run-user-management

    - Run payment service
        
          make run-payment

    - Run shopping service
        
          make run-shopping

    - Run catalog service
        
          make run-catalog

    - Run voucher service
        
          make run-voucher


## Docker Usage

You can also build and run the microservices using Docker container.

### Prerequisites

[Docker](https://docs.docker.com/install/)

### How to Build

```bash
# run db as detached docker container
docker-compose up db

# gradle build all microservices
docker-compose run catalog-service make all

# to stop db container gracefully
docker-compose down
# or just simply CTRL+C
```

### How to Run

```bash
# to run all microservices as detached docker container
docker-compose up

# to stop container gracefully
docker-compose down
# or just simply CTRL+C
```

```bash
# to run a microservice:
docker-compose run (service_name)-service
```

## Author
Bravo Team