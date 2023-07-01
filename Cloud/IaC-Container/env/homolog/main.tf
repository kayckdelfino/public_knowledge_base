module "homolog" {
  source = "../../infra"

  appName = "homolog"
  desc = "homolog-application"
  max = 3
  mType = "t2.micro"
  environment = "homolog-environment"
}