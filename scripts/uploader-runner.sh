#/bin/sh
find $2 -mmin +5 -type f -name "*.ws.gz" ! -name ".hadoop" -exec echo $1 {} \; 
