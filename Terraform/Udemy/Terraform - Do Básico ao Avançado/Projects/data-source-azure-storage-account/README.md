# data-source-azure-storage-account

## Overview

This Terraform project configures an Azure Storage Account and Container for images, along with a resource group to manage the infrastructure. The project leverages Terraform backend with Azure Storage for remote state storage.

## File Structure

- **`locals.tf`**: Defines local variables, including common tags.
- **`main.tf`**: Specifies Terraform settings, required providers, and Azure backend for remote state storage.
- **`outputs.tf`**: Declares output variables to display the SAS Token and URL of the images container.
- **`storage_account.tf`**: Creates Azure resources, including a resource group, storage account, and storage container.
- No `variables.tf` file is present, as variables are directly defined within the respective `.tf` files.

## Azure Storage Account Configuration

- Creates an Azure Resource Group named "rg-data-source" in the "West Europe" region.
- Deploys an Azure Storage Account named "kayckdelfinodatasource" with standard performance and locally redundant storage.
- Configures a storage container named "images" with blob access.

## SAS Token Configuration

- Utilizes a data source to generate a Shared Access Signature (SAS) Token for the "imagens" container.
- Sets IP restrictions to allow access only from the specified IP address (201.248.242.30).
- Defines permissions for read, add, create, write, delete, and list operations.
- Specifies the start and expiry dates for the SAS Token.

## Outputs

- Displays the SAS Token for the images container.
- Provides the URL of the images container.

## Usage

1. Ensure you have Terraform installed (version 1.4.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the Azure Storage Account and container.
4. Review the outputs to obtain the SAS Token and URL of the created container.

## Remote State Storage

- Remote state is stored in an Azure Storage Account with the specified configuration.
- Ensure appropriate Azure credentials and permissions are configured for remote state storage.

## Important Notes

- Adjust the resource names, location, and other configurations in `storage_account.tf` to suit your specific requirements.
- Verify the Azure provider version in `main.tf` to ensure compatibility.