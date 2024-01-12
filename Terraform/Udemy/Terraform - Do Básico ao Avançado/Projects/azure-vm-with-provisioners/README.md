# azure-vm-with-provisioners

## Overview

This Terraform project provisions an Azure Linux Virtual Machine (VM) along with networking components. It utilizes Azure Remote State for referencing VNet details and employs provisioners for local and remote commands during deployment. The VM is configured with a specific OS image, size, and SSH key.

## File Structure

- **`main.tf`**: Configures required providers, Azure backend, Azure provider, and includes the Azure Remote State Data Source.
- **`outputs.tf`**: Specifies output variables for the VM's public IP.
- **`variables.tf`**: Declares input variables for customization.
- **`vm.tf`**: Defines Azure resources for the VM, including Resource Group, Public IP, Network Interface, Security Group association, and Linux Virtual Machine. It also includes provisioners for local and remote execution.
- **`locals.tf`**: Defines local variables, such as common tags.

## Azure Linux Virtual Machine Configuration

- Creates a Resource Group, Public IP, Network Interface, Security Group association, and deploys a Linux Virtual Machine.
- Uses provisioners to execute local and remote commands during deployment.

## Input Variables

- **`location`**: Region where resources will be created in Azure (default: West Europe).

## Output Variables

- **`vm_ip`**: Public IP of the VM created in Azure.

## Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the Azure resources, including the Linux VM.
4. Retrieve the output variable `vm_ip` for connecting to the VM.
5. Optionally, review and customize Azure region, VM size, OS image, and other configurations in `main.tf` and `variables.tf`.

## Important Notes

- Adjust the VM configuration, including size, OS image, and SSH key, as needed in `vm.tf`.
- Ensure proper Azure credentials and authentication are set up.
- Be cautious with custom data/scripts to avoid security vulnerabilities.