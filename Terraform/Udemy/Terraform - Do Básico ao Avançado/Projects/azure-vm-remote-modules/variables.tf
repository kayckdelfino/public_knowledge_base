# Variables
variable "location" {
  description = "Region where the resources will be created in Azure"
  type        = string
  default     = "West Europe"
}

variable "environment" {
  description = "Environment to which the resources belong in Azure"
  type        = string
  default     = "development"
}