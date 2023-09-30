# Set account-wide variables. These are automatically pulled in to configure the remote state bucket in the root
# terragrunt.hcl configuration.
locals {
  account_name   = "jubileu"
  aws_account_id = "051318512755"
  aws_profile    = "prod"
}

