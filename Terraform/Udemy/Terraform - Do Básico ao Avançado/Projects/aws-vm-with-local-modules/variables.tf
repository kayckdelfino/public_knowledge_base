# Input variable for the VM module
variable "environment" {
  description = "Environment to which the resources belong in AWS"
  type        = string
  default     = "development"
}