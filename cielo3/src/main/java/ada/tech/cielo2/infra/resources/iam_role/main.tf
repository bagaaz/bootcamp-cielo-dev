terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"

    }
  }
}

resource "aws_iam_role" "role" {
  name = var.name
  assume_role_policy = var.assume_role_policy
}