# Description

Spring Boot Microservices project.Backend application for Cinema Booking,with authentification and file storage.
Eight services listed below have been developed within this project.
- Authentication service
- Cinema service
- Configuration service
- Eureka service
- File service
- API Gateway service
- User service

Client should hit api endpoints next order:

1) Users are required to register and log in via the authentication service based on their role (ADMIN or USER) through the API gateway
2) Users can submit any request to the appropriate service via the API gateway using their bearer token.
## Dependencies

* JDK 21
    * Spring
        * Spring Boot
        * Spring Security
            * JWT
            * Authentication
            * Authorization
        * Spring Web
            * FeignClient
        * Spring Data
            * Spring Data JPA
            * MySQL
        * Spring Cloud
            * Spring Cloud Gateway Server
            * Spring Cloud Config Server
            * Spring Cloud Config Client
    * Netflix
        * Eureka Server
        * Eureka Client
* Database
    * MySQL
* Validation
* File storage
* ModelMapper
* Openapi UI
* Lombok
    
## Rest APIs

<table style="width:100%">
  <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Description</th>
      <th>Valid Request Body</th>
      <th>Valid Request Params</th>
  </tr>
  <tr>
      <td>POST</td>
      <td>/auth/register</td>
      <td>Register for User</td>
      <td><a href="#register">Info</a></td>
      <td></td>
  </tr>
  <tr>
      <td>POST</td>
      <td>/auth/login</td>
      <td>Login for User and Admin</td>
      <td><a href="#login">Info</a></td>
      <td></td>
  </tr>
  <tr>
      <td>GET</td>
      <td>/user/getAll</td>
      <td>Get all user</td>
      <td></td>
      <td></td>
  </tr>
  <tr>
      <td>GET</td>
      <td>/user/getUserById/{id}</td>
      <td>Get user by id</td>
      <td></td>
      <td><a href="#getUserById">Info</a></td>
  </tr>
 <tr>
      <td>GET</td>
      <td>/user/getUserByEmail/{email}</td>
      <td>Get user by email</td>
      <td></td>
      <td><a href="#getUserByEmail">Info</a></td>
  </tr>
 <tr>
      <td>PUT</td>
      <td>/user/update</td>
      <td>Update user</td>
      <td><a href="#updateUser">Info</a></td>
      <td></td>
  </tr>
  <tr>
      <td>DELETE</td>
      <td>/user/deleteUserById/{id}</td>
      <td>Delete user by id</td>
      <td></td>
      <td><a href="#deleteUserById">Info</a></td>
  </tr>
  <tr>
      <td>POST</td>
      <td>/cinema</td>
      <td>Cinema create</td>
      <td><a href="#cinemaCreate">Info</a></td>
      <td></td>
  </tr>
  <tr>
        <td>GET</td>
        <td>/cinema</td>
        <td>Get all cinemas</td>
        <td><a href="#getAllCinema">Info</a></td>
        
  </tr>
  <tr>
      <td>GET</td>
      <td>/cinema/{id}</td>
      <td>Get cinema by id</td>
      <td><a href="#getCinemaById">Info</a></td>
  </tr>
<tr>
      <td>POST</td>
      <td>/movie</td>
      <td>Movie create</td>
      <td><a href="#movieCreate">Info</a></td>
      <td></td>
  </tr>
  <tr>
        <td>GET</td>
        <td>/movie</td>
        <td>Get all movies</td>
        <td><a href="#getAllMovie">Info</a></td>

  </tr>
  <tr>
      <td>GET</td>
      <td>/movie/{id}</td>
      <td>Get movie by id</td>
      <td><a href="#getMovieById">Info</a></td>
  </tr>
<tr>
      <td>POST</td>
      <td>/event</td>
      <td>Event create</td>
      <td><a href="#eventCreate">Info</a></td>
      <td></td>
  </tr>
  <tr>
        <td>GET</td>
        <td>/event</td>
        <td>Get all events</td>
        <td><a href="#getAllEvents">Info</a></td>

  </tr>
  <tr>
      <td>GET</td>
      <td>/event/{id}</td>
      <td>Get event by id</td>
      <td><a href="#getEventById">Info</a></td>
  </tr>
 
 <tr>
      <td>GET</td>
      <td>/file-storage/download/{id}</td>
      <td>Download image to file storage</td>
      <td></td>
      <td><a href="#downloadImage">Info</a></td>
  </tr>
<tr>
      <td>POST</td>
      <td>/file-storage/upload/img</td>
      <td>Upload image to file storage</td>
      <td></td>
      <td><a href="#uploadImage">Info</a></td>
  </tr>
<tr>
      <td>DELETE</td>
      <td>/file-storage/delete/img/{id}</td>
      <td>Delete image from file storage</td>
      <td></td>
      <td><a href="#DeleteImage">Info</a></td>
  </tr>
</table>

## Valid Request Body

##### <a id="register"> Register for User

``` 
    http://localhost:8080/auth/register
    
        {
          "username": "string",
          "password": "string",
          "email": "string"
        }
```

##### <a id="login"> Login for User and Admin

```
      http://localhost:8080/auth/login
    
       {
         "username": "string",
         "password": "string"
       }
```

##### <a id="updateUser"> Update User

```
    http://localhost:8080/user/update
    
    form-data:
        {
          "request": {
            "id": "string",
            "username": "string",
            "password": "string",
            "userDetails": {
              "firstName": "string",
              "lastName": "string",
              "phoneNumber": "string",
              "country": "string",
              "city": "string",
              "address": "string",
              "postalCode": "string",
              "aboutMe": "string",
            }
            }
        }
    
    Bearer Token : Authorized User or Admin
```

#####
## Valid Request Params

##### <a id="getUserById"> Get User By Id

```
    http://localhost:8080/user/getUserById/{id}
    
    Bearer Token : User Token
```

##### <a id="getUserByEmail"> Get User By Email

```
    http://localhost:8080/user/getUserByEmail/{email}
    
    Bearer Token : User Token
```

##### <a id="deleteUserById">Delete User By Id

``` 
    http://localhost:8080/user/deleteUserById/{id}
    
    Bearer Token : Authorized User or Admin
```


##### <a id="downloadImage">Download Image to File Storage

``` 
    http://localhost:8080/file-storage/download/img/{id}
    
    Bearer Token : User Token
```

### How to run the App

<b>Local</b>

<b>1 )</b> Clone project `git clone https://github.com/aleksandarsmnvc/Cinema-SpringBoot-Microservices.git`

<b>2 )</b> Go to the project's home directory :  `cd Cinema-SpringBoot-Microservices`

<b>3 )</b> Run <b>Eureka Server</b>

<b>4 )</b> Run <b>Gateway</b>

<b>5 )</b> Run <b>Config Server</b>

<b>6 )</b> Run other services (<b>auth-service</b>, <b>user-service</b>, <b>cinema</b>,and lastly <b>
file-storage</b>)

<b>7 )</b> For swagger ui localhost:8080/{service-name}/swagger-ui/index.html</b>
