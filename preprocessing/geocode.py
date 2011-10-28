import sys , os, csv

path = '/Users/zitterbewegung/Dropbox/school/cs424/project3/processed'
listing = os.listdir(path)
for file in listing:
    tsvReader = csv.Reader(open(file, 'rb' ), delimiter='\t')
    counter = 0
    for row in tsvReader:
        if(counter % 1 == 0):
