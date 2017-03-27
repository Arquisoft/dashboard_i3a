cls
cd %~dp0
start start_zookeeper.bat
timeout /t 10
start start_kafka.bat