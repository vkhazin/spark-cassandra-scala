sudo sbt clean && \
sudo sbt assembly && \
spark-submit --packages datastax:spark-cassandra-connector:2.0.5-s_2.11 \
  ./target/scala-2.11/CopyData-assembly-1.0.jar
