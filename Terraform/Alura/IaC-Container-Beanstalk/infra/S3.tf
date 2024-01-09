resource "aws_s3_bucket" "beanstalk_deploys" {
  bucket = "${var.appName}-deploys"
}

resource "aws_s3_object" "docker" {
  depends_on = [aws_s3_bucket.beanstalk_deploys]
  bucket     = "${var.appName}-deploys"
  key        = "${var.appName}.zip"
  source     = "${var.appName}.zip"
  etag       = filemd5("${var.appName}.zip")
}