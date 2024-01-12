# Input variables
variable "location" {
  description = "Region where resources will be created in Azure"
  type        = string
  default     = "West Europe"
}

variable "account_tier" {
  description = "Storage Account tier in Azure"
  type        = string
  default     = "Standard"
}

variable "account_replication_type" {
  description = "Storage Account data replication type"
  type        = string
  default     = "LRS"
}