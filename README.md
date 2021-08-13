# Spring Boot and IBM Cloud Object Storage
Java project to use the IBM Cloud Object Storage service with Spring Boot

## Getting Started

### Guides
The following guides illustrate how to get started::

* [Create an instance of IBM Cloud Object Storage](https://programacionmaster.co/cloud/primeros-pasos-ibm-cloud-object-storage/)
* [Getting started with IBM Cloud Object Storage](https://cloud.ibm.com/docs/cloud-object-storage/getting-started.html)

### Reference Documentation
For further reference, please consider the following sections:

* [Using IBM Cloud Object Storage Java Library](https://cloud.ibm.com/docs/cloud-object-storage/libraries?topic=cloud-object-storage-java)


## Project Configuration

### Environment variables or arguments
The following environment variables or arguments are required before running the project
* ```IBM_COS_API-KEY``` value "apikey" from Service Credentials (JSON)
* ```IBM_COS_BUCKET-NAME``` name of the bucket previously created in the IBM Cos instance
* ```IBM_COS_SERVICE-INSTANCE-ID``` value "resource_instance_id" from Service Credentials (JSON)
* ```IBM_COS_ENDPOINT-URL``` is a URL that you can get from the COS instance in the Endpoints tab
* ```IBM_COS_STORAGE-CLASS``` location code of your bucket
* ```IBM_COS_LOCATION``` location part of the Storage Class, for the case "us-standard" is "us"


## Other Source Code Repository
* [IBM Cloud Object Storage - Java SDK](https://github.com/ibm/ibm-cos-sdk-java)
