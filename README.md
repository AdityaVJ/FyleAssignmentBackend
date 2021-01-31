## Introduction

- This project has been made in Spring boot and follows the Model-View-Controller architecture.
- You need a minimum of JDK 8+ to run this app.
- The app accesses a remote database hosted on the [clever cloud](https://www.clever-cloud.com) platform and has been deployed on [heroku](https://www.heroku.com).

---

## Getting Started

### Installation steps

This project requires a database connection to work with. The data used in this project can be found in this [repository](https://github.com/snarayanank2/indian_banks). You can clone and run the database either locally or host it somewhere and update the relevant URLs in the `src/main/resources/application.yml` file. Alternatively, you can set the following environment variables for the project to be able to access your database:

- `DATABASE_URL`: The main connection URL of the DB.
- `DB_USER` and `DB_PASS` are the user credentials.

After that, you can simply clone the repo and install maven dependencies for the project and run it. No further steps are required.

A demo of the [frontend](https://github.com/AdityaVJ/FyleAssignmentFrontend) of this application can be found [here](https://fyle-assignment-frontend.herokuapp.com/).

### System components Structure
Let's explain first the system structure to understand its components:
```
fyle-backend-assignment --> Parent folder. 
|- src
  |- main
    |- java --> Contains the package classes of the project.
      |- com.fyle.assignment --> The main package of the project.
        |- controller --> Contains the Java classes responsible for exposing REST API endpoints.
        |- model --> Contains the data model classes.
        |- repository --> Contains the core repository classes which enable sophisticated CRUD functionality in the project.
        |- utils --> Contains utility classes.
```
The web app has been deployed to heroku on the URL: https://fyle-assignment-backend.herokuapp.com/

Since the app has been deployed on a free dyno plan, it sleeps after 30 minutes of inactivity. Please allow it some time for the first page load. The subsequent page loads will take less time.

---

## API Reference

### Endpoints
The following endpoints will be exposed upon starting the project:

**URL:** `/api/branches`
**Method:** `GET`
**Params:** `page`,`items`.

####Sample Request:

http://localhost:8080/api/branches?items=2&page=0

####Sample Response:

```json
{
    "currentCount": 2,
    "totalCount": 127857,
    "branches": [
        {
            "bankIFSC": "ABHY0065001",
            "bankId": 60,
            "bankBranch": "RTGS-HO",
            "bankAddress": "ABHYUDAYA BANK BLDG., B.NO.71, NEHRU NAGAR, KURLA (E), MUMBAI-400024",
            "bankCity": "MUMBAI",
            "bankDistrict": "GREATER MUMBAI",
            "bankState": "MAHARASHTRA"
        },
        {
            "bankIFSC": "ABHY0065002",
            "bankId": 60,
            "bankBranch": "ABHYUDAYA NAGAR",
            "bankAddress": "ABHYUDAYA EDUCATION SOCIETY, OPP. BLDG. NO. 18, ABHYUDAYA NAGAR, KALACHOWKY, MUMBAI - 400033",
            "bankCity": "MUMBAI",
            "bankDistrict": "GREATER MUMBAI",
            "bankState": "MAHARASHTRA"
        }
    ]
}
```

**URL:** `/api/branches/autocomplete`
**Method:** `GET`
**Params:** `offset`,`limit`,`q`.

####Sample Request:

http://localhost:8080/api/branches/autocomplete?offset=1&limit=2&q=kolkata

####Sample Response:

```json
[
  {
    "bankIFSC": "ABNA0100332",
    "bankId": 110,
    "bankBranch": "BRABOURNE ROAD  KOLKATA",
    "bankAddress": "18 A, BRABOURNE ROAD, KOLKATA - 700001",
    "bankCity": "KOLKATA",
    "bankDistrict": "KOLKATA",
    "bankState": "WEST BENGAL"
  },
  {
    "bankIFSC": "ABNA0100333",
    "bankId": 110,
    "bankBranch": "SALT LAKE CITY  KOLKATA",
    "bankAddress": "CD-16 , SECTOR - 1, SALT LAKE CITY, KOLKATA - 700064",
    "bankCity": "KOLKATA",
    "bankDistrict": "KOLKATA",
    "bankState": "WEST BENGAL"
  }
]
```
**URL:** `/api/branches/search`
**Method:** `GET`
**Params:** `offset`,`limit`,`q`.

####Sample Request:

http://localhost:8080/api/branches/search?offset=1&limit=2&q=VIP%20Road

####Sample Response:

```json
[
  {
    "bankIFSC": "ANDB0001271",
    "bankId": 15,
    "bankBranch": "NANDED",
    "bankAddress": "PATIL PLAZA, ITI CIRCLE, VIP ROAD, NANDED - 431602",
    "bankCity": "NANDED",
    "bankDistrict": "NANDED",
    "bankState": "MAHARASHTRA"
  },
  {
    "bankIFSC": "ANDB0001291",
    "bankId": 15,
    "bankBranch": "KAIKHALI",
    "bankAddress": "1 B GOLDRES GREENKAIKHALI MORE,VIP ROAD",
    "bankCity": "KAIKHALI",
    "bankDistrict": "NADIA",
    "bankState": "WEST BENGAL"
  }
]
```


