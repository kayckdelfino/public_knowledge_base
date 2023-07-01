resource "aws_elastic_beanstalk_application" "beanstalk_app" {
  name        = var.appName
  description = var.desc
}

resource "aws_elastic_beanstalk_environment" "beanstalk_env" {
  name                = var.environment
  application         = aws_elastic_beanstalk_application.beanstalk_app.name
  solution_stack_name = "64bit Amazon Linux 2 v3.5.9 running Docker"

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name = "InstanceType"
    value = var.mType
  }

  setting {
    namespace = "aws:autoscaling:asg"
    name = "MaxSize"
    value = var.max
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name = "IamInstanceProfile"
    value = aws_iam_instance_profile.beanstalk_ec2_profile.name
  }
}