# Generated by Terragrunt. Sig: nIlQXj57tbuaRZEa
terraform {
  backend "s3" {
    bucket         = "jubileu-jubileu-us-east-1"
    dynamodb_table = "terraform-locks"
    encrypt        = true
    key            = "aws/accounts/051318512755/iam/groups/terraform.tfstate"
    region         = "us-east-1"
  }
}
