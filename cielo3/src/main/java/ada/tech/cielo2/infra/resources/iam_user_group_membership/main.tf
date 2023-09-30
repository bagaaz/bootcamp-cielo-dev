terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
    }
  }
}

resource "aws_iam_user_group_membership" "usertogroup" {
  user  = var.user_name
  groups = var.groups 
}
