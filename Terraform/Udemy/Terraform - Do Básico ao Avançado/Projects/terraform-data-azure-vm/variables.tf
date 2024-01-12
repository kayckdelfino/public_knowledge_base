# Defines variables, such as location and infra_version, used in the Terraform configuration.
variable "location" {
  description = "Region where resources will be created in Azure"
  type        = string
  default     = "West Europe"
}

variable "infra_version" {
  description = "Infrastructure version"
  type        = number
  default     = 2
}