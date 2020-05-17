CREATE TABLE IF NOT EXISTS oauth_access_token ( token_id VARCHAR(200), token BLOB , authentication_id VARCHAR(200) PRIMARY KEY, user_name VARCHAR(200), client_id VARCHAR(200), authentication BLOB , refresh_token VARCHAR(200));
CREATE TABLE IF NOT EXISTS oauth_client_details (client_id varchar(256) primary key, resource_ids varchar(256), client_secret varchar(256), scope varchar(256), authorized_grant_types varchar(256), web_server_redirect_uri varchar(256), authorities varchar(256), access_token_validity integer, refresh_token_validity integer, additional_information varchar(4096), autoapprove varchar(256));
CREATE TABLE IF NOT EXISTS oauth_refresh_token (token_id VARCHAR(256), token BLOB, authentication BLOB);

