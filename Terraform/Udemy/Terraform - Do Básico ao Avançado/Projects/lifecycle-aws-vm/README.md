# lifecycle-aws-vm

## Overview

This Terraform project creates AWS resources, including an S3 bucket and an EC2 instance. The project uses AWS backend for remote state storage and includes a lifecycle configuration for the EC2 instance.

## File Structure

- **`main.tf`**: Specifies Terraform settings, required providers, and AWS backend for remote state storage.
- **`bucket.tf`**: Defines the creation of an S3 bucket with a lifecycle configuration.
- **`data.tf`**: Utilizes the `terraform_remote_state` data source to fetch information from the AWS VPC state file stored remotely.
- **`outputs.tf`**: Declares an output variable to display the public IP address of the created EC2 instance.
- **`vm.tf`**: Configures the creation of an AWS key pair and an EC2 instance with a lifecycle configuration.
- **`locals.tf`**: Contains local variables for common tags.

## AWS Infrastructure Configuration

### S3 Bucket

- **Bucket**: Creates an S3 bucket with a specified lifecycle configuration.
- **Lifecycle Configuration**: Configures the S3 bucket lifecycle with `create_before_destroy` and ignoring changes to tags.

### EC2 Instance

- **Key Pair**: Generates an AWS key pair for EC2 instance access.
- **EC2 Instance**: Creates an EC2 instance with a specified AMI, instance type, key name, and subnet.

### Outputs

- Displays the public IP address of the created EC2 instance.

### Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the AWS infrastructure.
4. Review the output to obtain the public IP address of the EC2 instance.

### Remote State Storage

- Remote state is stored in an AWS S3 bucket with the specified configuration.
- Ensure appropriate AWS credentials and permissions are configured for remote state storage.

### Important Notes

- Customize variables in `variables.tf` to adjust AWS region, instance type, and other configurations.
- Adjust the EC2 instance lifecycle configuration based on your requirements.
- Uncomment the line in `lifecycle` block to prevent the EC2 instance from being destroyed.