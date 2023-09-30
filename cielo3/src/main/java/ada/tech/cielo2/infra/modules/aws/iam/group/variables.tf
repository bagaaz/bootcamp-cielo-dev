variable "spec" {
  type = object({
    group = object({
        name = string
        policy = object({
            name = string
            description = string
            policy = any
        })
    })
  })
}


