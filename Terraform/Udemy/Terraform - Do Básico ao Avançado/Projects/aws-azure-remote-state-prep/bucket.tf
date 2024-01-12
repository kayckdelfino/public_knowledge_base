# AWS S3 Bucket for Remote State
resource "aws_s3_bucket" "bucket" {
  bucket = "kayckdelfino-remote-state"
}

resource "aws_s3_bucket_versioning" "versioning" {
  bucket = aws_s3_bucket.bucket.id

  versioning_configuration {
    status = "Enabled"
  }
}