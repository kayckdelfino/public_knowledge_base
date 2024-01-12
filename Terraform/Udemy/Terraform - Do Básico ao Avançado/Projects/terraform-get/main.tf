# Terraform settings and required providers
terraform {
  required_version = ">= 1.3.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.61.0"
    }
  }
}

provider "aws" {
  region = "eu-central-1"
}

# Use the terraform-aws-modules/vpc module to create a VPC
module "vpc" {
  source  = "terraform-aws-modules/vpc/aws"
  version = "2.1.0"
}

# Use the terraform-aws-modules/s3-bucket module to create an S3 bucket
module "s3-bucket" {
  source  = "terraform-aws-modules/s3-bucket/aws"
  version = "3.8.2"
}

# Use the terraform-aws-modules/security-group module to create a security group
module "security-group" {
  source  = "terraform-aws-modules/security-group/aws"
  version = "4.17.1"
}