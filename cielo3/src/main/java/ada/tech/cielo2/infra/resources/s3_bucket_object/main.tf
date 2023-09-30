terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"

    }
  }
}

resource "aws_s3_bucket_object" "object" {
  bucket       = var.bucket_id
  key          = var.key
  source       = data.file
  content_type = data.content_type
}
