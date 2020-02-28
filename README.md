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
* 
