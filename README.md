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
   "userEmail": "your@userEmail.domain"
}
```

Service validates emails. If userEmail is invalid service return JSON<br>
```
{
"userEmail": "Please provide a valid userEmail address"
}
```

Service supports uniqueness. If userEmail is non unique service return JSON
```
{
"userEmail": "Email address is already registered"
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