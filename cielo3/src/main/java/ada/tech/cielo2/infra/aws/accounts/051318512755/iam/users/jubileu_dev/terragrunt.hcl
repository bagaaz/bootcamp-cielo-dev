terraform {
  source = "../../../../../../modules/aws/iam/user"
}

include "root" {
  path = find_in_parent_folders()
}


inputs = { 
      spec = {
          user = {
              name = "jubileu_d"
              groups = ["developer"]
      }
  }
}