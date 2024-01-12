# time-sleep-aws-vm

## Overview

This Terraform configuration sets up AWS resources, including two instances. It utilizes the `time_sleep` resource to introduce a delay of 30 seconds between creating the first and second instances. The backend is configured to use an S3 bucket for storing the Terraform state.

## File Structure

### `main.tf`

- Sets up the main module with required providers and backend configuration.
- Declares the required version for Terraform (>= 1.3.0).
- Declares the AWS provider with version 4.60.0.
- Configures the backend to use an S3 bucket.
- Specifies the region for the AWS provider.

### `provider "aws"` Block

- Specifies the AWS provider configuration with the desired region.
- Includes default tags for resources.

### `data "terraform_remote_state" "vpc"` Block

- Retrieves information from the remote state of the VPC configuration.

### `outputs.tf`

- Outputs the public IPs of the two instances.

### `resource "aws_key_pair" "key"` Block

- Defines the key pair for SSH access.

### `resource "aws_instance" "vm_1"` Block

- Creates the first AWS instance.
- Depends on the remote state of the VPC.
- Associates a public IP address.

### `resource "time_sleep" "wait_30_seconds"` Block

- Introduces a delay of 30 seconds.
- Depends on the creation of the first AWS instance.

### `resource "aws_instance" "vm_2"` Block

- Creates the second AWS instance after a delay of 30 seconds.
- Depends on the `time_sleep` resource.
- Associates a public IP address.

## Configuration

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory.
3. Run `terraform init` to initialize the working directory and download required modules.
4. Execute `terraform validate` to validate the configurations.
5. Execute `terraform apply` to apply the changes and create the AWS resources.
6. Monitor the console output for any errors or warnings.
7. Customize the configuration based on your requirements.