variable "spec" {
  type = object({
    rest_api = object({
        name = string
        description = string
    })
    s3 = object({
        name = string
        object = object({
            key = string
            source = string
            content_type = string
        })
    })
    api_gateway = object({
        stage = object({
            name = string
        })
        integration = object({
            http_method = string
            type = string
            integration_http_method = string
        })
        method = object({
            http_method = string
            authorization = string
        })
        method_response = object({
            http_method = string
            status_code = number
            response_parameters = map(any)
        })
        integration_response = object({
            http_method = string
            status_code = number
            response_parameters = map(any)
        })
        settings = object({
            method_path = string
            settings = map(any)

        })
    })
    transform = object({
        role = object({
            name = string
            policy = string
        })
        function = object({
            filename = string
            name = string
            arn = string
            runtime = string
            code_hash = string
        })
        permission = object({
            statement_id = string
            action = string
            principal = string
        })
    })
  })
}
