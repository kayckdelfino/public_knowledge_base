# splat-expressions-aws-vpc

## Overview

This Terraform module creates an AWS VPC and three subnets using splat expressions to generate multiple subnets. The `main.tf` file sets up the main module with required providers and backend configuration, while the `network.tf` file defines the AWS VPC and subnets. The `outputs.tf` file defines an output variable that provides the IDs of the created subnets.

## File Structure

### `main.tf`

- Sets up the main module with required providers and backend configuration.
- Creates an AWS VPC and subnets using splat expressions.

### `network.tf`

- Defines an AWS VPC and three subnets using a count and splat expressions.
- Creates subnets with CIDR blocks like 10.0.0.0/24, 10.0.1.0/24, 10.0.2.0/24.

### `outputs.tf`

- Defines an output variable that provides the IDs of the created subnets.

## Resources

### `aws_vpc.vpc`

- Creates an AWS VPC with the CIDR block 10.0.0.0/16.

### `aws_subnet.subnet`

- Creates three subnets in the VPC with CIDR blocks 10.0.0.0/24, 10.0.1.0/24, 10.0.2.0/24 using splat expressions.

## Output

### `subnets_id`

- IDs of the subnets created in AWS using the splat expression.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory.
3. Run `terraform init` to initialize the working directory.
4. Execute `terraform validate` to validate the configurations.
5. Execute `terraform apply` to apply the changes and create the VPC and subnets.
6. Monitor the AWS console to verify the created resources.