terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"

    }
  }
}

resource "aws_api_gateway_deployment" "deployment" {
  rest_api_id   = var.rest_api_id
  stage_name    = var.stage_name
  description   = var.description
}
