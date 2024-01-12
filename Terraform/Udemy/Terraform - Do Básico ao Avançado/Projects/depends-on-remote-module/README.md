# depends-on-remote-module

## Overview

This Terraform project sets up an Azure infrastructure for a virtual machine (VM) with associated networking components, including a Virtual Network, Network Security Group (NSG), and more. The project uses Azure Storage for remote state storage.

## File Structure

- **`locals.tf`**: Defines local variables, including common tags.
- **`main.tf`**: Specifies Terraform settings, required providers, and Azure backend for remote state storage.
- **`outputs.tf`**: Declares an output variable to display the IP address of the created VM.
- **`variables.tf`**: Defines variables for the Azure region and environment.
- **`vm.tf`**: Configures the Azure resources for the VM, including the resource group, public IP, network interface, and the VM itself.
- **`network.tf`**: Creates a Network Security Group (NSG) and associates it with a subnet in the specified environment.

## Azure Infrastructure Configuration

### Network Security Group (NSG)

- Creates an NSG with a security rule allowing inbound SSH traffic on port 22.
- Associates the NSG with the subnet used by the VM.

### Virtual Machine (VM)

- Deploys a Linux VM with the specified configuration, including the OS image, size, and SSH key.
- Associates the VM with the NSG and network interface.

### Outputs

- Displays the public IP address of the created VM.

### Usage

1. Ensure you have Terraform installed (version 1.3.0 or later).
2. Navigate to the project directory and run `terraform init` to initialize the working directory.
3. Execute `terraform apply` to create the Azure infrastructure.
4. Review the output to obtain the public IP address of the VM.

### Remote State Storage

- Remote state is stored in an Azure Storage Account with the specified configuration.
- Ensure appropriate Azure credentials and permissions are configured for remote state storage.

### Important Notes

- Customize variables in `variables.tf` and adjust resource configurations in `vm.tf` and `network.tf` to meet specific requirements.
- Verify the Azure provider version in `main.tf` to ensure compatibility.