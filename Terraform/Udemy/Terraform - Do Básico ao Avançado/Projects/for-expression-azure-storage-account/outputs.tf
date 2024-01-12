# Output the IDs of the Storage Accounts created in Azure
output "storage_accounts_id" {
  description = "IDs of the Storage Accounts created in Azure"
  value       = [for sa in azurerm_storage_account.storage_account : sa.id]
}

# Output the Primary Access Keys of the Storage Accounts created in Azure
output "sa_primary_access_keys" {
  description = "Primary Access Keys of the Storage Accounts created in Azure"
  value       = { for chave, sa in azurerm_storage_account.storage_account : chave => sa.primary_access_key }
  sensitive   = true
}