# Variable for the region where resources will be created in Azure
variable "location" {
  description = "Region where resources will be created in Azure"
  type        = string
  default     = "West Europe"
}

# Variable for the environment to which resources belong in Azure
variable "environment" {
  description = "Environment to which resources belong in Azure"
  type        = string
  default     = "development"
}