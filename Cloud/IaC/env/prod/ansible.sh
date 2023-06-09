#!/bin/bash
cd /home/ubuntu
curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
sudo python3 get-pip.py
sudo python3 -m pip install ansible
tee -a playbook.yml > /dev/null <<EOT
- hosts: localhost
  tasks:
    - name: Criando o arquivo html (teste)
      copy:
        dest: /home/ubuntu/index.html
        content: <h1>Feito com Terraform e Ansible</h1>

    - name: Criando o servidor http (teste)
      shell: "nohup busybox httpd -f -p 8080 &"

    - name: Instalando o python3 e virtualenv
      apt:
        pkg:
          - python3
          - virtualenv
        update_cache: yes
      become: true

    - name: Git Clone
      ansible.builtin.git:
        repo: https://github.com/alura-cursos/clientes-leo-api.git
        dest: /home/ubuntu/project
        version: master
        force: yes

    - name: Instalando dependencias com pip (Django e Django Rest)
      pip:
        virtualenv: /home/ubuntu/project/venv
        requirements: /home/ubuntu/project/requirements.txt

    - name: Alterando o hosts do settings.py
      lineinfile:
        path: /home/ubuntu/project/setup/settings.py
        regexp: "ALLOWED_HOSTS"
        line: 'ALLOWED_HOSTS = ["*"]'
        backrefs: yes

    - name: Configurando o banco de dados
      shell: ". /home/ubuntu/project/venv/bin/activate; python /home/ubuntu/project/manage.py migrate"

    - name: Carregando os dados iniciais
      shell: ". /home/ubuntu/project/venv/bin/activate; python /home/ubuntu/project/manage.py loaddata clientes.json"

    - name: Iniciando o servidor
      shell: ". /home/ubuntu/project/venv/bin/activate; nohup python /home/ubuntu/project/manage.py runserver 0.0.0.0:8000 &"
EOT
ansible-playbook playbook.yml