# local-state

## Overview

This Terraform project creates an AWS S3 bucket and includes settings, required providers, and outputs to display the bucket ID and ARN. The project focuses on local state storage without using any backend configurations.

## File Structure

- **`main.tf`**: Specifies Terraform settings, required providers (AWS), and AWS region.
- **`bucket.tf`**: Defines the creation of an AWS S3 bucket.
- **`outputs.tf`**: Declares output variables to display the ID and ARN of the created S3 bucket.

## AWS Infrastructure Configuration

### S3 Bucket

- **Bucket Creation**: Creates an S3 bucket with a specified name.

### Outputs

- Displays the ID of the created S3 bucket.
- Displays the ARN of the created S3 bucket.

### Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the AWS S3 bucket.
4. Review the output to obtain the ID and ARN of the S3 bucket.

### Important Notes

- Customize variables in `variables.tf` if needed, e.g., AWS region.
- The project uses local state storage; no backend configuration is specified.
- Adjust configurations based on specific requirements.