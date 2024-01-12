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
    key                  = "azure-vm/terraform.tfstate"
  }
}

# Azure Provider Configuration
provider "azurerm" {
  features {}
}

# Azure Remote State Data Source
data "terraform_remote_state" "vnet" {
  backend = "azurerm"
  config = {
    resource_group_name  = "rg-terraform-state"
    storage_account_name = "kayckdelfinoterraformstate"
    container_name       = "remote-state"
    key                  = "azure-vnet/terraform.tfstate"
  }
}