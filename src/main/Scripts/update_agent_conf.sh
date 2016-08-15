#!/usr/bin/env bash

serverList="server_list"
username="root"
filePath="/etc/cwaf"
fileName="main.conf"


while read -u 10 serverIP || [[ -n ${serverIP} ]]; do

    ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ${username}@${serverIP} -t "cat ${filePath}/${fileName} | sed -e "s!script_version=https://portal\.cwatch\.comodo\.com/cwatch/agent/stage/version\.dat!script_version=https://portal\.cwatch\.comodo\.com/cwatch/agent/version\.dat!" > ${filePath}/${fileName}.tmp"
    ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ${username}@${serverIP} -t "mv ${filePath}/${fileName}.tmp ${filePath}/${fileName}"
    ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ${username}@${serverIP} -t "cat ${filePath}/${fileName} | sed -e "s!script_url=https://portal\.cwatch\.comodo\.com/cwatch/agent/stage/cwatch_client_install\.sh!script_url=https://portal\.cwatch\.comodo\.com/cwatch/agent/cwatch_client_install\.sh!" > ${filePath}/${fileName}.tmp"
    ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ${username}@${serverIP} -t "mv ${filePath}/${fileName}.tmp ${filePath}/${fileName}"
done 10<${serverList}

exit 0
