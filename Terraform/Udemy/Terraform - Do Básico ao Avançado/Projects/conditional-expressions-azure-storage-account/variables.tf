# Variables for Azure region and environment
variable "location" {
  description = "Region where resources will be created in Azure"
  type        = string
  default     = "West Europe"
}

variable "environment" {
  description = "Environment in which resources will be created in Azure"
  type        = string
}