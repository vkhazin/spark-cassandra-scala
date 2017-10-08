# build spark cassandra connector
git clone https://github.com/datastax/spark-cassandra-connector.git
cd spark-cassandra-connector
git checkout v2.0.0-M2
sudo sbt assembly -Dscala-2.11=true
sudo mv ./spark-cassandra-connector/spark-cassandra-connector/target/full/scala-2.10/spark-cassandra-connector-assembly-2.0.0-M2.jar /usr/local/spark/jars
