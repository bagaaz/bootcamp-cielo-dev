

terraform {
  source = "../../../../../../modules/aws/iam/group"
}

include "root" {
  path = find_in_parent_folders()
}


locals {
  json_data = jsonencode(jsondecode(file("policy.json")))
}
inputs = { 
    spec = {
        group = {
            name = "owner"
            policy = {
                name = "owner"
                description = "this is a owner policy"
                policy = local.json_data
          }
        }
    }
}