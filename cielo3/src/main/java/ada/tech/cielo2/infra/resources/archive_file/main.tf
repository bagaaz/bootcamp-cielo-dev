
data "archive_file" "api_definition" {
  type        = "zip"
  source_file = "openapi.yaml" # Substitua pelo caminho para o seu arquivo OpenAPI
  output_path = "${path.module}/openapi.zip"
}
