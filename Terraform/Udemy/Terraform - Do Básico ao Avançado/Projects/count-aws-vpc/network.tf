# AWS VPC with a specified CIDR block
resource "aws_vpc" "vpc" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "vpc-terraform"
  }
}

# AWS Subnets with count to create 3 subnets in the specified CIDR block
resource "aws_subnet" "subnet" {
  count = 3

  vpc_id     = aws_vpc.vpc.id
  cidr_block = "10.0.${count.index}.0/24"

  tags = {
    Name = "subnet-terraform-${count.index}"
  }
}