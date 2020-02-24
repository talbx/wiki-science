#!/usr/bin/python

# THIS SCRIPT REMOVE THE SOURCE FILE AT THE END!
# THIS SCRIPT REMOVE THE SOURCE FILE AT THE END!
# THIS SCRIPT REMOVE THE SOURCE FILE AT THE END!

import xml.etree.cElementTree as etree
import codecs
import sys
import md5
import os
from subprocess import check_call

working_dir = sys.argv[1]
input_file = sys.argv[2]

m = md5.new()
m.update(input_file)
output_file = working_dir + m.hexdigest() + ".ws"

print "loading..."
i = 0
ispage = False;
f = codecs.open(output_file, "a+", "utf-8")
f.write("<xml version=\"1.0\" encoding=\"UTF-8\">")
f.close

for event, elem in etree.iterparse(input_file, events=('start', 'end')):
    f = codecs.open(output_file, "a+", "utf-8")

    print elem.tag
    if(ispage or elem.tag == "{http://www.mediawiki.org/xml/export-0.10/}page"):
        print "processing " + str(i)
        f.write(etree.tostring(elem).replace('\n', ' ').replace('\r', ''))
        ispage = True
        i += 1
    if(event == "end" and elem.tag == "{http://www.mediawiki.org/xml/export-0.10/}page"):
        f.write("</xml>\n<xml version=\"1.0\" encoding=\"UTF-8\">")
        ispage = False
    elem.clear()
    f.close()

    #while elem.getprevious() is not None:
    #    del elem.getparent()[0]
#f.close()

check_call(['gzip', output_file])
os.remove(input_file)
