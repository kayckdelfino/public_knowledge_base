# aws-vm-user-data

## Overview

This Terraform project aims to automate the provisioning of an AWS EC2 instance with user data, leveraging a script located in the "docs/docker.sh" file. Additionally, it configures Docker and related tools on the EC2 instance. The project utilizes remote state data sources and specifies a backend for storing the Terraform state file in an S3 bucket.

## File Structure

- **`main.tf`**: Defines Terraform settings, required providers, and backend configuration for S3 storage.
- **`vm.tf`**: Configures an AWS EC2 instance, AWS key pair, and user data script.
- **`outputs.tf`**: Defines an output variable for the IP address of the created EC2 instance.
- **`docs/docker.sh`**: Bash script for updating package lists, installing Docker-related packages, and running a detached Docker container (nginx in this example).

## AWS EC2 Instance Configuration

- Creates an AWS key pair and an EC2 instance with specified AMI, instance type, subnet, security group, and user data script.
- The user data script (`docs/docker.sh`) installs necessary packages, configures the Docker repository, and runs a Docker container.

## Terraform Settings

- Requires Terraform version 1.3.0 or later.
- Specifies the required AWS provider with version 4.60.0.

## Backend Configuration

- Utilizes an S3 bucket (`kayckdelfino-remote-state`) to store the Terraform state file.

## Data Source

- Fetches information from the VPC module stored in the S3 bucket.

## Output Variable

- `vm_ip`: IP address of the AWS EC2 instance.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Provide your AWS key pair public key in the file "./aws-key.pub".
3. Run `terraform init` to initialize the working directory.
4. Execute `terraform apply` to create the AWS EC2 instance.

## Important Notes

- Review and adjust AWS AMI, instance type, and region based on your requirements.
- Customize Docker-related configurations in the user data script (`docs/docker.sh`) as needed.
- Ensure AWS key pair name and public key file paths are accurate.
- Validate any security and access configurations for the EC2 instance and Docker containers.