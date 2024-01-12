# Defines an AWS VPC and three subnets using a count and splat expressions
# It creates subnets with CIDR blocks like 10.0.0.0/24, 10.0.1.0/24, 10.0.2.0/24
resource "aws_vpc" "vpc" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "vpc-terraform"
  }
}

resource "aws_subnet" "subnet" {
  count = 3

  vpc_id     = aws_vpc.vpc.id
  cidr_block = "10.0.${count.index}.0/24"

  tags = {
    Name = "subnet-terraform-${count.index}"
  }
}