terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.16"
    }
  }

  required_version = ">= 1.2.0"
}

provider "aws" {
  region = var.aws_region
}

resource "aws_instance" "app_server" {
  ami           = "ami-053b0d53c279acc90"
  instance_type = var.instance
  key_name      = var.key

  tags = {
    Name = "Teste AWS Terraform Ansible Python"
  }
}

resource "aws_key_pair" "SSHkey" {
  key_name   = var.key
  public_key = file("${var.key}.pub")
}

output "public_IP" {
  value = aws_instance.app_server.public_ip
}