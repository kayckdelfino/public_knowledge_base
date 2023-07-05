resource "aws_s3_bucket" "beanstalk_deploys" {
  bucket = "${var.nome}-deploys"
}

resource "aws_s3_bucket_object" "docker" {
  depends_on = [aws_s3_bucket.beanstalk_deploys]
  bucket     = "${var.nome}-deploys"
  key        = "${var.nome}.zip"
  source     = "${var.nome}.zip"
  etag       = filemd5("${var.nome}.zip")
}