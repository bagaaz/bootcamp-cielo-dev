module "group" {
  source = "../../../../../../../../../resources/iam_group"
  name = var.spec.group.name
}


module "policy" {
  source = "../../../../../../../../../resources/iam_policy"
  name = var.spec.group.policy.name
  description = var.spec.group.policy.description
  policy = var.spec.group.policy.policy
}


module "attach_group_policy" {
  source = "../../../../../../../../../resources/iam_group_policy_attachment"
  policy_arn = module.policy.policy_arn
  group = var.spec.group.name
}