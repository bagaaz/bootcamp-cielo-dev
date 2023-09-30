terraform {

  required_providers {
    aws = {
      source  = "hashicorp/aws"
    }
  }
}

resource "aws_vpc_attachment" "vpc_attachment" {
  vpc_id = var.vpc_id
  internet_gateway_id = var.ig_id
}
