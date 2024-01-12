# Terraform settings and required providers
terraform {
  required_version = "~> 1.0.0"

  required_providers {
    aws = {
        version = "1.0"
        source = "hashicorp/aws"
    }

    azurerm = {
        version = "2.0"
        source = "hashicorp/azurerm"
    }
  }

  backend "azurerm" {}
}