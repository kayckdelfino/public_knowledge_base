# Outputs
output "storage_account_id" {
  description = "ID of the Storage Account created in Azure"
  value       = azurerm_storage_account.storage_account.id
}

output "sa_primary_access_key" {
  description = "Primary Access Key of the Storage Account created in Azure"
  value       = azurerm_storage_account.storage_account.primary_access_key
  sensitive   = true
}