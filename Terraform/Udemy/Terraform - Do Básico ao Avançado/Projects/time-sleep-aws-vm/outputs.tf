# Output the public IPs of the two instances
output "vm_1_ip" {
  description = "IP of the VM created in AWS"
  value       = aws_instance.vm_1.public_ip
}

output "vm_2_ip" {
  description = "IP of the VM created in AWS"
  value       = aws_instance.vm_2.public_ip
}