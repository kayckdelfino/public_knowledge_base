module "aws-prod" {
  source        = "../../infra"
  instance      = "t2.micro"
  aws_region    = "us-east-1"
  key           = "IaC-PROD"
  securityGroup = "PROD"
  min           = 1
  max           = 10
  groupName     = "PROD"
  producao      = true
}