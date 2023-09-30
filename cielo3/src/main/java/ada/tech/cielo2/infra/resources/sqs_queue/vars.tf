variable "name" {
    type = string
}
variable "delay_seconds" {
    type = number
}
variable "max_message_size" {
    type = number
}
variable "message_retention_seconds" {
    type = number
}
variable "visibility_timeout_seconds" {
    type = number
}
variable "fifo_queue" {
    type = bool
}