# EC2 Instance Snapshot Automation Project

This project automates the creation of `snapshots` for `EC2 instances` by configuring the interval between each backup. The primary objective is to simplify the process of generating snapshots for EC2 instances on `Amazon Web Services` with user-defined backup intervals. Instances tagged with `backup = true` will undergo automated backup.

## Lambda Function Permissions

To enable the `Lambda function` to perform necessary actions for **creating EC2 snapshots**, use the following JSON policy to configure its permissions:

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
        "ec2:CreateSnapshot",
        "ec2:CreateTags",
        "ec2:DeleteSnapshot",
        "ec2:Describe*",
        "ec2:ModifySnapshotAttribute",
        "ec2:ResetSnapshotAttribute"
      ],
      "Resource": "*"
    }
  ]
}

```

Ensure to update and adjust the permissions as required to match your specific AWS environment configurations.

## Function Code

The Lambda function, written in `Python`, utilizes the `Boto3` library to interact with `AWS services` and **create snapshots** for `EC2 instances`. Below is a snippet of the function code:

```python
from datetime import datetime
import boto3

def lambda_handler(event, context):
    ec2_client = boto3.client('ec2')
    regions = [region['RegionName']
               for region in ec2_client.describe_regions()['Regions']]

    for region in regions:
        print('Instances in EC2 Region {0}:'.format(region))
        ec2 = boto3.resource('ec2', region_name=region)

        instances = ec2.instances.filter(
            Filters=[
                {'Name': 'tag:backup', 'Values': ['true']}
            ]
        )

        timestamp = datetime.utcnow().replace(microsecond=0).isoformat()

        for i in instances.all():
            for v in i.volumes.all():
                desc = 'Backup of {0}, volume {1}, created {2}'.format(
                    i.id, v.id, timestamp)
                print(desc)
                snapshot = v.create_snapshot(Description=desc)
                print("Created snapshot:", snapshot.id)
```

Customize the function code according to your backup requirements.

## Usage

Deploy this Lambda function in your AWS environment to automate the creation of snapshots for EC2 instances. Follow these steps:

1. Set up your AWS Lambda environment.
2. Copy and paste the provided function code into your Lambda function.
3. Configure the Lambda function permissions as specified in the JSON policy.
4. Trigger the Lambda function based on your desired backup schedule or event-based triggers to initiate snapshot creation automatically.

As a backup schedule, we can use the CloudWatch environment under Events -> Rules. Configure the rule with the desired execution schedule to trigger the Lambda function. Attach the Lambda function as a target to this rule.