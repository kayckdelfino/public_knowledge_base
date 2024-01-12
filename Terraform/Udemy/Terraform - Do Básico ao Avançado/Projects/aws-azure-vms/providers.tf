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