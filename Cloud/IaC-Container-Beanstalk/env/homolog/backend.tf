terraform {
  backend "s3" {
    bucket = "terraform-state-kayckdelfino"
    key    = "homolog/terraform.tfstate"
    region = "us-east-1"
  }
}