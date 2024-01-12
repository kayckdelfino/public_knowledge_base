# Outputs
output "vm_ip" {
  description = "IP of the VM created in Azure"
  value       = azurerm_linux_virtual_machine.vm.public_ip_address
}