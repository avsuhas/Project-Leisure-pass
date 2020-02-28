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
⋅⋅*Adding customer : localhost:8080/customer/add
⋅⋅*Retrieveing customer using passId : localhost:8080/customer/{passId}
⋅⋅*Cancelling the pass : localhost:8080/customer/cancel/{passId}
⋅⋅*Renewing the pass : localhost:8080/customer/renew/{passId}
..*Vendor verify customer's pass : localhost:8080/customer/status/{passId}/{vendorId}
-------------------------------------------------------------
* 
