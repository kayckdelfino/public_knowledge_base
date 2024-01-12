# Variable for defining ports and their descriptions in the Security Group
variable "ports" {
  description = "Ports to be opened in the Security Group"
  type = map(object({
    description = string
    cidr_blocks = list(string)
  }))
  default = {
    22 = {
      description = "Port 22 for VPN"
      cidr_blocks = ["20.15.101.158/32"]
    }
    80 = {
      description = "Port 80 for the internet"
      cidr_blocks = ["0.0.0.0/0"]
    }
    443 = {
      description = "Port 443 for the internet"
      cidr_blocks = ["0.0.0.0/0"]
    }
  }
}