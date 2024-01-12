# Use the terraform_remote_state data source to fetch information from the AWS VPC state file stored remotely
data "terraform_remote_state" "vpc" {
  backend = "s3"
  config  = {
    bucket = "kayckdelfino-remote-state"
    key    = "aws-vpc/terraform.tfstate"
    region = "eu-central-1"
  }
}