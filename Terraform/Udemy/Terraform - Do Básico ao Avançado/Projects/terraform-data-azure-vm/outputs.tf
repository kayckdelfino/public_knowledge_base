# Defines output variables providing information about the created Azure resources.
output "vm_ip" {
  description = "IP of the VM created in Azure"
  value       = azurerm_linux_virtual_machine.vm.public_ip_address
}