# provider-aws-vpc

## Overview

This Terraform module (`vpc`) creates AWS VPC resources with subnets in multiple regions using provider aliases. The root module (`root`) configures the main Terraform settings, backend configuration, and provider configurations for different AWS regions. The `network.tf` file defines AWS subnets in various regions using the VPCs created by the `vpc` module.

## VPC Module (`vpc`)

### File Structure

- **`main.tf`**: Specifies the required AWS provider versions and configuration aliases.
- **`outputs.tf`**: Defines output variables for the VPC Terraform module.
- **`vpc.tf`**: Creates AWS VPC resources using specified provider aliases.

### Resources

- **`aws_vpc.default`**: Creates a VPC in the default region.
- **`aws_vpc.provider_1`**: Creates a VPC in the region of provider 1.
- **`aws_vpc.provider_2`**: Creates a VPC in the region of provider 2.

### Outputs

- **`vpc_id_default`**: ID of the VPC created in AWS in the default region.
- **`vpc_id_provider_1`**: ID of the VPC created in AWS in the region of provider 1.
- **`vpc_id_provider_2`**: ID of the VPC created in AWS in the region of provider 2.

## Root Module (`root`)

### File Structure

- **`main.tf`**: Sets up the main module and specifies the backend configuration. Also defines AWS provider configurations for the default region and two additional regions.
- **`network.tf`**: Defines AWS subnets in different regions using the VPCs created in the VPC module.

### Provider Configurations

- **`aws` (Default Region)**: Configures the AWS provider for the default region (eu-central-1).
- **`aws.eua` (Provider 1)**: Configures the AWS provider for the region specified by the alias `eua` (us-east-1).
- **`aws.australia` (Provider 2)**: Configures the AWS provider for the region specified by the alias `australia` (ap-southeast-2).

### Module Invocation

- **`module "vpc"`**: Invokes the `vpc` module with provider configurations for regions specified by aliases.

### Subnets

- **`aws_subnet.europa`**: Creates a subnet in the default region using the VPC from the `vpc` module.
- **`aws_subnet.eua`**: Creates a subnet in the region of provider 1 using the VPC from the `vpc` module.
- **`aws_subnet.australia`**: Creates a subnet in the region of provider 2 using the VPC from the `vpc` module.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory.
3. Run `terraform init` to initialize the working directory.
4. Execute `terraform validate` to validate the configurations.
5. Execute `terraform apply` to apply the changes and create VPCs and subnets.
6. Monitor the AWS console to verify the created resources.