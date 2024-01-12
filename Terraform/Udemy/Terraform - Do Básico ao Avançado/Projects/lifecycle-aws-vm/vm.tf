# Create an AWS key pair
resource "aws_key_pair" "key" {
  key_name   = "aws-key"
  public_key = file("./aws-key.pub")
}

# Create an AWS EC2 instance
resource "aws_instance" "vm" {
  ami                         = "ami-0d1ddd83282187d18"
  instance_type               = "t2.micro"
  key_name                    = aws_key_pair.key.key_name
  subnet_id                   = data.terraform_remote_state.vpc.outputs.subnet_id
  vpc_security_group_ids      = [data.terraform_remote_state.vpc.outputs.security_group_id]
  associate_public_ip_address = true

  # Define EC2 instance lifecycle configuration
  lifecycle {
    # Uncomment the line below to prevent the instance from being destroyed
    # prevent_destroy = true

    # Trigger a replacement of the instance when the S3 bucket is replaced
    replace_triggered_by = [
      aws_s3_bucket.bucket
    ]
  }

  tags = {
    Name = "vm-terraform"
  }
}