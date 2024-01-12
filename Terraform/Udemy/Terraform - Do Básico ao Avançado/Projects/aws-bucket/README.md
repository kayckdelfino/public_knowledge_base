# aws-bucket

## Overview

This Terraform project focuses on provisioning an AWS S3 bucket. It is a simple configuration with the primary purpose of creating an S3 bucket in the specified AWS region.

## File Structure

- **`bucket.tf`**: Defines the AWS S3 bucket resource with a specified name.
- **`main.tf`**: Specifies Terraform settings, including the required version and AWS provider details.

## AWS Configuration

- Creates an S3 bucket named "kayckdelfino-curso-terraform" in the AWS EU Central (eu-central-1) region.

## Providers

- Configures the AWS provider with the specified version.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the S3 bucket.

## Important Notes

- Review and adjust the AWS region in `provider "aws"` based on your requirements.
- Modify the S3 bucket name in `resource "aws_s3_bucket"` to suit your naming conventions.
- Ensure that you have the necessary AWS credentials configured locally.
- Use caution and test changes in a controlled environment before applying to production.