resource "kubernetes_deployment" "django_api" {
  metadata {
    name = "django-api"
    labels = {
      nome = "django"
    }
  }

  spec {
    replicas = 3

    selector {
      match_labels = {
        nome = "django"
      }
    }

    template {
      metadata {
        labels = {
          nome = "django"
        }
      }

      spec {
        container {
          image = "<aws_account_id>.dkr.ecr.us-east-1.amazonaws.com/producao:v1"
          name  = "django"

          resources {
            limits = {
              cpu    = "0.5"
              memory = "512Mi"
            }
            requests = {
              cpu    = "250m"
              memory = "50Mi"
            }
          }

          liveness_probe {
            http_get {
              path = "/clientes/"
              port = 8000
            }

            initial_delay_seconds = 3
            period_seconds        = 3
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "loadBalancer" {
  metadata {
    name = "loadbalancer-django-api"
  }

  spec {
    selector = {
      nome = "django"
    }

    port {
      port        = 8000
      target_port = 8000
    }
    type = "LoadBalancer"
  }
}

output "URL" {
  value = kubernetes_service.loadBalancer.status
}