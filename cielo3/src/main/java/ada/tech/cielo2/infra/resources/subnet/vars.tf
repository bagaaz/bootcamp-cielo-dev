variable "vpc_id" {
  description = "Number of subnets to create."
}

variable "cidr_block" {
  type        = string
  description = "List of CIDR blocks for subnets."
}

variable "availability_zone" {
  type        = string
  description = "List of availability zones for subnets."
}

variable "map_public_ip_on_launch" {
  description = "Number of subnets to create."
  type = bool
}

variable "tags" {
  type    = map(string)
  default = {
    Name = "custom-vpc"
  }
}