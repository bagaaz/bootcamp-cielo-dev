terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"

    }
  }
}

resource "aws_api_gateway_method_settings" "method_settings" {
  rest_api_id = var.rest_api_id
  stage_name = var.stage_name
  method_path = var.method_path
  settings = var.settings
}