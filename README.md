# Mongo CRUD Rest quarkus client

## Requirements
* Java 11
* Maven 3.x
* Internet accesses to download needed artifacts

## Design notes
 * Configuration is defined in [application.properties](./src/main/resources/application.properties)

## Running the Mongo CRUD client in Development mode

### Launching the application
```shell
mvn quarkus:dev
```

### Running the application by connecting to Mongo on Openshift

```shell
# Expose the mongo deployed on open shift cluster so that you can access it locally. Exposing mongo on port 34000.
oc port-forward mongodb-benchmark-replica-set-0 34000:27017

# add/update the configuration in Application.properties
quarkus.mongodb.connection-string=mongodb://localhost:34000

# Connect to mongo using mongo CLI tool.
mongo mongodb://developer:password@localhost:34000
```


### Running the app and inserting Mongo Record.

The client application exposes an API that can be used to start the test:

```shell
curl --location --request POST 'http://localhost:9090/fruits' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "apple",
    "description": "apple desc"
}'
```