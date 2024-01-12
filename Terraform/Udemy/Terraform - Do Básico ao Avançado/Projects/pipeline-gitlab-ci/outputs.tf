# Output the public IP of the AWS virtual machine
output "vm_aws_ip" {
  description = "Public IP of the virtual machine created in AWS"
  value       = aws_instance.vm.public_ip
}

# Output the public IP of the Azure virtual machine
output "vm_azure_ip" {
  description = "Public IP of the virtual machine created in Azure"
  value       = azurerm_linux_virtual_machine.vm.public_ip_address
}