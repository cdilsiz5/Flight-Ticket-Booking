## Flight Ticket Booking Application

### To start application 

```
cd backend
mvn spring-boot:run
```

### Features
```
Implemented  API which contains AirportController, PlaneController, FlightExpeditionController, BookingController, 
PassengerController etc. Crud operations can be done on any api if your role is admin . If you have user role 
most of the delete , create and update operations  are forbidden . Access and Refresh token system implemented 
if your time expires in frontend part it will make refreshtoken request automaticly . Stripe payment system added 
on project , if user buy a flight all the information will be stored to the stripe control panel . For frontend 
React js used also redux , axios , i18 etc a lot of technologies were used on this 
project but frontend part is still not finished .
```

## Backend 
```
- Spring boot web api used.
- SOLID principles followed.
- JPA used.
- MapStruct  used.
- Rol Based Authentication implemened.
- JWT access and refresh token implemented.
- Stripe implemented.
```

## Frontend (not finished)
```
- React js used
- Redux used 
- Access and Refresh token system implemented on api requests 
- User page, Singin, Signup, Flight Search and a lot more page created by using Html, Css, Bootstrap
  and Jquery for few a time ,
```
