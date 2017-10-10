#!/bin/bash

# Removing previous version of java
# sudo yum remove java-1.7.0-openjdk-devel.x86_64 -y
# sudo yum remove java-1.7.0-openjdk.x86_64 -y

# Download Install Java 8
curl -O -v -j -k -L -H "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u144-b01/090f390dda5b47b9b721c7dfaa008135/jdk-8u144-linux-x64.rpm
sudo rpm -ivh ./jdk-8u144-linux-x64.rpm
rm ./jdk-8u144-linux-x64.rpm

# Installing SBT *
curl https://bintray.com/sbt/rpm/rpm | sudo tee /etc/yum.repos.d/bintray-sbt-rpm.repo
sudo yum install sbt -y

# Install Spark
./spark.sh


