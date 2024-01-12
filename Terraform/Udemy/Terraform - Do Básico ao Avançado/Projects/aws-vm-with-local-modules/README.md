# aws-vm-with-local-modules

## Overview

This Terraform project orchestrates the deployment of an AWS VPC (Virtual Private Cloud) along with essential networking components and a virtual machine (VM). The infrastructure is modularized with a separate network module for better organization and reusability.

## File Structure

- **`main.tf`**: Configures required Terraform providers, backend configuration, and includes the network module for VPC setup.
- **`vm.tf`**: Defines the AWS key pair and instance resource for the VM.
- **`outputs.tf`**: Declares output variables, including the VM's public IP.
- **`variables.tf`**: Specifies input variables, such as the environment for both the network and VM modules.

## Network Module (`network`)

### File Structure

- **`network.tf`**: Sets up the AWS VPC, subnet, internet gateway, route table, route table association, and security group.
- **`outputs.tf`**: Defines output variables for the subnet and security group.
- **`variables.tf`**: Declares input variables for CIDR blocks and environment.

### AWS Resources

- **VPC**: Configures the VPC with a specified CIDR block and environment tag.
- **Subnet**: Defines a subnet within the VPC, tagged with the environment.
- **Internet Gateway**: Establishes an internet gateway associated with the VPC.
- **Route Table**: Creates a route table with a default route to the internet via the internet gateway.
- **Route Table Association**: Associates the route table with the subnet.
- **Security Group**: Sets up a security group allowing SSH traffic, tagged with the environment.

### Outputs

- `subnet_id`: ID of the subnet created in AWS.
- `security_group_id`: ID of the security group created in AWS.

## VM Configuration

### AWS Resources

- **Key Pair**: Configures an AWS key pair, named based on the environment.
- **Instance (VM)**: Launches a virtual machine in the specified subnet and security group, with a public IP address and environment tag.

## Terraform Settings

- Requires Terraform version 1.3.0 or later.
- Specifies the required AWS provider with version 4.60.0.
- Configures an S3 backend for storing Terraform state files.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Set values for input variables in `variables.tf`.
3. Run `terraform init` to initialize the working directory.
4. Execute `terraform apply` to create the AWS VPC, networking components, and VM.

## Important Notes

- Review and adjust AWS region, CIDR blocks, and other parameters in `main.tf` and `network/variables.tf`.
- Customize the public key file (`./aws-key.pub`) for the AWS key pair.
- Consider adjusting the VM configuration in `vm.tf` based on your application requirements.