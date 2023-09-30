terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"

    }
  }
}



resource "aws_sqs_queue" "queue" {
  name                      = var.name
  delay_seconds             = var.delay_seconds #number
  max_message_size          = var.max_message_size #262144
  message_retention_seconds = var.message_retention_seconds # 4 days 345600
  visibility_timeout_seconds = var.visibility_timeout_seconds #30
  fifo_queue                = var.fifo_queue #false # Change to true for FIFO queue
}