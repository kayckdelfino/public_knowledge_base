# dynamic-blocks-aws-vpc

## Overview

This Terraform project sets up an AWS infrastructure for a Virtual Private Cloud (VPC) with associated networking components, including a subnet, internet gateway, route table, and security group. The project uses AWS S3 for remote state storage.

## File Structure

- **`main.tf`**: Specifies Terraform settings, required providers, and AWS backend for remote state storage.
- **`network.tf`**: Creates an AWS VPC with a subnet, internet gateway, route table, and a security group.
- **`outputs.tf`**: Declares output variables to display the IDs of the created subnet and security group.
- **`variables.tf`**: Defines a variable for specifying ports and their descriptions in the security group.

## AWS Infrastructure Configuration

### VPC and Networking Components

- **VPC**: Creates a VPC with the specified CIDR block.
- **Subnet**: Establishes a subnet within the VPC.
- **Internet Gateway**: Attaches an internet gateway to the VPC.
- **Route Table**: Configures a route table with a default route to the internet via the internet gateway.
- **Security Group**: Defines a security group allowing specified inbound traffic on various ports.

### Outputs

- Displays the ID of the created subnet and security group.

### Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the AWS infrastructure.
4. Review the output to obtain the subnet and security group IDs.

### Remote State Storage

- Remote state is stored in an AWS S3 bucket with the specified configuration.
- Ensure appropriate AWS credentials and permissions are configured for remote state storage.

### Important Notes

- Customize variables in `variables.tf` to adjust the security group rules and other configurations.
- Verify the AWS provider version in `main.tf` to ensure compatibility.