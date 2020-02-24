#!bin/sh
/usr/bin/flock -n /tmp/wiki_page_extractor_$(basename -- $3).lockfile /usr/bin/python $1 $2 $3 &>/dev/null & 
