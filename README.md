# Environment Setup:

## Ubuntu 16.04
* Launch new ec2 instance: Ubuntu Server 16.04 LTS (HVM), SSD Volume Type - ami-10547475
* Connect to the instance using ssh
* Clone git repository: ```git clone https://github.com/vkhazin/spark-cassandra-scala.git```
* Install dependencies:
```
cd ./spark-cassandra-scala/setup
chmod +x *.sh
./ubuntu-16.04.sh
```

## Windows Server 2016
* Launch a new Windows Server 2016 Base version
* Connect to the instance using RDP
* Clone the git repository
* Install dependencies by opening PowerShell as *Administrator*
```
Set-ExecutionPolicy Bypass; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
choco install git -y
$env:path+=";C:\program files\git\bin"
git clone https://github.com/vkhazin/spark-cassandra-scala.git
cd ./spark-cassandra-scala/setup
./windows-2016.ps1
```
* You have to logout and to log back in otherwise system environment variables are not applied properly

# Adjustments
* Review code in ./src/main/scala/Main.scala
* Review settings in ./src/main/resources/application.conf

# Package Code and Submit Job to Spark
## Ubuntu 16.04
```
chmod +x ./submit.sh
./submit.sh
```
*Please Note:* sbt corrupts the echo in linux terminal, use ```reset``` to get the echo back

## Windows Server 2016
```
./submit.ps1
```
* Please note: an issue on Windows unable to delete temp folders: https://issues.apache.org/jira/browse/SPARK-12216
* May require periodic cleaning of your ~/AppData/Local/Temp folder manually
