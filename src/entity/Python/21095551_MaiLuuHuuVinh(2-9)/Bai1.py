import matplotlib.pyplot as plt
import pandas as pd
# plt.plot([1,2,3,4], [1,4,9,16], 'ro')
# plt.axis([0, 6, 0, 20])
# plt.show()

# some imports to set up plotting
import matplotlib.pyplot as plt
# pip install seaborn
import seaborn as sns

# Graphics in retina format are more sharp and legible
# %config InlineBackend.figure_format = 'retina'

df = pd.DataFrame({'A':[1,2,3],
                   'B':[4,5,6],
                   'C':[7,8,9],
                   'D':[1,3,5],
                   'E':[5,3,6],
                   'F':[7,4,3]})
print(df)
X = df.iloc[:, :-1].values
print([df.iloc[:   , 5]])
print (X.shape)
