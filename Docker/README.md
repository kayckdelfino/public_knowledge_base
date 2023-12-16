# <h1 align="center">Docker</h1>

This folder contains my notes on crucial information and commands for understanding and using Docker to speed up application management and development.

## Official Documentation

- Complete documentation: [Docker Documentation](https://docs.docker.com/)
- Docker image repository: [Docker Hub](https://hub.docker.com/)

---

## Summary

- [Docker](#docker)
  - [Summary](#summary)
  - [Basic Concepts](#basic-concepts)
  - [Installation](#installation)
  - [Operation](#operation)
  - [Images](#images)
  - [Data Persistence](#data-persistence)
  - [Communication Between Containers](#communication-between-containers)
  - [Composing Applications from a Single File](#composing-applications-from-a-single-file)
  - [Main Docker Commands](#main-docker-commands)

---

## Basic Concepts

### What is Docker?

Docker is a platform that leverages containers to encapsulate, distribute, and execute applications in isolated environments. Its advantages include:

- **Isolation from the host operating system**: Achieved through namespaces, ensuring applications remain independent and do not affect the host system.
- **Control over system resource management**: Utilizes cgroups to manage system resources effectively, allowing precise allocation and limitation of resources for each container.
- **Lightweight nature compared to virtual machines**: Operates as processes within the host operating system, consuming fewer resources than traditional VMs.

### Why Use Docker?

Docker provides substantial benefits in managing applications by effectively addressing issues such as:

- **Port conflicts**: Enables seamless operation when multiple applications demand the same port, resolving conflicts by encapsulating each application within its container.
- **Version control challenges**: Facilitates easy and reliable management of application versions, allowing for smooth transitioning between different versions without interference.

---

## Installation

### Windows

For Docker installation on Windows, you'll need WSL (Windows Subsystem for Linux) and Docker Desktop.

- [Installation guide for Windows](https://docs.docker.com/desktop/install/windows-install/)

### Linux

To install Docker on Linux, follow the steps outlined in the official documentation provided below.

- [Installation guide for Linux](https://docs.docker.com/desktop/install/linux-install/)

### Testing the Installation

After completing the installation, verify Docker's functionality by running the following command in your terminal:

```bash
$ docker run hello-world
```

This command checks whether Docker is correctly installed by fetching and executing the 'hello-world' image. It also ensures that your environment is properly configured to run Docker containers.

---

## Operation

When you execute `docker run hello-world`:

- If a local image named `hello-world` doesn't exist, Docker automatically searches for it in the [**Docker Hub**](https://hub.docker.com) repository.
- The Docker client fetches the `hello-world` image from the repository using the command `docker pull`.
- After the image is retrieved, Docker validates its integrity using its *hash* to ensure it hasn't been altered or corrupted.
- Subsequently, the container is executed using the command `docker run`, initiating the 'hello-world' application inside the container environment.

---

## Images

Images are composed of multiple "layers," each with a unique `id`. Often, when multiple pre-built images are downloaded, they might share common layers, allowing Docker to optimize storage by reusing these layers.

- Pre-built image layers are categorized as `R/O` (*read/only*). However, when a container is created, an additional layer, `W/R` (*write/read*), is introduced, enabling data manipulation.

### How to Create an Image

Refer to the [**documentation**](https://docs.docker.com/engine/reference/builder/) for detailed guidance.

Creating an image involves the following steps:
1. Develop a `Dockerfile`.
2. Build the file into an image using `docker build -t [target name:version] [target directory]`. For example: `docker build -t kayckdelfino/app-node:1.0 .` in the current directory.
3. The resulting image is now prepared for execution.

### Image Publication

To publish an image:
- Create an account on `Docker Hub`.
- Authenticate the account in the `bash` (Terminal) using `docker login`.
- Finally, execute `docker push [image_name]` to upload your image.

---

## Data Persistence

By default, data from the `W/R` layer of a container isn't stored, but these settings can be manually configured. **[Full Documentation](https://docs.docker.com/storage/)**

### Bind Mounts

When starting a container, a specific directory from the host can be designated to store data from a particular container directory. This setup allows using the same host directory for multiple containers.
    
- **Using the -v flag** 
  Syntax: `-v [host_directory:container_directory]`
  
  - **Example**
    `docker run -it -v /home/kayck/volume-docker:/app ubuntu bash` saves all data from the `/app` directory of the container into the local directory `/volume-docker`.
            
- **Using the —mount flag (recommended)**
  Syntax: `--mount type=bind,source=[host_directory],target=[container_directory]`
        
    - **Example**
      `docker run -it —mount type=bind,source=/home/kayck/volume-docker,target=/app ubuntu bash` - similar to the `-v` flag, it saves all data from the `/app` directory of the container into the local directory `/volume-docker`.
            
    
### Volumes (More Recommended)

Volumes are created on the host machine but managed by Docker, offering an additional layer of protection for persisted data. Can be attached using the flags described earlier in the **Bind Mounts** section.

- **-v flag**
  Syntax: `-v [volume_name:container_directory]`
            
  - **Example**
    `docker run -it -v my-volume:/app ubuntu bash`
                
- **—mount**
  Syntax: `--mount source=[volume_name],target=[container_directory]`
            
    - In this case, the `type=bind` is not required.
    - If the provided `[volume_name]` doesn't exist, it will be automatically created.
    - **Example**
      `docker run -it —mount source=my-volume,target=/app ubuntu bash`
                
    
Volumes are stored in the directory `/var/lib/docker/volumes`.
    
### tmpfs
    
Used when storing temporary files that shouldn't reside in the `W/R` layer of the container.
    
- Operates exclusively on Linux hosts.
- Stores data in volatile memory.


---

## Communication Between Containers

When inspecting a container with `docker inspect`, you gain crucial insights such as the container's network ID (`network ID`) and its corresponding IP address.

### Network Interaction Overview:

- Containers within the same network possess communication capabilities, facilitating actions like using ping commands between them for verification purposes.
- Docker operates with three default networks: `bridge`, `host`, and `none`.
- Relying on IP addresses and default networks is discouraged due to container vulnerabilities linked to restarts and IP changes.

### Container Allocation and Networks:

- Upon creation from an image, containers are automatically placed within the `bridge` network driver, responsible for establishing inter-container communication within the same host.
- Users have the option to create custom networks using the `bridge` driver via `docker network create` and assign containers to these networks during their instantiation using `docker run -it —name ubuntu1 —network my-bridge ubuntu bash`.
- User-defined `bridge` network drivers provide automatic **DNS** resolution among containers, enabling interaction between different containers using hostnames.

### Network Driver Specifics:

- Utilizing the `none` network driver ensures complete isolation at the network level, devoid of any network interface linked to the container.
- The `host` network driver eliminates isolation between the container's network interface and the host, sharing the same network interface for both entities. This configuration allows access to the application via `localhost:[port]`.

---

## Composing Applications from a Single File

`docker-compose` allows you to define and execute applications comprised of multiple containers in Docker.

### Benefits and Usage:

- Resolves the challenge of simultaneously running multiple containers in a coordinated manner, removing the need for individual execution commands.
- It utilizes a `.yml` or `.yaml` extension file to define services and their configurations.
- While this tool is automatically installed on Windows, on Linux, it requires installation using `sudo apt-get install docker-compose-plugin`. Follow the **[documentation](https://docs.docker.com/compose/install/linux/#install-using-the-repository)**.

### Creating a `docker-compose.yml` File:

- Refer to the [full documentation](https://docs.docker.com/compose/gettingstarted/) for further guidance.
- Create a file named `docker-compose.yml`, as a example:

```yaml
version: “3.9”

services:
  mongodb:
    image: mongo:4.4.6
    container_name: my-mongo
    networks:
      - compose-bridge

  books:
    image: kayckdelfino/kayck-books:1.0
    container_name: kayck-books
    networks:
      - compose-bridge
    ports:
      - 3000:3000
    depends_on:
      - mongodb
    networks:
      compose-bridge:
        driver: bridge
```

---

## Main Docker Commands

### docker stats

- **Usage:** `docker stats`
- **Description:** Monitors Docker usage and container statistics in real-time.

### docker run

- **Usage:** `docker run [image_name]`
- **Description:** Executes the specified image.

    - Running `docker run ubuntu` will stop the container instantly.
    - To keep the container running, use `docker run ubuntu [command]` or `docker run -it ubuntu bash`.
    - Use `-d` to run the image in the background.
    - Set container name: `docker run --name ubuntu1 ubuntu bash`.
    - Define a custom network: `docker run --network my-network ubuntu bash`.

### docker top

- **Usage:** `docker top [container]`
- **Description:** Provides process details like start time, process ID, and the CMD command.

### docker pull

- **Usage:** `docker pull [image_name]`
- **Description:** Downloads the specified image.

### docker ps / docker container ls

- **Usage:** `docker ps [-a] [-s]`
- **Description:** Lists running containers.
    - Flags:
        - `-a`: Lists all containers, including stopped ones.
        - `-s`: Displays size-related information about containers.

### docker stop

- **Usage:** `docker stop [container_id / container_name]`
- **Description:** Stops the specified container.

### docker start

- **Usage:** `docker start [container_id / container_name]`
- **Description:** Restarts a stopped container.

### docker pause

- **Usage:** `docker pause [container_id / container_name]`
- **Description:** Pauses a running container.

### docker unpause

- **Usage:** `docker unpause [container_id / container_name]`
- **Description:** Unpauses a paused container.

### docker logs

- **Usage:** `docker logs [container_id / container_name]`
- **Description:** Displays the logs of a container.

### docker cp

- **Usage:** `docker cp [container:/path_to_file] [folder]`
- **Description:** Copies files between a container and the host.

### docker exec

- **Usage:** `docker exec [container_id / container_name] [linux_command]`
- **Description:** Executes a command in a running container.

### docker rm

- **Usage:** `docker rm [container_id / container_name]`
- **Description:** Removes a container.

### docker rmi

- **Usage:** `docker rmi [image_name]`
- **Description:** Removes an image.

### docker system prune

- **Usage:** `docker system prune`
- **Description:** Removes unused containers, images, and networks.

### docker port

- **Usage:** `docker port [container_id / container_name]`
- **Description:** Shows the port mapping between the container and the host.

### docker images / docker image ls

- **Description:** Lists locally saved images.

### docker inspect

- **Usage:** `docker inspect [image_id]`
- **Description:** Displays detailed information about an image.

### docker history

- **Usage:** `docker history [image_id]`
- **Description:** Shows the layers present in the image.

### docker login

- **Usage:** `docker login -u [username]`
- **Description:** Authenticates the Docker CLI to the Docker Hub.

### docker logout

- **Usage:** `docker logout`
- **Description:** Logs out from the Docker CLI.

### docker push

- **Usage:** `docker push [image_name]`
- **Description:** Publishes the image to the Docker Hub.

### docker tag

- **Usage:** `docker tag [old_image_name] [new_image_name]`
- **Description:** Renames an existing image.

### docker volume ls

- **Description:** Lists all volumes.

### docker volume inspect

- **Usage:** `docker volume inspect [volume_name]`
- **Description:** Displays details of a specific volume.

### docker volume create

- **Usage:** `docker volume create [volume_name]`
- **Description:** Creates a new volume.

### docker volume rm

- **Usage:** `docker volume rm [volume_name]`
- **Description:** Removes an existing volume.

### docker volume prune

- **Usage:** `docker volume prune`
- **Description:** Removes all unused volumes.

### docker network ls

- **Description:** Lists Docker networks on the system.

### docker network create

- **Usage:** `docker network create --driver [driver_name] [network_name]`
- **Description:** Creates a new custom network.

### docker network rm

- **Usage:** `docker network rm [network]`
- **Description:** Removes one or more networks by name or identifier.

### docker network prune

- **Usage:** `docker network prune`
- **Description:** Removes unused networks.

### docker network connect

- **Usage:** `docker network connect [network] [container]`
- **Description:** Connects a container to a network.

### docker network disconnect

- **Usage:** `docker network disconnect [network] [container]`
- **Description:** Disconnects a container from a network.

### docker network inspect

- **Usage:** `docker network inspect [network]`
- **Description:** Displays details about a network.

### docker-compose up

- **Usage:** `docker-compose up [-d]`
- **Description:** Executes a `docker-compose.yml` file for a multi-container application.

### docker-compose down

- **Description:** Stops and removes all containers and networks created by `docker-compose up`.

### docker-compose ps

- **Description:** Lists services created by `docker-compose`.