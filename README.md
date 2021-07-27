# SpringLocalstack

This Web API fetches secrets from  AWS Secrets Manger

Simple project only to test Spring Boot and [Localstack](https://localstack.cloud/) integration

---

## Start localstack running AWS Secrets Manager only
```
~ SERVICES=secretsmanager localstack start
```

## Manage secrets with AWS CLI
```
~ aws --endpoint http://localhost:4566 secretsmanager create-secret \
        --name <secretName> \
        --secret-string <secret-string-value> \
```
```
~ aws --endpoint-url=http://localhost:4566 secretsmanager get-secret-value --secret-id <secretName>
```

```
~ aws --endpoint http://localhost:4566 secretsmanager delete-secret --secret-id <secretName>
```
### More references:
- [Localstack Docs](https://localstack.cloud/docs/)
- [AWS CLI Secrets Manager Command Reference](https://docs.aws.amazon.com/cli/latest/reference/secretsmanager/index.html)
- [AWS GitHub - AWS Java SDK](https://github.com/aws/aws-sdk-java-v2/blob/master/README.md)
- [AWS Docs - Getting secrets with Spring](https://docs.aws.amazon.com/pt_br/prescriptive-guidance/latest/patterns/manage-credentials-using-aws-secrets-manager.html)

