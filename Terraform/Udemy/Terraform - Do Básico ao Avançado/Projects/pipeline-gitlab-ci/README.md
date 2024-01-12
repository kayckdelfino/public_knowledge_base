# pipeline-gitlab-ci

## Overview

This Terraform project deploys infrastructure on both AWS and Azure, creating a virtual machine on each cloud provider. The `main.tf` file specifies Terraform settings, required providers, and backend configuration for Azure Storage. The project leverages remote state data from AWS and Azure for VPC and VNET configurations, respectively.

## File Structure

- **`main.tf`**: Specifies Terraform settings, required providers (AWS and Azure), and backend configuration for Azure Storage.
- **`locals.tf`**: Defines local variables, including common tags.
- **`outputs.tf`**: Declares output variables to display the public IP addresses of the AWS and Azure virtual machines.
- **`variables.tf`**: Defines variables for public keys used in AWS and Azure configurations.
- **`vm-aws.tf`**: Creates an AWS key pair and an AWS virtual machine.
- **`vm-azure.tf`**: Creates an Azure resource group, a public IP address, a network interface, and an Azure virtual machine.
- **`.gitlab-ci.yml`**: Defines CI/CD pipeline stages for validating, planning, applying, and destroying Terraform infrastructure. It also includes manual approval for the apply and destroy stages.

## AWS Infrastructure Configuration

### AWS Key Pair

- Creates an AWS key pair for the AWS virtual machine.

### AWS Virtual Machine

- Creates an AWS virtual machine with a specified AMI and instance type.

## Azure Infrastructure Configuration

### Azure Resource Group

- Creates an Azure resource group.

### Azure Public IP Address

- Creates an Azure public IP address for the Azure virtual machine.

### Azure Network Interface

- Creates an Azure network interface and associates it with a security group.

### Azure Virtual Machine

- Creates an Azure virtual machine with a specified size, OS image, and SSH public key.

### Outputs

- Displays the public IP address of the AWS virtual machine.
- Displays the public IP address of the Azure virtual machine.

### Variables

- `aws_key_pub`: Public key for the AWS virtual machine.
- `azure_key_pub`: Public key for the Azure virtual machine.

### Usage

1. Ensure you have Terraform installed (version 1.5.0 or later).
2. Update the values of public keys in `variables.tf` based on your key configurations.
3. Navigate to the project directory and run `terraform init` to initialize the working directory.
4. Execute `terraform validate` to validate the configurations.
5. Execute `terraform plan -out plan.out` to plan the infrastructure changes.
6. Review the output to ensure it matches your expectations.
7. If satisfied, execute `terraform apply plan.out` to apply the changes.
8. Monitor the AWS and Azure consoles to verify the created resources.
9. If needed, execute `terraform destroy -auto-approve` to destroy the created resources.

### CI/CD Pipeline

- The `.gitlab-ci.yml` file defines a CI/CD pipeline with stages for validating, planning, applying, and destroying Terraform infrastructure.
- The apply and destroy stages require manual approval to proceed.