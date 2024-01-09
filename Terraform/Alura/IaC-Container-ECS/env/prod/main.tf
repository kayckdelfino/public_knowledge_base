module "prod" {
  source = "../../infra"

  repoName = "PROD"
  iamRole = "PROD"
  env = "PROD"
}

output "IP_alb" {
  value = module.prod.IP
}