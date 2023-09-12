# Bài tập: Cho một mảng 1 chiều x, tính mảng y và z sao cho y[i] = pi/2 - x[i] và z[i] = cos(x[i]) - sin(x[i]). Sau đó trả về tổng các phần tử của z
# import numpy as numpy
# def tinh_tong(x):
#     y = numpy.pi / 2 - x
#     z = numpy.cos(x) - numpy.sin(x)
#     return sum(z)
# x = numpy.array([1, 2, 3, 4, 5])
# # n=int(input("nhap n: "))
# # x=numpy.array([i for i in range(n)])
# print(tinh_tong(x))


import numpy as np
import math
X = np.array([1, 2, 3, 4, 5], dtype = int)
Y = np.zeros(shape = (X.size))
Z = np.zeros(shape = (X.size))
for i in range(0, X.size, 1):
    Y[i] = math.pi/2 - X[i]
    Z[i] = math.cos(X[i]) + math.sin(X[i])
print(X)
print("\n")
print(Y)
print("\n")
print(Z)
print("\n")
print("Tong Z: ", np.sum(Z))
