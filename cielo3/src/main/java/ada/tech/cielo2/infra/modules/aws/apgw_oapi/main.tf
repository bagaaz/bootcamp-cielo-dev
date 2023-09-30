module "api_gateway_rest_api" {
  source = "../../../../../../../../../resources/api_gateway_restapi"
  name = var.rest_api.name
}
module "s3_bucket_oapi_file" {
  source = "../../../../../../../../../resources/s3_bucket"
  name = var.s3.name

}

module "s3_bucket_oapi_object" {
  source = "../../../../../../../../../resources/s3_bucket_object"
  bucket       = module.s3_bucket_oapi_file.bucket_id
  key          = var.s3.object.key
  source       = var.s3.object.source
  content_type = var.s3.object.content_type
}

module "api_gateway_rest_from_oapi" {
  source = "../../../../../../../../../resources/api_gateway_restapi"
  name = var.rest_api.name
  description = var.rest_api.description
  body = module.s3_bucket_oapi_object.id
}


module "api_gateway_stage" {
  source = "../../../../../../../../../resources/api_gateway_stage"
  rest_api_id = module.api_gateway_rest_from_oapi.rest_api_id
  stage_name  = var.api_gateway.stage.name
}


module "api_gateway_deployment" {
  source = "../../../../../../../../../resources/api_gateway_deployment"
  depends_on = [module.api_gateway_stage]
  rest_api_id   = module.api_gateway_rest_from_oapi.rest_api_id
  stage_name    = module.api_gateway_stage.name
  description   = ""
}

module "lambda_openapi_execution_role" {
  source = "../../../../../../../../../resources/iam_role"
  name = var.transform.role.name
  assume_role_policy = var.transform.role.policy

}

module "lambda_openapi_trasform" {
  source = "../../../../../../../../../resources/lambda_function"
  filename         = var.transform.function.filename
  function_name    = var.transform.function.name
  role             = module.lambda_openapi_execution_role.arn
  handler          = var.transform.function.arn
  runtime          = var.transform.function.runtime
  source_code_hash = var.transform.function.code_hash

}


module "lambda_openapi_traform_perm" {
  source = "../../../../../../../../../resources/lambda_permission"
  statement_id  = var.transform.permission.statement_id
  action        = var.transform.permission.action
  function_name = module.lambda_openapi_trasform.arn
  principal     = var.transform.permission.principal
  source_arn    = "${module.api_gateway_deployment.execution_arn}/*/*/*"

}

module "api_gateway_integration" {
  source = "../../../../../../../../../resources/api_gateway_integration"
  rest_api_id = module.api_gateway_rest_from_oapi.rest_api_id
  resource_id = module.api_gateway_rest_from_oapi.root_resource_id
  http_method = var.api_gateway.integration.http_method
  type = var.integration.type
  integration_http_method = var.api_gateway.integration.integration_http_method
  uri = module.lambda_openapi_trasform.invoke_arn

}
module "api_gateway_method" {
  source = "../../../../../../../../../resources/api_gateway_method"
  rest_api_id = module.api_gateway_rest_from_oapi.rest_api_id
  resource_id = module.api_gateway_rest_from_oapi.root_resource_id
  http_method = var.api_gateway.method.http_method
  authorization = var.api_gateway.method.authorization

}
module "api_gateway_method_response" {
  source = "../../../../../../../../../resources/api_gateway_method_response"
  rest_api_id = module.api_gateway_rest_from_oapi.rest_api_id
  resource_id = module.api_gateway_rest_from_oapi.root_resource_id
  http_method = var.api_gateway.method_response.http_method
  status_code = var.api_gateway.method_response.status_code
  response_parameters = var.api_gateway.method_response.response_parameters

}
module "api_gateway_integration_response" {
  source = "../../../../../../../../../resources/api_gateway_integration_response"
  rest_api_id = module.api_gateway_rest_from_oapi.rest_api_id
  resource_id = module.api_gateway_rest_from_oapi.root_resource_id
  http_method = var.api_gateway.integration_response.http_method
  status_code = var.api_gateway.integration_response.status_code
  response_parameters = var.api_gateway.integration_response.response_parameters

}

module "api_gateway_settings" {
  source = "../../../../../../../../../resources/api_gateway_method_settings"
  rest_api_id = module.api_gateway_rest_from_oapi.rest_api_id
  stage_name = module.api_gateway_stage.name
  method_path = var.api_gatway.settings.method_path
  settings = var.api_gatway.settings.settings

}

module "api_gateway_deployment_after_stage" {
  source = "../../../../../../../../../resources/api_gateway_deployment"
  depends_on = [module.api_gateway_stage]
  rest_api_id   = module.api_gateway_rest_from_oapi.rest_api_id
  stage_name    = module.api_gateway_stage.name
  description   = ""
}










