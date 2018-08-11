# Calendar service

## Build Instructions
```java
./gradlew clean build
```

## Launching your application

```java
java -jar build/libs/calendar-service.jar
```

---

## Events - RESTful web service

### Ping - Method: GET
```
URL: localhost:8080/events/ping
```

### Retrieve all events - Method: GET
```
URL: localhost:8080/events/
```

### Add an event - Method: POST, Format: application/json
```
URL: localhost:8080/events/add

Request Body:
{
"id":"1",
"title":"Council of Elrond",
"description": "Decide what to do with the One Ring",
"eventDate": "2018-08-03",
"location": "Rivendell",
"attendeeList": "Frodo, Samwise, Merry, Pippin",
"reminderTime": "2018-08-03"
}
```

### Retrieve events between two dates
```
URL: localhost:8080/events/byDate?start=2018-08-02&end=2018-08-02
```

---

## Security
All the RESTful endpoints with path '/events/**' are secured. Please follow the steps below to generate the token and use it to retrieve these protected resources.

### To generate and get the access token
```
curl -H "Accept: application/json" calendar-api-client:password@localhost:8080/oauth/token -d grant_type=client_credentials
```

### Use the access token and retrieve a protected resource
```
curl -H "Authorization: Bearer <TOKEN>" localhost:8080/events/ping
```

---
