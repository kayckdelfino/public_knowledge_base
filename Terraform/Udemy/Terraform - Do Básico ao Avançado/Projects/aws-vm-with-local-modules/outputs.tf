# Output variable for the VM module
output "vm_ip" {
  description = "IP of the VM created in AWS"
  value       = aws_instance.vm.public_ip
}