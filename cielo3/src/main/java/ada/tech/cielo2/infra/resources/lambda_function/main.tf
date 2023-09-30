terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"

    }
  }
}

resource "aws_lambda_function" "function" {
  filename         = var.filename
  function_name    = var.function_name
  role             = var.role_arn
  handler          = var.arn
  runtime          = var.runtime
  source_code_hash = var.code_hash
}
