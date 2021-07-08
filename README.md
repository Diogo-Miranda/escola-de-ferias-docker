# Install Docker Linux
$ sudo apt‐get update
$ sudo apt‐get install build‐essential
python‐software‐properties git

$ sudo sh ‐c "wget ‐qO‐ https://get.docker.io/gpg | apt‐
key add ‐"
$ sudo sh ‐c "echo deb http://get.docker.io/ubuntu docker
main > /etc/apt/sources.list.d/docker.list"
$ sudo apt‐get update && apt‐get install lxc‐docker

# Comandos relacionados com infos

$ docker version - exibe a versão do docker que está instalada.
$ docker inspect [ID_CONTAINER] - retorna diversas informações sobre o container.
$ docker ps - exibe todos os containers em execução no momento.
$ docker ps -a - exibe todos os containers, independentemente de estarem em execução ou não.
$ docker ps -qa - exibe apenas o ID do container
$ docker stats [ID_CONTAINER] - informa em tempo real o consumo do container

# Comandos relacionados com exec

$ docker run [NOME_DA_IMAGEM] - cria um container com a respectiva imagem passada como parâmetro.
$ docker run -i -t [NOME_DA_IMAGEM] - conecta o terminal que estamos utilizando com o do container.
$ docker run -d -P --name NAME [CONTAINER] - ao executar, dá um nome ao container e define uma porta aleatória.
$ docker run -d -p 12345:80 [CONTAINER] - define uma porta específica para ser atribuída à porta 80 do container, neste caso 12345.
$ docker run -v [CAMINHO_VOLUME] [NOME_DA_IMAGEM] - cria um volume no respectivo caminho do container.
$ docker run -it --name [NOME_CONTAINER] --network [NOME_DA_REDE] [NOME_IMAGEM] - cria um container especificando seu nome e qual rede deverá ser usada.

# Hello, Docker!

$ docker run hello-world 
$ docker run ubuntu bin/echo Hello, Docker!

# Um pouco de iteratividade

$ docker run ubuntu bin/echo Hello, Docker!
$ docker run -i -t ubuntu bin/bash & cat /etc/lsb-release
$ docker rm $(docker ps -qa) - remove todos containers sem uso

$ docker exec -i -t [NOME_CONTAINER] bin/bash - entrar no terminal do container em execucao

# Criando container e definindo uma porta

$ docker run -d -P --name meu_site dockersamples/static-site - define uma porta aleatoria
$ docker run -p 8080:3000 --name meu_site dockersamples/static-site
$ docker exec -it [NOME_CONTAINER] /bin/bash & hostname -i - entra no terminal do container e mostra o ip que o container esta rodando
$ docker stop -t 0

# Criando volumes

$ docker run -v "/var/www" ubuntu
$ docker run -it -v "[CAMINHO_HOST]:[CAMINHO_CONTAINER] ubuntu bin/bash

# Rodando codigo dentro de um volume
$ docker run -p 8000:3000 -d "[CAMINHO_HOST]:[CAMINHO_CONTAINER]" -w [WORK_DIR] node npm start 
$ docker run -d -p 3000:3000 -v "/home/diogo/dev/git/escola-de-ferias-docker/site-starter:/var/www" -w "/var/www" node npm run dev

# Criando sua primeira imagem com Docker File
Estrutura de um Docker File:

FROM [IMAGEM_BASE]
MAINTAINER [NOME_DE_QUEM_MANTEM]
ENV [ENVIROMENT_VARIABLES]
WORKDIR [PATH_DO_WORKDIR]
COPY [DIRETORIO_HOST] [DIRETORIO_CONTAINER]
RUN [COMANDO]
ENTRYPOINT [COMANDOS]
EXPOSE [PORTA]

# Comunicacao Entre Containers
Install ping: # apt-get update && apt-get install iputils-ping

$ docker network create --driver bridge outra-rede
$ docker run -it --name meu-ubuntu-1 --newtork outra-rede ubuntu

# Docker Compose
$ docker-compose build
$ docker-compose up