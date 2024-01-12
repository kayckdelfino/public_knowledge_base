# Define the key pair for SSH access
resource "aws_key_pair" "key" {
  key_name   = "aws-key"
  public_key = file("./aws-key.pub")
}

# Create the first AWS instance
resource "aws_instance" "vm_1" {
  ami                         = "ami-0d1ddd83282187d18"
  instance_type               = "t2.micro"
  key_name                    = aws_key_pair.key.key_name
  subnet_id                   = data.terraform_remote_state.vpc.outputs.subnet_id
  vpc_security_group_ids      = [data.terraform_remote_state.vpc.outputs.security_group_id]
  associate_public_ip_address = true

  tags = {
    Name = "vm-terraform-1"
  }
}

# Introduce a delay of 30 seconds using time_sleep resource
resource "time_sleep" "wait_30_seconds" {
  depends_on = [aws_instance.vm_1]

  create_duration  = "30s"
  destroy_duration = "30s"
}

# Create the second AWS instance after a delay of 30 seconds
resource "aws_instance" "vm_2" {
  depends_on = [time_sleep.wait_30_seconds]

  ami                         = "ami-0d1ddd83282187d18"
  instance_type               = "t2.micro"
  key_name                    = aws_key_pair.key.key_name
  subnet_id                   = data.terraform_remote_state.vpc.outputs.subnet_id
  vpc_security_group_ids      = [data.terraform_remote_state.vpc.outputs.security_group_id]
  associate_public_ip_address = true

  tags = {
    Name = "vm-terraform-2"
  }
}