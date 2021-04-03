# Public/Private Keys for Demo

## Setup
- create a private s3 bucket
- create a private cloudfront distribution
- register a public key + trusted key group to the distribution
- create an origin access identity (this should normally be a part of the cdn creation process)
- change the s3 policy to allow the OAI access

## To Generate Pub/Priv Keys
don't worry, the following keys will never be used in an actual distribution
```shell
openssl genrsa -out private_key.pem 2048

openssl rsa -pubout -in private_key.pem -out public_key.pem
```
