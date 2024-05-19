#!/bin/bash

SH_CONFIG="script_config"


curpath=$(dirname $(realpath $0))
CONF_PATH="$curpath/conf"

if [ -z "$curpath" ]; then
    echo "curpath is None"
    exit 1
fi

if [ ! -f "$CONF_PATH/$SH_CONFIG" ]; then
    echo "sh script not found"
    exit 1
fi

BOT_PATH="$curpath/start.sh"
source "$CONF_PATH/$SH_CONFIG"

if [ -z "$MAIN_SCRIPT" ]; then
    echo "no main script"
    exit 1
fi

proc=$(ps -aef | grep "$MAIN_SCRIPT" | grep -v "grep")
if [ -z "$proc" ]; then
    if [ -x $BOT_PATH ]; then
        cd "$curpath"
        export PYTHONUNBUFFERED=1
        nohup $BOT_PATH > output.log &
        # $BOT_PATH
    fi
else
    echo "already running"
fi
