# Terraform settings and required providers
terraform {
  required_version = ">= 1.5.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "5.16.2"
    }

    azurerm = {
      source  = "hashicorp/azurerm"
      version = "3.72.0"
    }
  }

  backend "azurerm" {
    resource_group_name  = "rg-terraform-state"
    storage_account_name = "kayckdelfinoterraformstate"
    container_name       = "remote-state"
    key                  = "pipeline-gitlab/terraform.tfstate"
  }
}