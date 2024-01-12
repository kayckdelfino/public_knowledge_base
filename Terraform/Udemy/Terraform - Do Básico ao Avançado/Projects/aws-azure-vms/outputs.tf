# Output variables
output "vm_aws_ip" {
  description = "IP of the virtual machine created in AWS"
  value       = aws_instance.vm.public_ip
}

output "vm_azure_ip" {
  description = "IP of the virtual machine created in Azure"
  value       = azurerm_linux_virtual_machine.vm.public_ip_address
}