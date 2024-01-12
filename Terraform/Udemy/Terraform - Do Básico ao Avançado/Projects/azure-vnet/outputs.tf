# Outputs
output "subnet_id" {
  description = "ID of the Subnet created in Azure"
  value       = azurerm_subnet.subnet.id
}

output "security_group_id" {
  description = "ID of the Network Security Group created in Azure"
  value       = azurerm_network_security_group.nsg.id
}