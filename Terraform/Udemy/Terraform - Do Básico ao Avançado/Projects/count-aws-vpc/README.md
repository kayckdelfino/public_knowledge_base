# count-aws-vpc

## Overview

This Terraform project provisions an AWS Virtual Private Cloud (VPC) along with three subnets within the specified CIDR block. The project utilizes Terraform backend with AWS S3 for remote state storage.

## File Structure

- **`main.tf`**: Configures the required providers, Terraform settings, and AWS backend for remote state storage.
- **`network.tf`**: Defines AWS resources, including VPC and subnets.
- **`outputs.tf`**: Declares output variables to display the IDs of the created subnets.

## AWS VPC and Subnet Configuration

- Creates an AWS VPC with the specified CIDR block.
- Creates three AWS subnets within the VPC, each with a unique CIDR block.

## Input Variables

- The AWS region is set within the `main.tf` and `provider "aws"` configuration blocks.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the AWS VPC and subnets.
4. Review the output to obtain the IDs of the created subnets.

## Remote State Storage

- Remote state is stored in an AWS S3 bucket named "kayckdelfino-remote-state" with the key "count/terraform.tfstate".
- Ensure appropriate AWS credentials and permissions are configured for remote state storage.

## Important Notes

- Adjust the CIDR block and other configurations in `network.tf` to suit your specific requirements.
- Verify the AWS provider version in `main.tf` to ensure compatibility.