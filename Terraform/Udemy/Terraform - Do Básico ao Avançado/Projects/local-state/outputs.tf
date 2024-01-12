# Output the ID of the AWS S3 bucket
output "bucket_id" {
  description = "ID of the bucket created in AWS"
  value       = aws_s3_bucket.bucket.id
}

# Output the ARN of the AWS S3 bucket
output "bucket_arn" {
  description = "ARN of the bucket created in AWS"
  value       = aws_s3_bucket.bucket.arn
}