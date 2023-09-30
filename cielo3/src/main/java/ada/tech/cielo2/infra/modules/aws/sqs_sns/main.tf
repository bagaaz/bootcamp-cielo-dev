module "sqs_queue" {
  name = var.name
  delay_seconds = var.delay_seconds
  max_message_size = var.max_message_size
  message_retention_seconds = var.message_retention_seconds
  visibility_timeout_seconds = var.visibility_timeout_seconds
  fifo_queue = var.fifo_queue
}

module "sns_topic" {
    name = var.name
}

module "subscribe" { 
  topic_arn = module.sns_topic.arn
  protocol  = var.protocol
  endpoint  = module.sqs_queue.arn
}
