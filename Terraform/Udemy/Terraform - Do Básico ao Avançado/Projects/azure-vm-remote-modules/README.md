# azure-vm-remote-modules

## Overview

This Terraform project deploys an Azure Linux Virtual Machine (VM) along with networking components. The networking resources are modularized using the Azure Network module from the `Azure/network/azurerm` source. The VM is configured with a specific OS image, size, and SSH key.

## File Structure

- **`main.tf`**: Configures required providers, Azure backend, Azure provider, and includes the Azure Network module instantiation.
- **`outputs.tf`**: Specifies output variables for the VM's public IP.
- **`variables.tf`**: Declares input variables for customization.
- **`vm.tf`**: Defines Azure resources for the VM, including Resource Group, Public IP, Network Interface, Security Group association, and Linux Virtual Machine.
- **`locals.tf`**: Defines local variables, such as common tags.
- **`network.tf`**: Azure Network module configuration for creating a Network Security Group and associating it with a subnet.
- **`docs/docker.sh`**: Bash script for Docker installation (referenced in the VM configuration).

## Azure Linux Virtual Machine Configuration

- Creates a Resource Group, Public IP, Network Interface, Security Group association, and deploys a Linux Virtual Machine.
- The VM depends on the successful association of the Network Interface with the Security Group.

## Azure Network Module

- Modularizes the creation of a Network Security Group and its association with a subnet.
- Supports customization of subnet names, tags, and other configurations.

## Input Variables

- **`location`**: Region where resources will be created in Azure (default: West Europe).
- **`environment`**: Environment to which the resources belong in Azure (default: development).

## Output Variables

- **`vm_ip`**: Public IP of the VM created in Azure.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the Azure resources, including the Linux VM.
4. Retrieve the output variable `vm_ip` for connecting to the VM.
5. Optionally, review and customize Azure region, VM size, OS image, and other configurations in `main.tf` and `variables.tf`.

## Important Notes

- Review the Bash script `docker.sh` in the `docs` directory for Docker installation details.
- Adjust the VM configuration, including size, OS image, and SSH key, as needed in `vm.tf`.
- Ensure proper Azure credentials and authentication are set up.
- Be cautious with custom data/scripts to avoid security vulnerabilities.