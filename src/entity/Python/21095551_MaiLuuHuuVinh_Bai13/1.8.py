# Bài tập: Hãy lập trình hàm softmax.
# Gợi ý: Sử dụng hàm np.exp().
import numpy as np
def softmax(x):
    return np.exp(x) / np.sum(np.exp(x))
n=int(input("nhap mang mot chieu: "))
x=np.zeros(n)
for i in range(0,n,1):
    x[i]=float(input("nhap phan tu thu %d: "%(i+1)))
print("softmax: ",softmax(x)) 
# def softmax_stable(x):
#   _x = x - np.max(x)
#   e = np.exp(_x)1
#   return e / np.sum(e)
