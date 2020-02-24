#!/bin/sh
/usr/bin/flock -n /tmp/wiki_$(basename -- $1)_extractor.lockfile bzip2 -d $1 \; 
