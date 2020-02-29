#!/usr/bin/env python
import re
import sys

for line in sys.stdin:
    val = line.strip()
    start = 0
    end = 0
    while start > -1 and end > -1:
        start = val.find("<ns0:page>", end)

        end = val.find("</ns0:page>", start)
        if start > -1 and end > -1:
            print(val[start:end+11])



    # hadoop jar /opt/cloudera/parcels/CDH/lib/hadoop-mapreduce/hadoop-streaming.jar -file
      tokenmapper.py -file sumreducer.py -mapper tokenmapper.py
      -reducer sumreducer.py -input INOUT -output OUTPUT