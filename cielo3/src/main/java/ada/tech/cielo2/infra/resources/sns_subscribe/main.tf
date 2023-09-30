terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"

    }
  }
}

resource "aws_sns_topic_subscription" "subscription" {
  topic_arn = var.sns_topic_arn
  protocol  = var.protocol
  endpoint  = var.sqs_queue_arn
}