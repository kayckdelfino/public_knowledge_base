# aws-vm-with-provisioners

## Overview

This Terraform project focuses on provisioning an AWS EC2 instance with various provisioners, including local-exec, remote-exec, and file provisioners. The project also demonstrates the use of a data source to fetch information from a remote state stored in an S3 bucket. The EC2 instance is configured with an AWS key pair, and SSH and file provisioners are used to execute local and remote commands, as well as copy files.

## File Structure

- **`main.tf`**: Configures Terraform settings, required providers, and the S3 backend.
- **`outputs.tf`**: Defines an output variable for the EC2 instance public IP.
- **`vm.tf`**: Defines AWS key pair and EC2 instance resources with various provisioners.

## AWS Provider Configuration

- Configures the AWS provider with the specified region (EU-Central-1).
- Applies default tags to resources indicating ownership and Terraform management.

## Data Source for Remote State

- Fetches information from the remote state (VPC module) stored in an S3 bucket.

## EC2 Instance Configuration

- Launches an EC2 instance with specified AMI, instance type, key pair, subnet, and security group.
- Uses local-exec provisioner to execute a local command and append the public IP to a file.
- Configures SSH connection settings for remote-exec provisioner.
- Uses remote-exec provisioner to execute remote commands and append network information to a file.
- Utilizes file provisioners to copy local and inline content files to the EC2 instance.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the AWS EC2 instance with provisioners.

## Important Notes

- Review and adjust AWS region, AMI, instance type, and other parameters as needed.
- Ensure the presence of the public key file (`./aws-key.pub`) for the AWS key pair.
- Customize provisioner commands and file sources/destinations based on specific requirements.