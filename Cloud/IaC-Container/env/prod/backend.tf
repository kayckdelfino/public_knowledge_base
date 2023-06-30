terraform {
  backend "s3" {
    bucket = "terraform-state-kayckdelfino"
    key = "prod/terraform.tfstate"
    region = "us-east-1"
  }
}