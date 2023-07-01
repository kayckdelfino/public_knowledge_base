module "prod" {
  source = "../../infra"

  appName = "prod"
  desc = "prod-application"
  max = 5
  mType = "t2.micro"
  environment = "prod-environment"
}