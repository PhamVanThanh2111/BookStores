import  pandas as pd 
import numpy as np 

#Câu 01: write a pandas program to create a dataframe from a dictionary and display it. Sample data:{"X":[78,85,96,80,86],"Y":[84,94,89,83,86],"Z":[86,97,96,72,83]}

datas={"X":[78,85,96,80,86],"Y":[84,94,89,83,86],"Z":[86,97,96,72,83]}
df = pd.DataFrame(datas)
print("Câu 01:")
print(df)