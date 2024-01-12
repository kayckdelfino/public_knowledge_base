# Defines an output variable that provides the IDs of the created subnets.
output "subnets_id" {
  description = "IDs of the subnets created in AWS"
  value       = aws_subnet.subnet[*].id
}