# terraform-data-azure-vm

## Overview

This Terraform configuration sets up an Azure Resource Group, creates an Azure Storage Account, and provisions an Azure VM. The VM configuration includes a public IP, network interface, and security group association. The state is stored remotely in an Azure Storage Account. It utilizes local variables for common tags and references data from remote states.

## File Structure

### `locals.tf`

- Defines local variables, such as `common_tags`, used across the Terraform configuration.

### `main.tf`

- Sets up the main module with required providers, backend configuration, and references data from remote states.
- Creates an Azure Storage Account and defines a Terraform data block.
- Specifies the required version for Terraform (>= 1.3.0).
- Declares the AzureRM provider with version 3.49.0.
- Configures an AzureRM backend for remote state storage, storing state in the specified Azure Storage Account and container.

### `provider "azurerm"` Block

- Specifies the AzureRM provider configuration with enabled features.

### `data "terraform_remote_state" "vnet"` Block

- Retrieves information from the remote state of the Azure VNet.

### `outputs.tf`

- Defines output variables providing information about the created Azure resources.

### `resource "azurerm_storage_account"` Block

- Creates an Azure Storage Account named "kayckdelfinotesteb" in the specified resource group and location.

### `resource "terraform_data" "data"` Block

- Defines a Terraform data block and a null_resource block with triggers.
- Establishes a connection to the Azure VM and writes information to a file.

### `resource "null_resource" "null"` Block

- Creates a null_resource block with triggers.
- Establishes a connection to the Azure VM and writes information to a file.

### `resource "terraform_data" "variable_trigger"` Block

- Defines a Terraform data block triggered by a variable.

### `variables.tf`

- Defines variables, such as `location` and `infra_version`, used in the Terraform configuration.

### `vm.tf`

- Creates an Azure VM with related resources, including a public IP, network interface, and security group association.

## Configuration

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory.
3. Run `terraform init` to initialize the working directory.
4. Execute `terraform validate` to validate the configurations.
5. If using remote state storage, configure the Azure backend with appropriate details.
6. Execute `terraform apply` to apply the changes and create the Azure resources.
7. Monitor the console output for any errors or warnings.
8. Customize the configuration based on your requirements.