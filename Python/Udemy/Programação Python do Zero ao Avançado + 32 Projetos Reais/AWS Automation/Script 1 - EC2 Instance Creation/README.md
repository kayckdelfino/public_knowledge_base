# AWS Lambda EC2 Instance Creation

This project focuses on automating the creation of `EC2` instances on `Amazon Web Services` using `Python` and `AWS Lambda`. The main goal is to simplify the process of setting up EC2 instances, making it more **efficient** and **user-friendly**.

## Lambda Function Permissions

To ensure the `Lambda` function operates correctly, it requires specific **permissions** to perform various tasks, such as creating new **EC2 instances** and **writing log events** for potential **debugging** purposes. Use the following `JSON policy` when configuring permissions for your Lambda function:

```json
{
  "Version": "2012-10-17",
  
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "logs:CreateLogGroup",
        "logs:CreateLogStream",
        "logs:PutLogEvents"
      ],
      "Resource": "arn:aws:logs:*:*:*"
    },
    {
      "Action": [
        "ec2:RunInstances"
      ],
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
```

This policy grants necessary permissions for the Lambda function to **create log groups**, **streams**, **and events**, as well as to **initiate the creation of EC2 instances**. Adjust the permissions according to your specific requirements and security considerations.

## Function Code

The Lambda function is written in `Python` and utilizes the `Boto3` library to interact with `AWS services`. Here's a snippet of the function code:

```python
import os
import boto3

AMI = os.environ['AMI']
INSTANCE_TYPE = os.environ['INSTANCE_TYPE']
KEY_NAME = os.environ['KEY_NAME']
SUBNET_ID = os.environ['SUBNET_ID']

ec2 = boto3.resource('ec2')

def lambda_handler(event, context):
    instance = ec2.create_instances(
        ImageId=AMI,
        InstanceType=INSTANCE_TYPE,
        KeyName=KEY_NAME,
        SubnetId=SUBNET_ID,
        MaxCount=1,
        MinCount=1
    )

    print("New instance created:", instance[0].id)
```

Make sure to set the necessary environment variables (`AMI`, `INSTANCE_TYPE`, `KEY_NAME`, `SUBNET_ID`) within your Lambda function for successful execution.

## Usage

You can deploy this Lambda function in your AWS environment and trigger it to create EC2 instances with the specified configurations using the provided code snippet.