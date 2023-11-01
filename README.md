# Promo Email Service.

#### Collect user email from promo site.

## Install

1. Create db cvbirds in PostgreSQL
2. Create table from script promo_email.sql
3. Add PostgreSQL adress and credentials to application.properties
4. Compile and run the service.

## Usage

Service save email to PostgreSQL. Send POST request to /promo/email with body:<br>
```
{
   "email": "your@email.domain"
}
```

Service validates emails. If email is invalid service return JSON<br>
```
{
"email": "Please provide a valid email address"
}
```

Service supports uniqueness. If email is non unique service return JSON
```
{
"email": "Email address is already registered"
}
```