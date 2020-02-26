#!/bin/bash
#$1 = RZSSH_USER
#$2 = LTHEADNODE_USER
#$3 = HADOOP FILE OR DIRECTORY/*
#$4 = SQL TABLE
#$5 = MYSQL CLIENT

if [[ $# -eq 0 ]] ; then
    echo '#$1 = RZSSH_USER
#$2 = LTHEADNODE_USER
#$3 = HADOOP FILE OR DIRECTORY/*
#$4 = SQL TABLE

'
    exit 0
fi

ssh $1@rzssh1.informatik.uni-hamburg.de "ssh $2@ltheadnode 'hadoop fs -text $3'" > /tmp/wiki-importer-temp.csv && ./import.sql.bash /tmp/wiki-importer-temp.csv $4 
