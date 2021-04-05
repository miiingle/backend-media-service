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

## To Upload a File
```shell
curl -X PUT --data-binary @test.png "https://xxxx.cloudfront.net/test2.png?Expires=1617834000&Signature=jimtMMb4QzufOt9p8T20XpMwAJGt-o0upAyKvTtA4hX7pWmGQUeSzQBxxx~gKiivFTl8jSmfhx3SKFm6ONAcQmN9QlCU-AmY0EbmAzLJycs12Od-5svgwZsjEyn0Y-s-dqsUp6m5HrVbLbeK037YNPXcfGCKohnA2kDMxYiS-ghGvnwtBwU407DkkAOrIkejiTqA9gNQBBAyfgntEJr7P~D4DQDdrksAO8WUMw4heUUqRP5mH~v8eSL948B9uZWcr9PI1vMngwlCeEYIKibpodZnil~IgVROQ__&Key-Pair-Id=KYIPQ1AZHNBNO"
```