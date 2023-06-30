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

resource "aws_launch_template" "maquina" {
  image_id      = "ami-053b0d53c279acc90"
  instance_type = var.instance
  key_name      = var.key
  tags = {
    Name = "Teste AWS Terraform Ansible Python"
  }
  security_group_names = [var.securityGroup]
}

resource "aws_key_pair" "SSHkey" {
  key_name   = var.key
  public_key = file("${var.key}.pub")
}

resource "aws_autoscaling_group" "group" {
  availability_zones = ["${var.aws_region}a"]
  name               = var.groupName
  max_size           = var.max
  min_size           = var.min
  launch_template {
    id      = aws_launch_template.maquina.id
    version = "$Latest"
  }
}
