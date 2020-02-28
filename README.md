# Project-Leisure-pass


## Project Overview:
- A Restful application to manage tourism pass.


### Features
- new customers can be added into the system
- customers can cancel / renew their pass.
- customers can view their information.
- vendors can validate customer pass.

### Project technical details
- **_Spring boot,Spring Data JPA,H2 in-memory database,Lombock,Postman as a rest client_**
- ***Endpoints exposed***
+ **_Adding customer :_** localhost:8080/customer/add
+ **_Retrieveing customer using passId :_** localhost:8080/customer/{passId}
+ **_Cancelling the pass :_** localhost:8080/customer/cancel/{passId}
+ **_Renewing the pass :_** localhost:8080/customer/renew/{passId}
+ **_Vendor verify customer's pass :_** localhost:8080/customer/status/{passId}/{vendorId}
-------------------------------------------------------------
#### Instructions and assumption
+ Download or clone the project and install Lombock jar, Postman.
+ Run the application as spring boot application either from command line or using IDE.
+ Server will start on port 8080 by default.
+ For testing purpose, you can use the postman collection which is available in this project.
+ Pass validity is default set to 30 days, when a new customer added into the system.

