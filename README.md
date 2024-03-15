# Promo Email Service.

#### Collects user userEmail from promo site.

## Install

1. Create db cvbirds in PostgreSQL
2. Create table from script promo_email.sql
3. Add PostgreSQL address and credentials to application.properties
4. Compile and run the service.

## Usage

Service saves userEmail to PostgreSQL. Send POST request to /promo/userEmail with body:<br>
```
{
   "email": "your@userEmail.domain"
}
```

Service saves Facebook user information to PostgreSQL. Send POST request to /promo/userEmail/facebook with body:<br>
```
{
    "name" : "K.V.",
    "email": "kv.fbook@v.c",
    "id" : "123455679890"
}
```

Service validates emails. If userEmail is invalid service return JSON<br>
```
{
"email": "Please provide a valid userEmail address"
}
```

Service supports uniqueness. If userEmail is non unique service return JSON
```
{
"email": "Email address is already registered"
}
```

Service saves feedback in Postgres and sends message to email. Send POST request to /feedback
```
{
    "topic": "Subject",
    "name": "UserName",
    "email": "user@email.com",
    "message": "Hello"
}