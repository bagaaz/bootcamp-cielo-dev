variable "spec" {
  type = object({
    user = object({
        name = string
        groups = list(string)
    })
  })
}


