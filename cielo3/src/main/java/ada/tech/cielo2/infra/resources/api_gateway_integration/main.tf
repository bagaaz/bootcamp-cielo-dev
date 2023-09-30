terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"

    }
  }
}

resource "aws_api_gateway_integration" "integration" {
  rest_api_id = var.rest_api_id
  resource_id = var.resource_id
  http_method = var.http_method
  type = var.type
  integration_http_method = var.integration_http_method
  uri = var.uri
}