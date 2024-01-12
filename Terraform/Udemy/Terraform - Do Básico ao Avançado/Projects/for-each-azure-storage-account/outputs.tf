# Output the ID of the Storage Account created in Azure for each region
output "storage_account_europa_id" {
  description = "ID of the Storage Account created in Azure for Europa"
  value       = azurerm_storage_account.storage_account["europa"].id
}

output "storage_account_eua_id" {
  description = "ID of the Storage Account created in Azure for Eua"
  value       = azurerm_storage_account.storage_account["eua"].id
}

output "storage_account_asia_id" {
  description = "ID of the Storage Account created in Azure for Asia"
  value       = azurerm_storage_account.storage_account["asia"].id
}

output "storage_account_brasil_id" {
  description = "ID of the Storage Account created in Azure for Brasil"
  value       = azurerm_storage_account.storage_account["brasil"].id
}

# Output the Primary Access Key of the Storage Account created in Azure for each region
output "sa_primary_access_key_europa" {
  description = "Primary Access Key of the Storage Account created in Azure for Europa"
  value       = azurerm_storage_account.storage_account["europa"].primary_access_key
  sensitive   = true
}

output "sa_primary_access_key_eua" {
  description = "Primary Access Key of the Storage Account created in Azure for Eua"
  value       = azurerm_storage_account.storage_account["eua"].primary_access_key
  sensitive   = true
}

output "sa_primary_access_key_asia" {
  description = "Primary Access Key of the Storage Account created in Azure for Asia"
  value       = azurerm_storage_account.storage_account["asia"].primary_access_key
  sensitive   = true
}

output "sa_primary_access_key_brasil" {
  description = "Primary Access Key of the Storage Account created in Azure for Brasil"
  value       = azurerm_storage_account.storage_account["brasil"].primary_access_key
  sensitive   = true
}