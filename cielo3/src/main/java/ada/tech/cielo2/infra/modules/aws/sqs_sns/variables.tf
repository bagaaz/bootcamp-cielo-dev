variable "spec" {
  type = object({
    sqs_queue = object({
        name = string
        delay_seconds = number
        max_message_size = number
        message_retention_seconds = number
        visibility_timeout_seconds = number
        fifo_queue = bool
    })
    sns_topic = object({
        name = string
    })
    subscribe = object({
        protocol = string
    })
  })
}