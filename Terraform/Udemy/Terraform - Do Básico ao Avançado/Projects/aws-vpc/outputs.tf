# Output variables for other modules or external use
output "subnet_id" {
  description = "ID of the Subnet created in AWS"
  value       = aws_subnet.subnet.id
}

output "security_group_id" {
  description = "ID of the Security Group created in AWS"
  value       = aws_security_group.security_group.id
}