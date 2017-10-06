# Install Spark
curl -O https://d3kbcqa49mib13.cloudfront.net/spark-2.2.0-bin-hadoop2.7.tgz
tar xvf spark-2.2.0-bin-hadoop2.7.tgz
sudo mkdir /usr/local/spark
sudo mv ./spark-2.2.0-bin-hadoop2.7/* /usr/local/spark
rmdir ./spark-2.2.0-bin-hadoop2.7
rm ./spark-2.2.0-bin-hadoop2.7.tgz
echo "PATH=$PATH:$HOME/bin:/usr/local/spark/bin" >> ~/.bashrc
echo "SPARK_HOME="/usr/local/spark/ >> ~/.bashrc
source ~/.bashrc