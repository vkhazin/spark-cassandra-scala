choco install jdk8 -y
choco install sbt -y

# Spark
choco install 7zip.portable -y
$sparkVersion="spark-2.2.0-bin-hadoop2.7"
$sparkFolder="C:\spark"
$uri="https://d3kbcqa49mib13.cloudfront.net/$sparkVersion.tgz"
$path=(Convert-Path .)
$filename=$path + "\"+ $sparkVersion + ".tgz"
(New-Object System.Net.WebClient).DownloadFile($uri, $filename)
 7z x .\$sparkVersion.tgz
 7z x .\$sparkVersion.tar
mkdir $sparkFolder
 mv .\spark-2.2.0-bin-hadoop2.7\* $sparkFolder
rm .\$sparkVersion.tar
rm .\$sparkVersion.tgz

# Winutils
$uri="https://github.com/steveloughran/winutils/raw/master/hadoop-2.7.1/bin/winutils.exe"
$filename=$path + "\"+ "winutils.exe"
(New-Object System.Net.WebClient).DownloadFile($uri, $filename)
mv ./winutils.exe "$sparkFolder/bin"
mkdir /tmp
mkdir /tmp/hive
& "$sparkFolder\bin\winutils.exe" chmod 777 \tmp\hive

# Set system variables
## Path
$oldpath = (Get-ItemProperty -Path "Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment" -Name PATH).path
$newpath = "$oldpath;$sparkFolder\bin"
Set-ItemProperty -Path "Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment" -Name PATH -Value $newPath

## SPARK_HOME
Set-ItemProperty -Path "Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment" -Name SPARK_HOME -Value $sparkFolder

## HADOOP_HOME
Set-ItemProperty -Path "Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment" -Name HADOOP_HOME -Value $sparkFolder


# Print out a message
Write-Host "Log off and log back in to re-initialize path, SPARK_HOME, and HADOOP_HOME variables!" -foreground "red"
