# Input variables
variable "aws_key_pub" {
  description = "Public key for the machine in AWS"
  type        = string
}

variable "azure_key_pub" {
  description = "Public key for the machine in Azure"
  type        = string
}