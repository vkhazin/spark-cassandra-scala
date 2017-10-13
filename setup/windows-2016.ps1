choco install jdk8 -y
choco install sbt -y

# Spark
choco install 7zip.portable -y
$sparkVersion="spark-2.2.0-bin-hadoop2.7"
$sparkFolder="C:\spark\"
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
set SPARK_HOME=$sparkFolder

# Winutils
$uri="https://github.com/steveloughran/winutils/raw/master/hadoop-2.7.1/bin/winutils.exe"
$filename=$path + "\"+ "winutils.exe"
(New-Object System.Net.WebClient).DownloadFile($uri, $filename)
mv ./winutils.exe "$sparkFolder/bin"
set HADOOP_HOME=$sparkFolder

# Set path
$oldpath = (Get-ItemProperty -Path ‘Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment’ -Name PATH).path
$newpath = "$oldpath;$sparkFolder\bin"
Set-ItemProperty -Path ‘Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment’ -Name PATH -Value $newPath



# Resolving issue: https://issues.apache.org/jira/browse/SPARK-2356
# $path=(Convert-Path .)
# $sparkFolder="C:\spark\"
# set SPARK_HOME=$sparkFolder
# $uri="https://github.com/steveloughran/winutils/raw/master/hadoop-2.7.1/bin/winutils.exe"
# $filename=$path + "\"+ "winutils.exe"
# (New-Object System.Net.WebClient).DownloadFile($uri, $filename)
# mv ./winutils.exe "$sparkFolder/bin"
# set HADOOP_HOME=$sparkFolder
