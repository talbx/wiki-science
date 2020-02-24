#!/bin/sh
find $2 -mmin +5 -type f -name "*.bz2" -exec $1 {} \; 
