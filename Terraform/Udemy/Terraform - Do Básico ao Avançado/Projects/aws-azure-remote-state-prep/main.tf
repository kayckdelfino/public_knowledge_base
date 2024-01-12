# Terraform settings and required providers
terraform {
  required_version = ">= 1.3.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.60.0"
    }

    azurerm = {
      source  = "hashicorp/azurerm"
      version = "3.49.0"
    }
  }
}

# AWS Provider Configuration
provider "aws" {
  region = "eu-central-1"

  default_tags {
    tags = local.common_tags
  }
}

# Azure Provider Configuration
provider "azurerm" {
  features {}
}