module "aws-dev" {
  source        = "../../infra"
  instance      = "t2.micro"
  aws_region    = "us-east-1"
  key           = "IaC-DEV"
  securityGroup = "DEV"
  min           = 0
  max           = 1
  groupName     = "DEV"
  producao      = false
}