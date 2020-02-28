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
-------------------------------------------------------------
## Screen shots of the application.
+ DB data showing some data which will be loaded during the application startup.
![DB](https://user-images.githubusercontent.com/14169071/75553225-f598f580-5a05-11ea-96d7-931e6b410b3e.png)
+ Other screen shots showing GET customer using pass id, add, renew, cancel, validate customer
<img width="1280" alt="Add" src="https://user-images.githubusercontent.com/14169071/75553295-1c572c00-5a06-11ea-9423-3e32e68bb751.png">

<img width="1280" alt="Get" src="https://user-images.githubusercontent.com/14169071/75553374-46a8e980-5a06-11ea-96bb-3a17795a2610.png">
<img width="1280" alt="Renew" src="https://user-images.githubusercontent.com/14169071/75553384-4c063400-5a06-11ea-8321-142eddc29ca5.png">
<img width="1280" alt="Cancel" src="https://user-images.githubusercontent.com/14169071/75553402-5294ab80-5a06-11ea-8d95-e292e5747571.png">
<img width="1280" alt="Vend" src="https://user-images.githubusercontent.com/14169071/75553411-56c0c900-5a06-11ea-8cd3-040de87d498d.png">
