

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
            name = "developer"
            policy = {
                name = "developer"
                description = "this is a developer policy"
                policy = local.json_data
          }
        }
    }
}