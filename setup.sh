#!/bin/bash
# Simple setup.sh for configuring Ubuntu 12.04 LTS EC2 instance
# for headless setup. 

# Install nvm: node-version manager
# https://github.com/creationix/nvm
sudo apt-get install -y git
sudo apt-get install -y curl
curl https://raw.github.com/creationix/nvm/master/install.sh | sh


sudo apt-get -y purge openjdk*

sudo add-apt-repository ppa:webupd8team/java

sudo apt-get -y update && sudo apt-get -y install oracle-java7-installer

sudo apt-get -y install maven

# Load nvm and install latest production node

# Install emacs24
# https://launchpad.net/~cassou/+archive/emacs
sudo apt-add-repository -y ppa:cassou/emacs
sudo apt-get -qq update
sudo apt-get install -y emacs24-nox emacs24-el emacs24-common-non-dfsg

# Install Heroku toolbelt
# https://toolbelt.heroku.com/debian
wget -qO- https://toolbelt.heroku.com/install-ubuntu.sh | sh

sudo apt-get update
sudo apt-get -y install python-software-properties
sudo add-apt-repository ppa:pitti/postgresql
sudo apt-get update
 
sudo apt-get -y install postgresql-9.2 postgresql-client-9.2 postgresql-contrib-9.2
sudo apt-get -y install postgresql-server-dev-9.2 libpq-dev

