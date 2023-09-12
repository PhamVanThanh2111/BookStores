# Bài tập: Frobenious norm
import numpy as np
x=np.array([[1,3],[2,5]])
# result=np.linalg.norm(x,ord='fro')
result=np.sqrt(np.sum(np.square(x)))
print("norm_fro(A)=",result)