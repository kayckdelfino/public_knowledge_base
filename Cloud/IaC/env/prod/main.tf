module "aws-prod" {
  source ="../../infra"
  instance = "t2.micro"
  aws_region = "us-east-1"
  key = "IaC-PROD"
}

output "IP" {
  value = module.aws-prod.public_IP
}