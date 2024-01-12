# Variable for defining regions and their names
variable "location" {
  description = "Region where resources will be created in Azure"
  type        = map(string)
  default = {
    "europa" = "West Europe",
    "eua"    = "East US",
    "asia"   = "Japan East",
    "brasil" = "Brazil South"
  }
}

# Variable for defining the tier of the Storage Account in Azure
variable "account_tier" {
  description = "Tier of the Storage Account in Azure"
  type        = string
  default     = "Standard"
}

# Variable for defining the replication type of the Storage Account in Azure
variable "account_replication_type" {
  description = "Data replication type of the Storage Account"
  type        = string
  default     = "LRS"
}