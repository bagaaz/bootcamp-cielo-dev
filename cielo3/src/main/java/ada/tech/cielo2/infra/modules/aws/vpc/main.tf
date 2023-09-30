module "vpc" {
  source = "../../../../../../../../../resources/vpc"
  cidr_block = var.spec.cidr_block
  tags = var.spec.tags
}


module "public_subnet" {
  source = "../../../../../../../../../resources/subnet"
  cidr_block        = var.spec.public_subnet.cidr_block
  availability_zone = var.spec.public_subnet.availability_zone
  map_public_ip_on_launch = var.spec.public_subnet.map_public_ip_on_launch
  vpc_id = module.vpc.vpc_id
  tags = var.spec.public_subnet.tags
}


module "private_subnet" {
  source = "../../../../../../../../../resources/subnet"
  cidr_block        = var.spec.private_subnet.cidr_block
  availability_zone = var.spec.private_subnet.availability_zone
  map_public_ip_on_launch = var.spec.private_subnet.map_public_ip_on_launch
  vpc_id = module.vpc.vpc_id
  tags = var.spec.private_subnet.tags
}



module "internet_gateway" {
  source = "../../../../../../../../../resources/internet_gateway"
  vpc_id = module.vpc.vpc_id
  tags = var.spec.internet_gateway.tags

}


module "route_table" {
  source = "../../../../../../../../../resources/route_tables"
  vpc_id = module.vpc.vpc_id
  gateway_id = module.internet_gateway.ig_id
}


module "public_subnet_asso" {
  source = "../../../../../../../../../resources/table_associate"
  rt_id = module.route_table.rt_id
  subnets = module.public_subnet.subnets[*].id
}

module "security_group" {
  source = "../../../../../../../../../resources/security_group"
  name = var.spec.security_group.name
  vpc_id = module.vpc.vpc_id
}