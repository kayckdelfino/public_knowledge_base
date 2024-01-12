# terraform-get

## Overview

This Terraform configuration sets up the main module with required providers and references external Terraform modules to create AWS resources. It utilizes the `terraform-aws-modules/vpc`, `terraform-aws-modules/s3-bucket`, and `terraform-aws-modules/security-group` modules to provision a VPC, an S3 bucket, and a security group respectively.

## File Structure

### `main.tf`

- Sets up the main module with required providers and references external Terraform modules.
- Specifies the required version for Terraform (>= 1.3.0).
- Declares the AWS provider with version 4.61.0.
- Utilizes the `terraform-aws-modules/vpc` module to create a VPC.
- Utilizes the `terraform-aws-modules/s3-bucket` module to create an S3 bucket.
- Utilizes the `terraform-aws-modules/security-group` module to create a security group.

### `provider "aws"` Block

- Specifies the AWS provider configuration with the desired region.

### `module "vpc"` Block

- References the `terraform-aws-modules/vpc` module to create a VPC.
- Specifies the source and version of the module.

### `module "s3-bucket"` Block

- References the `terraform-aws-modules/s3-bucket` module to create an S3 bucket.
- Specifies the source and version of the module.

### `module "security-group"` Block

- References the `terraform-aws-modules/security-group` module to create a security group.
- Specifies the source and version of the module.

## Configuration

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory.
3. Run `terraform init` to initialize the working directory and download external modules.
4. Execute `terraform validate` to validate the configurations.
5. Execute `terraform apply` to apply the changes and create the AWS resources.
6. Monitor the console output for any errors or warnings.
7. Customize the configuration based on your requirements.