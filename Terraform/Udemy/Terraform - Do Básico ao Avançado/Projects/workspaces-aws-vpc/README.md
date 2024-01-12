# workspaces-aws-vpc

## Overview

This Terraform configuration sets up an AWS VPC with subnets, utilizing Terraform workspaces. The VPC and subnet names include the workspace name for isolation. The backend is configured to use an S3 bucket for storing the Terraform state.

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

### `network.tf`

- Creates an AWS VPC with subnet(s) based on the workspace name.
- The VPC name includes the workspace name for isolation.
- The number of subnets depends on the workspace:
  - For the "prod" workspace, it creates 3 subnets.
  - For other workspaces, it creates 1 subnet.

## Configuration

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory.
3. Run `terraform init` to initialize the working directory and download required modules.
4. Execute `terraform validate` to validate the configurations.
5. Execute `terraform workspace new <workspace_name>` to create a new workspace (e.g., `prod`).
6. Execute `terraform apply` to apply the changes and create the AWS resources for the specified workspace.
7. Monitor the console output for any errors or warnings.
8. Customize the configuration based on your requirements.
9. Repeat steps 5-8 for additional workspaces as needed.