resource "aws_route_table_association" "public_subnet_asso" {
 count = length(var.subnets)
 subnet_id      = element(var.subnets, count.index)
 route_table_id = var.rt_id
}