include "root" {
  path = find_in_parent_folders()
}

terraform {
  source = "../../../../../../modules/aws/vpc"
}

inputs = {
  spec = {
    cidr_block = "10.0.0.0/16"
    tags = {
      Name = "main-vpc"
      Env =  "dev"
    }
    public_subnet = {
      cidr_block = "10.0.1.0/24"
      availability_zone = "us-east-1a"
      map_public_ip_on_launch = true
      tags = {
        Name = "main-public-subnet"
        Env =  "dev"
      }
    }
    private_subnet = {
      cidr_block = "10.0.2.0/24"
      availability_zone = "us-east-1b"
      map_public_ip_on_launch = false
      tags = {
        Name = "main-private-subnet"
        Env =  "dev"
      }
    }
    internet_gateway = {
      tags = {
        Name = "main-ig"
        Env =  "dev"
      }
    }

    public_subnet_asso = {
      public_subnet_cidrs = 1
    }

    security_group = {
      name = "main"
      tags = {
        Name = "main-sg"
        Env =  "dev"
      }
    }
  }

}
