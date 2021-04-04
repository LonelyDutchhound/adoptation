# Adoptation

## System requirements

- JDK
- PostgreSQL
- docker

## Development

### How to start

For start application need set command line argument:

```bash
--spring.config.location=classpath:application.properties,config/application-production.properties
```

All configuration placed in [config](./config) with environment name `application-${env}.properties`. Just change settings and start application
