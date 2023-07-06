resource "aws_lb" "ecs-alb" {
  name            = "ecs-django"
  security_groups = [aws_security_group.alb.id]
  subnets         = [module.vpc.public_subnets]
}

resource "aws_lb_listener" "http" {
  load_balancer_arn = aws_lb.ecs-alb.arn
  port              = "8000"
  protocol          = "HTTP"

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.target.arn
  }
}

resource "aws_lb_target_group" "target" {
  name        = "ecs-django"
  port        = 8000
  protocol    = "HTTP"
  target_type = "ip"
  vpc_id      = module.vpc.vpc_id
}

output "IP" {
  value = aws_lb.ecs-alb.dns_name
}