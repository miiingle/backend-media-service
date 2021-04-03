# Pub/Priv Keys for Demo

## To Generate
```shell
openssl genrsa -out private_key.pem 2048

openssl rsa -pubout -in private_key.pem -out public_key.pem
```
