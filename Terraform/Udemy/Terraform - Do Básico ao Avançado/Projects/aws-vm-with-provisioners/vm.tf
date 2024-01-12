# AWS Key Pair
resource "aws_key_pair" "key" {
  key_name   = "aws-key"
  public_key = file("./aws-key.pub")
}

# AWS Instance
resource "aws_instance" "vm" {
  ami                         = "ami-0d1ddd83282187d18"
  instance_type               = "t2.micro"
  key_name                    = aws_key_pair.key.key_name
  subnet_id                   = data.terraform_remote_state.vpc.outputs.subnet_id
  vpc_security_group_ids      = [data.terraform_remote_state.vpc.outputs.security_group_id]
  associate_public_ip_address = true

  # Local Exec Provisioner
  provisioner "local-exec" {
    command = "echo ${self.public_ip} >> public_ip.txt"
  }

  # SSH Connection Configuration
  connection {
    type        = "ssh"
    user        = "ubuntu"
    private_key = file("./aws-key")
    host        = self.public_ip
  }

  # Remote Exec Provisioner
  provisioner "remote-exec" {
    inline = [
      "echo subnet_id: ${data.terraform_remote_state.vpc.outputs.subnet_id} >> /tmp/network_info.txt",
      "echo security_group_id: ${data.terraform_remote_state.vpc.outputs.security_group_id} >> /tmp/network_info.txt",
    ]
  }

  # File Provisioner
  provisioner "file" {
    source      = "./teste.txt"
    destination = "/tmp/exemplo.txt"
  }

  # File Provisioner (Content)
  provisioner "file" {
    content     = "ami used: ${self.ami}"
    destination = "/tmp/ami.txt"
  }

  # Tags
  tags = {
    Name = "vm-terraform"
  }
}