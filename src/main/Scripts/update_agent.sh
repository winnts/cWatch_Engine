#!/usr/bin/env bash

serverList="server_list"
username="root"
fileName="cwatch_client_install.sh"


rm ${fileName}
wget http://10.8.3.198:8080/job/Installer_QA-103/ws/agent/linux/trunk/build/${fileName}

while read -u 10 serverIP || [[ -n ${serverIP} ]]; do

scp -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ${fileName} ${username}@${serverIP}:~
ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ${username}@${serverIP} -t "bash ${fileName} -- --update"

done 10<${serverList}

exit 0
