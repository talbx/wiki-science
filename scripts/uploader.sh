#!/bin/bash
/usr/bin/flock -n /tmp/wiki_page_extractor_$(basename -- $2).lockfile cat $2 | ssh $1 "hadoop fs -put - wiki-sience-full-dataset/$(basename -- $2)" && mv $2 "$2.hadoop"