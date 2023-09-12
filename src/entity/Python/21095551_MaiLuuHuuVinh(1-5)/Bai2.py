#Câu 02: Write a Pandas program to get the firts 3 row a given DataFrame Sample Data: exem_data={"name":["Anasta sia","Dima","Katherine","James","Emily","Michael","Matthew","Laura","Kevin","Jonas"]},"score":[12.5,9,16.5,np.an,9,20,14.5,np.an,8,19],"attempts":[1,3,2,3,2,3,1,1,2,1],"qualify":["yes","no","yes","no","no","yes","yes","no","no","yes"]} labels=["a","b","c","d","e","f","g","h","i","j"]

import pandas as pd
import numpy as np

datas  = {'name': ['Anastasia', 'Dima', 'Katherine', 'James', 'Emily', 'Michael', 'Matthew', 'Laura', 'Kevin', 'Jonas'],
        'score': [12.5, 9, 16.5, np.nan, 9, 20, 14.5, np.nan, 8, 19],
        'attempts': [1, 3, 2, 3, 2, 3, 1, 1, 2, 1],
        'qualify': ['yes', 'no', 'yes', 'no', 'no', 'yes', 'yes', 'no', 'no', 'yes']}
labels = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']

df = pd.DataFrame(datas , index=labels)
print("First three rows of the data frame:")
print(df.iloc[:3])

