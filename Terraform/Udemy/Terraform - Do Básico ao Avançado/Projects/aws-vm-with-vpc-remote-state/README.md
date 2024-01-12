# aws-vm-with-vpc-remote-state

## Overview

This Terraform project automates the deployment of an AWS EC2 instance and leverages a remote state from a separate Terraform configuration for VPC provisioning. The project includes the configuration of the AWS provider, data source for fetching remote state, and an EC2 instance with key pair and associated VPC details.

## File Structure

### `main.tf`

- Configures required providers, backend settings, and AWS provider.
- Defines the backend configuration for storing Terraform state files in an S3 bucket.

### `outputs.tf`

- Defines an output variable for the public IP of the created EC2 instance.

### `vm.tf`

- Configures the AWS key pair and EC2 instance resource.
- Utilizes data source for fetching VPC details from remote state.

## AWS EC2 Instance Configuration

- Creates an EC2 instance with specified AMI, instance type, key pair, subnet, and security group.
- Utilizes a data source to fetch VPC details (subnet ID and security group ID) from a separate Terraform remote state.
- Configures the AWS provider and backend settings for state storage.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the AWS EC2 instance using VPC details from the remote state.

## Important Notes

- Review and customize AWS region, AMI, instance type, and key pair configurations in `vm.tf` as needed.
- Ensure the public key file (`./aws-key.pub`) is present for the AWS key pair.
- This project assumes that VPC details are provisioned using a separate Terraform configuration, and the remote state is available.
- Adjust configurations based on specific requirements and use cases.