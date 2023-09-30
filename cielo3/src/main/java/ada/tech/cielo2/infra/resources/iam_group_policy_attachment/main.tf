terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
    }
  }
}

resource "aws_iam_group_policy_attachment" "group_attach" {
  policy_arn = var.policy_arn
  group      = var.group
}

