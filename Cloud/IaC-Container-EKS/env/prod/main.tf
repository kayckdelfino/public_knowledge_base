module "prod" {
  source = "../../infra"

  repoName = "PROD"
  clusterName = "PROD"
}

output "address" {
  value = module.prod.URL
}