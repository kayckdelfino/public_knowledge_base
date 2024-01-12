# Input variables for the network module
variable "cidr_vpc" {
  description = "CIDR for the VPC created in AWS"
  type        = string
}

variable "cidr_subnet" {
  description = "CIDR for the Subnet created in AWS"
  type        = string
}

variable "environment" {
  description = "Environment to which the resources belong in AWS"
  type        = string
}