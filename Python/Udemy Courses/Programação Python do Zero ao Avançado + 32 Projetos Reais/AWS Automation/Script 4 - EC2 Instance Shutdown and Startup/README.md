# EC2 Instance Shutdown and Startup Automation Project

This project aims to automate the **shutdown** and **startup** of `EC2 instances` based on a configured **time schedule**. This behavior is highly beneficial as it helps optimize resource usage, potentially saving significant AWS credits by controlling instance uptime and downtime.

In this project, two Lambda functions will be created, one to start instances and the other to stop instances.

## Lambda Function Permissions

For the Lambda function to perform necessary actions for **stopping and starting EC2 instances**, apply the following JSON policy to configure its permissions:

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
      "Effect": "Allow",
      "Action": [
        "ec2:DescribeInstances",
        "ec2:DescribeRegions",
        "ec2:StartInstances",
        "ec2:StopInstances"
      ],
      "Resource": "*"
    }
  ]
}
```

Adjust the permissions on each Lambda function according to its specific use, one for starting instances and the other for stopping them.

## Stop Instances Function Code

The Lambda function code to **stop instances** is as follows:

```python
import boto3

def lambda_handler(event, context):
    ec2_client = boto3.client('ec2')
    regions = [region['RegionName']
               for region in ec2_client.describe_regions()['Regions']]

    for region in regions:
        ec2 = boto3.resource('ec2', region_name=region)

        print("Region:", region)

        instances = ec2.instances.filter(
            Filters=[{'Name': 'instance-state-name',
                      'Values': ['running']}])

        for instance in instances:
            instance.stop()
            print('Stopped instance:', instance.id)
```

## Start Instances Function Code

The Lambda function code to **start instances** is as follows:

```python
import boto3

def lambda_handler(event, context):
    ec2_client = boto3.client('ec2')
    regions = [region['RegionName']
               for region in ec2_client.describe_regions()['Regions']]

    for region in regions:
        ec2 = boto3.resource('ec2', region_name=region)

        print("Region:", region)

        instances = ec2.instances.filter(
            Filters=[{'Name': 'instance-state-name',
                      'Values': ['stopped']}])

        for instance in instances:
            instance.start()
            print('Started instance:', instance.id)
```

Adjust these function codes according to your specific requirements.

## Usage

Deploy this Lambda function in your AWS environment to automate the **shutdown and startup** of EC2 instances. 

Follow these steps:

1. Set up your two AWS Lambda environments.
2. Copy and paste the provided function codes into your Lambda functions.
3. Configure the Lambda functions permissions as specified in the JSON policy.
4. Trigger the Lambda function based on your desired schedule or event-based triggers to initiate the automatic shutdown and startup of instances.

To schedule these actions, consider using CloudWatch Events -> Rules. Configure the rule with the desired execution schedule to trigger the respective Lambda function. Attach the Lambda function as a target to this rule to execute the desired actions at the specified times.