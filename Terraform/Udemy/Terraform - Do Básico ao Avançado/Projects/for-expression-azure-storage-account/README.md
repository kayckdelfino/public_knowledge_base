# for-expression-azure-storage-account

## Overview

This Terraform project creates Azure resources, including resource groups, storage accounts, and storage containers, in different regions. The project utilizes Azure backend for remote state storage.

## File Structure

- **`main.tf`**: Specifies Terraform settings, required providers, and Azure backend for remote state storage.
- **`storage_account.tf`**: Defines the creation of resource groups, storage accounts, and storage containers for each specified region.
- **`outputs.tf`**: Declares output variables to display the IDs and primary access keys of the created storage accounts.
- **`variables.tf`**: Defines variables for regions, storage account tier, and storage account replication type.
- **`locals.tf`**: Contains local variables for common tags.

## Azure Infrastructure Configuration

### Resource Groups

- **Resource Groups**: Creates resource groups for each specified region.

### Storage Accounts and Containers

- **Storage Accounts**: Establishes storage accounts in each region with the specified tier and replication type.
- **Storage Containers**: Configures storage containers within each storage account.

### Outputs

- Displays the IDs of the created storage accounts for each region.
- Displays the primary access keys of the created storage accounts for each region (sensitive).

### Usage

1. Ensure you have Terraform installed (version 1.0.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the Azure infrastructure.
4. Review the output to obtain the storage account IDs and primary access keys.

### Remote State Storage

- Remote state is stored in Azure Storage with the specified configuration.
- Ensure appropriate Azure credentials and permissions are configured for remote state storage.

### Important Notes

- Customize variables in `variables.tf` to adjust the regions, storage account tier, and replication type.
- Ensure the required providers and their versions are compatible with the Terraform version.