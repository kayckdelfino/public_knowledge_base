resource "aws_s3_bucket" "bucket" {
  bucket = "kayckdelfino-lifecycle-test"

  # Define S3 bucket lifecycle configuration
  lifecycle {
    create_before_destroy = true
    ignore_changes        = [
      tags
    ]
  }

  tags = {
    test = "vscode"
  }
}