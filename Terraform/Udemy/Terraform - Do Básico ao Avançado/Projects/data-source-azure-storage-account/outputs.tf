# Output the SAS Token for the images container
output "sas_token" {
  description = "SAS Token for the images container"
  value       = data.azurerm_storage_account_blob_container_sas.sas_token.sas
}

# Output the URL of the images container
output "container_url" {
  description = "URL of the images container"
  value       = azurerm_storage_container.container.id
}