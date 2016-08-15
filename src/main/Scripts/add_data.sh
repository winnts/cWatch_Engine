#!/usr/bin/env bash

serverList="server_list"
userList="user_list11"
username="root"
fileName="wordpress-4.5.3.tar.gz"


while read -u 10 serverIP || [[ -n ${serverIP} ]]; do

scp -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ~/Downloads/${fileName} ${username}@${serverIP}:/tmp

while read -u 10 hostUser || [[ -n ${hostUser} ]]; do

ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ${username}@${serverIP} -t "sudo -u ${hostUser} tar -zxvf /tmp/${fileName} -C /home/${hostUser}/public_html/"

done 10<${userList}

done 10<${serverList}



exit 0

