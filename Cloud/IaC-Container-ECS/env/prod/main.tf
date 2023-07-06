module "prod" {
  source = "../../infra"

  repoName = "PROD"
  iamRole = "PROD"
}