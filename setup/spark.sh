# Set Spark version 2.2.0
# https://coderwall.com/p/o9bkjg/setup-spark-with-cassandra-connector
sparkversion=spark-2.0.0-bin-hadoop2.7

# Set Spark version 1.4.1
# sparkversion=spark-2.2.0-bin-hadoop2.7

# Install specific version
curl -O https://d3kbcqa49mib13.cloudfront.net/$sparkversion.tgz
tar xvf $sparkversion.tgz
sudo mkdir /usr/local/spark
sudo mv ./$sparkversion/* /usr/local/spark
rmdir ./$sparkversion
rm ./$sparkversion.tgz
echo "PATH=$PATH:$HOME/bin:/usr/local/spark/bin" >> ~/.bashrc
echo "SPARK_HOME="/usr/local/spark/ >> ~/.bashrc
source ~/.bashrc