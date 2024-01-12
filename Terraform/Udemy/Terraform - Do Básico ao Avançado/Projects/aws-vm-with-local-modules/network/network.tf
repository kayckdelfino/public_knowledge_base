# AWS VPC configuration
resource "aws_vpc" "vpc" {
  cidr_block = var.cidr_vpc

  tags = {
    Name = "vpc-${var.environment}"  # Tagging the VPC
  }
}

# AWS Subnet configuration
resource "aws_subnet" "subnet" {
  vpc_id     = aws_vpc.vpc.id
  cidr_block = var.cidr_subnet

  tags = {
    Name = "subnet-${var.environment}"  # Tagging the Subnet
  }
}

# AWS Internet Gateway configuration
resource "aws_internet_gateway" "internet_gateway" {
  vpc_id = aws_vpc.vpc.id

  tags = {
    Name = "internet-gateway-${var.environment}"  # Tagging the Internet Gateway
  }
}

# AWS Route Table configuration
resource "aws_route_table" "route_table" {
  vpc_id = aws_vpc.vpc.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.internet_gateway.id
  }

  tags = {
    Name = "route-table-${var.environment}"  # Tagging the Route Table
  }
}

# AWS Route Table Association configuration
resource "aws_route_table_association" "rta" {
  subnet_id      = aws_subnet.subnet.id
  route_table_id = aws_route_table.route_table.id
}

# AWS Security Group configuration
resource "aws_security_group" "security_group" {
  name        = "security-group-${var.environment}"  # Naming the Security Group
  description = "Allow access on port 22"
  vpc_id      = aws_vpc.vpc.id

  ingress {
    description = "SSH"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "security-group-${var.environment}"  # Tagging the Security Group
  }
}