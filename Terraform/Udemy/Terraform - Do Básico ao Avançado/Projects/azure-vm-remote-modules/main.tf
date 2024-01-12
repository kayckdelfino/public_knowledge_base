# Terraform settings and required providers
terraform {
  required_version = ">= 1.3.0"

  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "3.49.0"
    }
  }

  # Azure Backend Configuration
  backend "azurerm" {
    resource_group_name  = "rg-terraform-state"
    storage_account_name = "kayckdelfinoterraformstate"
    container_name       = "remote-state"
    key                  = "azure-vm-modulos-remotos/terraform.tfstate"
  }
}

# Azure Provider Configuration
provider "azurerm" {
  features {}
}

# Azure Network Module
module "network" {
  source  = "Azure/network/azurerm"
  version = "5.2.0"

  # Module Configuration
  resource_group_name     = azurerm_resource_group.resource_group.name
  use_for_each            = true
  resource_group_location = var.location
  subnet_names            = ["subnet-${var.environment}"]
  tags                    = local.common_tags
  vnet_name               = "vnet-${var.environment}"
}