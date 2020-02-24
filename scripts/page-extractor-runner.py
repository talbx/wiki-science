#!/bin/sh
# $1 = page-extractor-worker.py
# $2 = page-extractor.py
# $3 = /srv/data/pages-article-meta-history
find $3 -mmin +5 -type f -name "*.xml-p*" ! -name "*.bz2" -exec /bin/sh $1 $2 $3 {} \; 
