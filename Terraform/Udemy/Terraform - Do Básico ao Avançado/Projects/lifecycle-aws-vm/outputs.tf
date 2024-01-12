# Output the public IP address of the AWS VM
output "vm_ip" {
  description = "Public IP of the VM created in AWS"
  value       = aws_instance.vm.public_ip
}