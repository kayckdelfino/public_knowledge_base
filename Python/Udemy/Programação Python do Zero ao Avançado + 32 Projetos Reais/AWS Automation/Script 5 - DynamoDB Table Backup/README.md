# DynamoDB Table Backup Automation Project

This project is designed to **automate** the creation of backups for `DynamoDB tables`, employing `AWS services` and `Lambda functions`. By incorporating automation, it streamlines the regular backup process for `DynamoDB tables`, ensuring **data reliability** and preparedness for **disaster recovery** scenarios.

## Lambda Function Permissions

Configure the Lambda function's permissions to enable essential actions for **creating DynamoDB table backups** using the following JSON policy:

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
        "dynamodb:CreateBackup",
        "dynamodb:DeleteBackup",
        "dynamodb:ListBackups"
      ],
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
```

Ensure to customize and refine the permissions to align with the specific configurations of your AWS environment.

## Function Code

The Lambda function code to **create backups for DynamoDB tables** is as follows:

```python
import boto3
from datetime import datetime

dynamo = boto3.client('dynamodb')

def lambda_handler(event, context):
    if 'TableName' not in event:
        raise Exception("No table name specified.")
    table_name = event['TableName']

    create_backup(table_name)

def create_backup(table_name):
    print("Backing up table:", table_name)
    backup_name = table_name + '-' + datetime.now().strftime('%Y%m%d%H%M%S')

    response = dynamo.create_backup(
        TableName=table_name, BackupName=backup_name)

    print(f"Created backup {response['BackupDetails']['BackupName']}")

```

Adjust the function codes according to your specific requirements.

## Usage

Deploy this Lambda function in your AWS environment to automate the backup creation process for DynamoDB tables:

Follow these steps:

1. Set up your AWS Lambda environment.
2. Copy and paste the provided function code into your Lambda function.
3. Configure the Lambda function permissions as specified in the JSON policy.
4. Before deploying in a production environment, thoroughly test the Lambda function to ensure it operates as intended.
5. Trigger the Lambda function based on your preferred schedule or event-based triggers to automate the backup creation for DynamoDB tables.

Utilize CloudWatch Events -> Rules to schedule these actions. Configure the rule with the desired execution schedule, and attach the Lambda function as a target to execute the backup creation process at specified intervals.