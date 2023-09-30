variable "cidr_block" {
  description = "cidr for vpc"
  type        = string
}


variable "tags" {
  type    = map(string)
  default = {
    Name = "custom-vpc"
  }
}