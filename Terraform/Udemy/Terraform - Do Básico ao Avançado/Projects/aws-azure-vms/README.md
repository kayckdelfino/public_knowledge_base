# aws-azure-vms

## Overview

This Terraform project orchestrates the deployment of virtual machines on both AWS and Azure cloud platforms. It leverages remote state data from separate Terraform configurations for AWS and Azure infrastructure. The project aims to create AWS and Azure virtual machines, each with its own public IP address.

## File Structure

- **`data.tf`**: Defines Terraform data sources for remote states on AWS and Azure.
- **`locals.tf`**: Declares local variables, including common tags for resources.
- **`main.tf`**: Specifies Terraform settings, required providers, and the Azure backend configuration.
- **`outputs.tf`**: Declares output variables for the public IP addresses of the created virtual machines.
- **`providers.tf`**: Configures AWS and Azure providers.
- **`variables.tf`**: Defines input variables for public keys in AWS and Azure.
- **`vm-aws.tf`**: Describes the AWS virtual machine configuration.
- **`vm-azure.tf`**: Describes the Azure virtual machine configuration.

## AWS Configuration

- Deploys an AWS EC2 instance with a specified AMI, instance type, and security group.

## Azure Configuration

- Creates an Azure Resource Group, Public IP, Network Interface, and Linux Virtual Machine.

## Variables

- **`aws_key_pub`**: Public key for the AWS virtual machine.
- **`azure_key_pub`**: Public key for the Azure virtual machine.

## Usage

1. Ensure you have Terraform installed (version 1.5.0 or later).
2. Update variables in `variables.tf` with your public keys.
3. Run `terraform init` to initialize the working directory.
4. Execute `terraform apply` to create the virtual machines.

## Important Notes

- Review and customize tags in `locals.tf` to suit your requirements.
- Adjust AWS region in `providers.tf` based on your preferences.
- Ensure all dependencies, including remote state configurations, are correctly set up.