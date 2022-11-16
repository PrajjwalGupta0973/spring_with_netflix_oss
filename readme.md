- The project is implemented in two ways : using @Async+completablefuture and using webflux
- To run any project, browse any of the folder /usingcompatiblefuture or /usingwebflux, run all of the 4 applications inside the folder and wait for sometime so that they can get registered with Eureka.
- Hit this url : localhost:8080/api/v1/telstra/homepage/1234. 


Note that api gateway is not implemented. So 8080 is still pointing to homepage-service directly. However internal routing is done using eureka server only