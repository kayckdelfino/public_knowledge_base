# azure-vnet

## Overview

This Terraform project provisions an Azure Virtual Network (VNet) along with associated resources, including a subnet and a Network Security Group (NSG). The project uses Azure Remote State to store and reference VNet details.

## File Structure

- **`main.tf`**: Configures required providers, Azure backend, and Azure provider.
- **`network.tf`**: Defines Azure resources for the Virtual Network, Subnet, Network Security Group, and their associations.
- **`outputs.tf`**: Specifies output variables for the Subnet ID and Network Security Group ID.
- **`variables.tf`**: Declares input variables for customization.
- **`locals.tf`**: Defines local variables, such as common tags.

## Azure Virtual Network Configuration

- Creates a Resource Group, Virtual Network, Subnet, Network Security Group, and associates them.

## Input Variables

- **`location`**: Region where resources will be created in Azure (default: West Europe).

## Output Variables

- **`subnet_id`**: ID of the Subnet created in Azure.
- **`security_group_id`**: ID of the Network Security Group created in Azure.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the Azure resources, including the Virtual Network, Subnet, and Network Security Group.
4. Retrieve the output variables `subnet_id` and `security_group_id` for use in other modules or external configurations.
5. Optionally, review and customize Azure region, VNet address space, subnet address prefixes, NSG rules, and other configurations in `network.tf` and `variables.tf`.

## Important Notes

- Adjust the VNet and subnet configurations, address spaces, and NSG rules as needed in `network.tf`.
- Ensure proper Azure credentials and authentication are set up.