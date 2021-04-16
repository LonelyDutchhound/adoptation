# Adoptation

Backend part of an Adoptation project.
It helps handlers to manage pets who are going to be adopted.
It helps people to find a new animal friend.

In development...

## System requirements

- JDK
- PostgreSQL
- docker

## Development

### How to start

To start application set command line argument:

  --spring.config.location=classpath:application.properties,config/application-production.properties


All configurations located [config](./config) with environment name `application-${env}.properties`. 
Change settings and start application.