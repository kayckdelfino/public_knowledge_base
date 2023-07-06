module "prod" {
  source = "../../infra"

  repoName = "PROD"
  iamRole = "PROD"
}

output "IP_alb" {
  value = module.prod.IP
}