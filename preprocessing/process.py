import sys
import os
import lxml.html

import re

from geopy import geocoders
import codecs
g = geocoders.GeoNames()
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
        counter = 1
        for e in t:
            if(e == None):
                break 
            string = string + e.text_content()
            string = string + "\t"
            #print counter
            if(counter == 2):
                city = e.text_content()
                city = re.sub(r'\([^)]*\)', '', city)
                city = city.split("-")[0]
            if(counter == 3):
                state = e.text_content()
                state = re.sub(r'\([^)]*\)', '', state)
                state = state.split("-")[0]
            if(counter == 7):
                if(g.geocode(city + "," + state, exactly_one=False) == None):
                    print city
                    print state
                    counter = 1
                    string = string + "\n"
                    continue
                templist = list(g.geocode(city + "," + state, exactly_one=False))
                
                string = string + str(templist[0][1][0]) + "," + str(templist[0][1][1]) + "\t"
                string = string + "\n"
                counter = 0
            counter = counter + 1
            #print string
        string = string[::-1]
        j = "DateTime\tCity\tState\tShape\tDuration\tSummary\tPosted\tCoordinates\n"
        j = j[::-1]
        string = string + j
        string = string[::-1]
        with codecs.open("processed/" + infile + '.txt', encoding='utf-8', mode='w') as h:
            h.write(string)
            

                
            
