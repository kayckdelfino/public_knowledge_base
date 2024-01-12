# Defines the output variables for VPC Terraform module
output "vpc_id_default" {
  description = "ID of the VPC created in AWS in the default region"
  value       = aws_vpc.default.id
}

output "vpc_id_provider_1" {
  description = "ID of the VPC created in AWS in the region of provider 1"
  value       = aws_vpc.provider_1.id
}

output "vpc_id_provider_2" {
  description = "ID of the VPC created in AWS in the region of provider 2"
  value       = aws_vpc.provider_2.id
}