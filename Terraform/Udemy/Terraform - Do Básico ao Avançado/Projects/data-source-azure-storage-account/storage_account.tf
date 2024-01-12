# Resource Group for the storage account
resource "azurerm_resource_group" "rg" {
  name     = "rg-data-source"
  location = "West Europe"

  tags = local.common_tags
}

# Storage Account for images
resource "azurerm_storage_account" "storage" {
  name                     = "kayckdelfinodatasource"
  resource_group_name      = azurerm_resource_group.rg.name
  location                 = azurerm_resource_group.rg.location
  account_tier             = "Standard"
  account_replication_type = "LRS"

  tags = local.common_tags
}

# Storage Container for images
resource "azurerm_storage_container" "container" {
  name                  = "images"
  storage_account_name  = azurerm_storage_account.storage.name
  container_access_type = "blob"
}

# Data source for SAS Token of the storage container
data "azurerm_storage_account_blob_container_sas" "sas_token" {
  connection_string = azurerm_storage_account.storage.primary_connection_string
  container_name    = azurerm_storage_container.container.name
  https_only        = true

  ip_address = "201.248.242.30"

  start  = "2023-08-15"
  expiry = "2023-09-15"

  permissions {
    read   = true
    add    = true
    create = true
    write  = true
    delete = true
    list   = true
  }
}