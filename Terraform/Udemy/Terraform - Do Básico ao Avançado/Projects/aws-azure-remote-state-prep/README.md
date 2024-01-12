# aws-azure-remote-state-prep

## Overview

This Terraform project focuses on the creation of AWS S3 buckets for remote state management and Azure Storage resources, including a Resource Group, Storage Account, and Storage Container. The AWS S3 bucket is configured with versioning enabled.

## File Structure

- **`bucket.tf`**: Defines the AWS S3 bucket and enables versioning.
- **`locals.tf`**: Declares local variables, including common tags for resources.
- **`main.tf`**: Specifies Terraform settings, required providers, and their versions.
- **`storage_account.tf`**: Describes the Azure Storage Account, Resource Group, and Storage Container configuration.
- **`variables.tf`**: Defines input variables for Azure region, Storage Account tier, and replication type.

## AWS Configuration

- Sets up an AWS S3 bucket with versioning enabled.

## Azure Configuration

- Creates an Azure Resource Group, Storage Account, and Storage Container for Terraform state storage.

## Variables

- **`location`**: Azure region where resources will be created.
- **`account_tier`**: Storage Account tier in Azure.
- **`account_replication_type`**: Storage Account data replication type.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Update variables in `variables.tf` as needed.
3. Run `terraform init` to initialize the working directory.
4. Execute `terraform apply` to create the AWS S3 bucket and Azure Storage resources.

## Important Notes

- Review and customize tags in `locals.tf` to suit your requirements.
- Verify AWS region in `provider "aws"` configuration in `main.tf`.
- Ensure all dependencies, including remote state configurations, are correctly set up.