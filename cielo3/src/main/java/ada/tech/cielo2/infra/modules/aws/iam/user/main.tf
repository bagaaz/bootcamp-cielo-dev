module "user" {
  source = "../../../../../../../../../resources/iam_user"
  name = var.spec.user.name

}

module "iam_user_group_membership" {
  source = "../../../../../../../../../resources/iam_user_group_membership"
  user_name = var.spec.user.name
  groups = var.spec.user.groups
  depends_on = [module.user]
}