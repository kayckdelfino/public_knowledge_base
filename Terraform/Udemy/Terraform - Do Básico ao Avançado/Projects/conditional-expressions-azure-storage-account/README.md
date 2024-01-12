# conditional-expressions-azure-storage-account

## Overview

This Terraform project provisions an Azure Storage Account within a specified environment and region. The environment determines whether the storage account is created based on certain conditions. The project also creates an Azure Resource Group for organizational purposes.

## File Structure

- **`main.tf`**: Configures the required providers and Terraform settings.
- **`storage_account.tf`**: Defines the Azure resources, including a Resource Group and a Storage Account with conditional expressions.
- **`variables.tf`**: Declares input variables for customization.
- **`locals.tf`**: Defines local variables, such as common tags.

## Azure Storage Account Configuration

- Creates an Azure Resource Group based on the specified environment.
- Creates an Azure Storage Account with configurable settings, including account tier and replication type. The Storage Account creation is conditional based on the environment.

## Input Variables

- **`location`**: Region where resources will be created in Azure (default: West Europe).
- **`environment`**: Environment in which resources will be created in Azure.

## Usage

1. Ensure you have Terraform installed (version 1.0.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the Azure resources, including the Resource Group and Storage Account based on the specified conditions.
4. Optionally, review and customize Azure region, environment, storage account name, tier, replication type, and other configurations in `storage_account.tf` and `variables.tf`.

## Important Notes

- Adjust the conditions and configurations in `storage_account.tf` to suit your specific requirements.
- Ensure proper Azure credentials and authentication are set up.