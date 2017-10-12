choco install jdk8 -y
choco install sbt -y

# Spark
choco install 7zip.portable -y
$sparkVersion="spark-2.2.0-bin-hadoop2.7"
$uri="https://d3kbcqa49mib13.cloudfront.net/$sparkVersion.tgz"
$path=(Convert-Path .)
$filename=$path + "\"+ $sparkVersion + ".tgz"
(New-Object System.Net.WebClient).DownloadFile($uri, $filename)
 7z x .\$sparkVersion.tgz
 7z x .\$sparkVersion.tar
mkdir 'C:\spark'
 mv .\spark-2.2.0-bin-hadoop2.7\* 'C:\spark\'
$env:Path += ";C:\spark\bin"
rm .\$sparkVersion.tar
rm .\$sparkVersion.tgz
