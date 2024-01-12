# Output the ID of the Subnet created in AWS
output "subnet_id" {
  description = "ID of the Subnet created in AWS"
  value       = aws_subnet.subnet.id
}

# Output the ID of the Security Group created in AWS
output "security_group_id" {
  description = "ID of the Security Group created in AWS"
  value       = aws_security_group.security_group.id
}