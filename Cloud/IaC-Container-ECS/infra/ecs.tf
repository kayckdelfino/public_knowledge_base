module "ecs" {
  source = "terraform-aws-modules/ecs/aws"

  cluster_name = "ecs-integrated"

  cluster_settings = {
    "name" : "containerInsights",
    "value" : "enabled"
  }

  default_capacity_provider_use_fargate = true

  fargate_capacity_providers = {
    FARGATE = {
      default_capacity_provider_strategy = {
        weight = 1
      }
    }
  }
}

resource "aws_ecs_task_definition" "django_api" {
  family                   = "django-api"
  requires_compatibilities = ["FARGATE"]
  network_mode             = "awsvpc"
  cpu                      = 256
  memory                   = 512
  execution_role_arn       = aws_iam_role.ecs_role.arn
  container_definitions = jsonencode({
    "name"      = "producao"
    "image"     = "<aws-id>.dkr.ecr.<region>.amazonaws.com/<image-name>:<image-version>"
    "cpu"       = 256
    "memory"    = 512
    "essential" = true
    "portMappings" = [
      {
        "containerPort" = 8000
        "hostPort"      = 8000
      }
    ]
  })
}

resource "aws_ecs_service" "django_api" {
  name            = "django-api"
  cluster         = module.ecs.cluster_id
  task_definition = aws_ecs_task_definition.django_api.arn
  desired_count   = 3

  load_balancer {
    target_group_arn = aws_lb_target_group.target.arn
    container_name   = "producao"
    container_port   = 8000
  }

  network_configuration {
    subnets         = module.vpc.private_subnets
    security_groups = [aws_security_group.private.id]
  }

  capacity_provider_strategy {
    capacity_provider = "FARGATE"
    weight            = 1
  }
}
