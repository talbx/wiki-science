#!/usr/bin/python

import sys
import os
import json
import urllib2

mirror = "https://dumps.wikimedia.org"

def invalid_dump_status():
    print "dumpstatus.json is invalid or in progress."
    exit(1)

if len(sys.argv) == 2:
    #print "downloading dumpstatus.json..."
    filedata = urllib2.urlopen(sys.argv[1]);
    data = filedata.read()
    #print "reading..."
    dumpstatus = json.loads(data)
    if "version" in dumpstatus:
        if dumpstatus["version"] == "0.8":
            #correct version
            if "jobs" in dumpstatus and "metahistorybz2dump" in dumpstatus["jobs"] and "status" in dumpstatus["jobs"]["metahistorybz2dump"] and "done" == dumpstatus["jobs"]["metahistorybz2dump"]["status"] and "files" in dumpstatus["jobs"]["metahistorybz2dump"] and len(dumpstatus["jobs"]["metahistorybz2dump"]["files"]) >= 1:
                #print "copy & execute:"
                for wfile in dumpstatus["jobs"]["metahistorybz2dump"]["files"]:
                    print "wget " + mirror + dumpstatus["jobs"]["metahistorybz2dump"]["files"][wfile]["url"] 
            else:
                invalid_dump_status()
        else:
            print dumpstatus["version"] + " is currently not supported."
            exit(1)
    else:
        invalid_dump_status()
else:
    print "usage: python wiki_downloader.py <https://dumps.wikimedia.org/enwiki/YYYYMM01/dumpstatus.json>"
    exit(1)

