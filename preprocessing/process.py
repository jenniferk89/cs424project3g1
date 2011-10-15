import sys
import os
import lxml.html

import re


import codecs

path = '/Users/zitterbewegung/Dropbox/school/cs424/project3/www.nuforc.org/webreports/'
listing = os.listdir(path)
def get_text(el, class_name):
     els = el.find_class(class_name)
     if els:
         return els[0].text_content()
     else:
         return ''
for infile in listing:
    with codecs.open(path + "/" + infile, encoding='utf-8', mode='r+') as f:
        buffer = f.read()
        t = lxml.html.fromstring(buffer)
        t = t.xpath("//td")
        string = ""
        counter = 0
        for e in t:
            string = string + e.text_content()
            string = string + "\t"
            if((counter % 6) == 0 and counter != 0):
                string = string + "\n"
            counter = counter + 1
            #print string
        string = string[::-1]
        j = "DateTime\tCity\tState\tShape\tDuration\tSummary\tPosted\n"
        j = j[::-1]
        string = string + j
        string = string[::-1]
        with codecs.open("processed/" + infile + '.txt', encoding='utf-8', mode='w') as g:
            g.write(string)
            

                
            
