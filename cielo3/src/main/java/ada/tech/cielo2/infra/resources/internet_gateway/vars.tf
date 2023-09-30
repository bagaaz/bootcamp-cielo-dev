variable "vpc_id" {
  description = "ID of the VPC to associate the route table with."
}

variable "tags" {
  type    = map(string)
  default = {
    Name = "custom-vpc"
  }
}