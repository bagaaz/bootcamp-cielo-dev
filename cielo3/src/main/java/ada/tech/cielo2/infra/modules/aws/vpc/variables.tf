variable "spec" {
  type = object({
    cidr_block = string
    tags = map(string)
    public_subnet = object({
      cidr_block = string
      availability_zone = string
      map_public_ip_on_launch = bool
      tags = map(string)
    })
    private_subnet = object({
      cidr_block = string
      availability_zone = string
      map_public_ip_on_launch = bool
      tags = map(string)
    })

    internet_gateway = object({
      tags = map(string)
    })

    public_subnet_asso = object({
      public_subnet_cidrs = number
    })


    security_group = object({
      name = string
      tags = map(string)
    })

  })
}


