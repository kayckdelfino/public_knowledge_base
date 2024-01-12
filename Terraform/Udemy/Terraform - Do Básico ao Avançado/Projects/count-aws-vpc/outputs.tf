# Output the IDs of the created subnets
output "subnet_0_id" {
  description = "ID of the subnet created in AWS"
  value       = aws_subnet.subnet[0].id
}

output "subnet_1_id" {
  description = "ID of the subnet created in AWS"
  value       = aws_subnet.subnet[1].id
}

output "subnet_2_id" {
  description = "ID of the subnet created in AWS"
  value       = aws_subnet.subnet[2].id
}