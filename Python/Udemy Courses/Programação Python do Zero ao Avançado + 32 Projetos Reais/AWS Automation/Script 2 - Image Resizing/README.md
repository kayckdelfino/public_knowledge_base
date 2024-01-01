# Image Resizing Automation Project

This project automates the **resizing** of images uploaded by users. It ensures that every image received by an `S3 bucket` is resized to a **thumbnail size of 128x128** and subsequently forwarded to another designated `S3 bucket`. It's imperative that each uploaded image adheres to a **1:1** aspect ratio initially to facilitate the resizing process.

## Lambda Function Permissions

The `Lambda function` requires specific `permissions` to execute various tasks effectively. When configuring permissions for your Lambda function, utilize the following JSON policy:

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
        "s3:GetObject"
      ],
      "Resource": "arn:aws:s3:::origin-bucket/*"
    },
    {
      "Effect": "Allow",
      "Action": [
        "s3:PutObject"
      ],
      "Resource": "arn:aws:s3:::destiny-bucket/*"
    }
  ]
}

```

Ensure you replace `origin-bucket` and `destiny-bucket` with the respective names of your `S3 buckets` in your AWS environments; otherwise, the permissions **won't** function correctly.

## Function Code

The `Lambda function`, written in `Python`, utilizes the `Boto3` and `Pillow` libraries to interact with `AWS services` and resize images. Here's an excerpt of the function code:

```python
import os
import tempfile

import boto3
from PIL import Image

s3 = boto3.client('s3')
DEST_BUCKET = os.environ['DEST_BUCKET']
SIZE = 128, 128


def lambda_handler(event, context):

    for record in event['Records']:
        source_bucket = record['s3']['bucket']['name']
        key = record['s3']['object']['key']
        thumb = 'thumb-' + key
        with tempfile.TemporaryDirectory() as tmpdir:
            download_path = os.path.join(tmpdir, key)
            upload_path = os.path.join(tmpdir, thumb)
            s3.download_file(source_bucket, key, download_path)
            generate_thumbnail(download_path, upload_path)
            s3.upload_file(upload_path, DEST_BUCKET, thumb)

        print('Thumbnail image saved at {}/{}'.format(DEST_BUCKET, thumb))


def generate_thumbnail(source_path, dest_path):
    print('Generating thumbnail from:', source_path)
    with Image.open(source_path) as image:
        image.thumbnail(SIZE)
        image.save(dest_path)
```

To utilize the Pillow library, **download** the necessary files to your local machine and then **upload** them to your AWS environment.

## Usage

Deploy this Lambda function in your AWS environment to automate image resizing. Follow these steps:

1. Set up your AWS Lambda environment.
2. Copy and paste the provided function code into your Lambda function.
3. Configure the required environment variables (`DEST_BUCKET`).
4. Adjust the permissions as mentioned in the JSON policy.
5. Trigger the Lambda function using S3 bucket events for object creation to start the image resizing process automatically.