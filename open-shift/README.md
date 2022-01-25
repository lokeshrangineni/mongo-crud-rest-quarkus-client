# Running Database Benchmark Quarkus(Java) Client on the Open Shift

**Step 1:** Building docker image and publish to quay.io

```shell
//adding the jib library so that we can build the docker image.
mvn quarkus:add-extension -Dextensions="container-image-jib"

//building the app to create docker image.
mvn clean package -Dquarkus.container-image.build=true

docker image tag lrangine/mongo-crud-rest-quarkus-client:1.0.0-SNAPSHOT quay.io/lrangine/mongo-crud-rest-quarkus-client:1.0.0-SNAPSHOT
docker image push quay.io/lrangine/mongo-crud-rest-quarkus-client:1.0.0-SNAPSHOT
```
**Step 2:** Deploy the Mongo DB on Open Shift. All the yaml files required for the setup are available in the [folder](./aws/mongodb). You can find the [documentation](./aws/mongodb/README.md) or refer mongo DB documentation. 

**Step 3:** Update the file as per your requirement before Creating the [secret-database-benchmark-mongo-con-string.yaml](secret-database-benchmark-mongo-con-string.yaml) so that database benchmark application can refer it during run time in the next step. App refers to the key `connectionString.standard`. In this way it is easier to modify during run time.

```shell
oc create -f secret-database-benchmark-mongo-con-string.yaml
```
**Step 4:** Deploy the application [deploy-mongo-crud-rest-quarkus-client-app.yaml](deploy-mongo-crud-rest-quarkus-client-app.yaml) using `oc` CLI tool.

```shell
oc create -f deploy-mongo-crud-rest-quarkus-client-app.yaml
```
Above command will spin up the application pods and monitor the logs for any errors. You should be good to perform database benchmarking.

