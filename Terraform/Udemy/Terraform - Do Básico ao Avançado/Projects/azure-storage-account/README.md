# azure-storage-account

## Overview

This Terraform project automates the deployment of an Azure Storage Account, including the configuration of a resource group, storage account, and storage container. It utilizes local variables, Azure provider settings, and output variables for storing the Storage Account ID and Primary Access Key. The project is designed to be flexible, allowing variable values to be specified through multiple methods, including `terraform.tfvars` and `terraform.auto.tfvars`.

## File Structure

- **`main.tf`**: Configures required providers, Azure provider settings, and defines Azure resource group, storage account, and storage container.
- **`locals.tf`**: Defines local variables, such as common tags for resources.
- **`outputs.tf`**: Specifies output variables for Storage Account ID and Primary Access Key.
- **`storage_account.tf`**: Configures Azure resource group, storage account, and storage container.
- **`variables.tf`**: Declares input variables for the project.
- **`terraform.tfvars`**: Provides variable values for different environments.
- **`terraform.auto.tfvars`**: Automatically loaded variable values.

## Azure Storage Account Configuration

- Creates an Azure Resource Group with specified name and location.
- Configures an Azure Storage Account with customizable settings (e.g., tier, replication type).
- Defines an Azure Storage Container within the storage account.

## Local Variables

- Defines common tags using local variables for resources.

## Output Variables

- **`storage_account_id`**: Outputs the ID of the created Azure Storage Account.
- **`sa_primary_access_key`**: Outputs the Primary Access Key of the created Azure Storage Account (sensitive).

## Usage

1. Ensure you have Terraform installed (version 1.0.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the Azure Storage Account and associated resources.
4. Retrieve output variables (`storage_account_id` and `sa_primary_access_key`) for further use.

## Variable Configuration

- Review and customize input variables in `variables.tf` based on specific requirements.
- Modify variable values in `terraform.tfvars` for environment-specific configurations.