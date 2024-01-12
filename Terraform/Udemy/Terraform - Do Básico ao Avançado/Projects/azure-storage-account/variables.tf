# Input variables
variable "location" {
  description = "Region where resources will be created in Azure"
  type        = string
  default     = "West Europe"
}

variable "account_tier" {
  description = "Tier of the Storage Account in Azure"
  type        = string
  default     = "Standard"
}

variable "account_replication_type" {
  description = "Type of data replication for the Storage Account in Azure"
  type        = string
  default     = "LRS"
}

variable "resource_group_name" {
  description = "Name for the Resource Group in Azure"
  type        = string
  default     = "rg-curso-terraform"
}

variable "storage_account_name" {
  description = "Name of the Storage Account in Azure"
  type        = string
  default     = "kayckdelfinoterraform"
}

variable "container_name" {
  description = "Name of the Container in Azure"
  type        = string
  default     = "container-terraform"
}