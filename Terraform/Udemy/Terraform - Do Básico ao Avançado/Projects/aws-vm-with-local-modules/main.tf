# Terraform settings and required providers
terraform {
  required_version = ">= 1.3.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.60.0"
    }
  }

  backend "s3" {
    bucket = "kayckdelfino-remote-state"
    key    = "aws-vm-with-local-modules/terraform.tfstate"
    region = "eu-central-1"
  }
}

# AWS Provider Configuration
provider "aws" {
  region = "eu-central-1"

  default_tags {
    tags = {
      owner      = "kayckdelfino"
      managed-by = "terraform"
    }
  }
}

# Module for the network configuration
module "network" {
  source = "./network"

  cidr_vpc    = "10.0.0.0/16"
  cidr_subnet = "10.0.1.0/24"
  environment = var.environment
}