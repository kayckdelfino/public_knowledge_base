# aws-vpc

## Overview

This Terraform project sets up the basic networking infrastructure on AWS, including a VPC, subnet, internet gateway, route table, route table association, and security group. The project is modular, and each component is defined in separate files to enhance readability and maintainability. Output variables are provided for potential use in other modules or external scripts.

## File Structure

### `main.tf`

- Configures required providers, backend settings, and AWS provider.
- Defines the backend S3 bucket for storing Terraform state files.

### `network.tf`

- Defines resources for AWS VPC, subnet, internet gateway, route table, route table association, and security group.

### `outputs.tf`

- Declares output variables for the subnet ID and security group ID.

### `variables.tf`

- No variables are declared in this project.

## AWS Networking Configuration

- Creates a VPC with CIDR block `10.0.0.0/16`.
- Establishes a subnet within the VPC with CIDR block `10.0.1.0/24`.
- Configures an internet gateway, route table, and associates the subnet with the route table.
- Defines a security group allowing SSH access on port 22.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the AWS networking resources.

## Important Notes

- Review and customize CIDR blocks, region, and other parameters in `network.tf` as needed.
- Output variables `subnet_id` and `security_group_id` can be used in other modules or external scripts.