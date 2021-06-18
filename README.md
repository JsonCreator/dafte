# Daily Advice For The Engineer (DAFTE)

DAFTE (or Dafte) is a learning project by Ben to explore building a Google Cloud Function. Or at least that's how it
started out.

After building out the basic use case as a GC Function, it seemed worthwhile to consider that a single use approach such
as a GC Function might not be the most efficient way to handle requests at various scales/capacities. To be fair to both
approach, the project was adapted to either run as a deployed GC Function, or as a Standalone Spark microservice.


## Running Locally

### As a Google Cloud Function

To run DAFTE locally in the same way that it will be invoked as a GC Function:
```shell
./gradlew runFunction -Prun.functionTarget=dafte.Dafte
```
Then make requests to `localhost:8080/dafte`


### As a Spark Microservice

To run DAFTE locally using the Spark microservice framework:
```shell
./gradlew run
```

Then make requests to `localhost:4567`


### In Docker via Spark (Experimental, at Best)

There is a Dockerfile that very loosely defines a way that Spark can _technically_ be started and run, in a rather
not-so-production-ready way. To build and run:

```shell
docker build -t dafte .
docker run -p 4567:4567 dafte
```

Then make requests to `localhost:4567`


## Supported Query Parameters

DAFTE Supports the following query parameters to alter the default randomized advice giving:

* `name=<name>`: Specify a name for the individual being advised. This creates a date and name based seed that will
  return the same advice for the span of the calendar day.
  * Example: `localhost:4567?name=yukon-gold`
* `shape=raw`: Specify the response shape
  * Example: `localhost:4567?shape=raw`
  * Supported Shapes:
    * `raw`: Returns a plain text string with only the generated advice
    * `json`: Return json in the following format:
      * ```json
        {
          "preparedFor": "yukon-gold",  // Only when `name` is specified
          "date":"2021-06-18",
          "advice":"The advice is in the journey."
        }
        ```

## Deploying as a Google Cloud Function

A more comprehensive guide can be found within Google's
[documentation](https://cloud.google.com/functions/docs/first-java#gradle_1).

If you have set up the following (instructions available at the above link):
* `gcloud` sdk installed locally and in your path
* a GCP Project created
* Billing enabled for your Project
* The Cloud Functions and Cloud Builds API enabled

Then you can deploy the DAFTE function either using the gcloud function command:
```shell
gcloud functions deploy dafte --entry-point dafte.Dafte --runtime java11 --trigger-http --memory 512MB --allow-unauthenticated
```

or by using the shorthand `deploy-gcfunction.sh` script, which will run that exact command, you just won't have to
remember all of it.
