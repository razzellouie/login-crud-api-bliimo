# login-crud-api-bliimo

FOR LOGIN:

-- to get the token to authenticate --
POST METHOD: http://localhost:8080/authenticate

{
    "username": "user",
    "password": "pass"
}


FOR CRUD:

-- adding account -- 
POST METHOD: http://localhost:8080/api/topics

example: 

{
        "id": "1",
        "name": "Razzel",
        "description": "Developer"
}

-- viewing all account -- 
GET METHOD: http://localhost:8080/api/topics

-- viewing certain account -- 
GET METHOD: http://localhost:8080/api/topics/{id}

-- updating account -- 

PUT METHOD: http://localhost:8080/api/topics/{id}

example:

{
        "id": "1",
        "name": "Louie",
        "description": "Designer"
}

-- deleting account --

DELETE METHOD: http://localhost:8080/api/topics/{id}

