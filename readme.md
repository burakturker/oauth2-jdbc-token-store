**Spring Boot Oauth2 with Jdbc Token Store - Role Based Authorization**

Referenced from <br />
https://codeaches.com/spring-cloud-security/oauth2-authorization-jwt  <br />
https://www.baeldung.com/spring-cor

**You should insert oauth_client_details table**\
**You should insert user table**

--Client: appclient/appclient@123 <br />
--Password encrypted using CodeachesBCryptPasswordEncoder.java (4 rounds) <br />

`INSERT INTO
  oauth_client_details (
    client_id,
    client_secret,
    resource_ids,
    scope,
    authorized_grant_types,
    access_token_validity,
    refresh_token_validity
  )
VALUES
  (
    'appclient',
    '$2a$04$ZVENvHhtvDKPSgMsP9AK0usr9o3Dpo2G3aSAT1HQZSZUB7CoAP6QC',
    'carInventory',
    'read,write',
    'authorization_code,check_token,refresh_token,password',
    1000000,
    1000000
  );`
  
  
  