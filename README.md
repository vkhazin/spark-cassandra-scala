# Environment Setup:

* Launch new ec2 instance: Ubuntu Server 16.04 LTS (HVM), SSD Volume Type - ami-10547475
* Connect to the instance using ssh
* Clone git repository: ```git clone https://github.com/vkhazin/spark-cassandra-scala.git```
* Install dependencies:
```
cd ./spark-cassandra-scala/setup
chmod +x *.sh
./ubuntu-16.04.sh
```

# Adjustments

* Review code in ./src/main/scala/Main.scala - as it is all hard-coded at the moment

# Pacakge Code and Submit Job to Spark
```
chmod +x ./submit.sh
./submit.sh
```
*Please Note:* sbt corrupts the echo in terminal, use ```reset``` to get the echo back