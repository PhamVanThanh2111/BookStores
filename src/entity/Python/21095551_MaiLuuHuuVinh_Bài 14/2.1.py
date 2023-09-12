# Khai báo một mảng numpy hai chiều A mô tả ma trận:
# A=[1 2 3]
#   [4 5 6]  
#   [7 8 9]


# import numpy as np
# a=np.array([[1,2,3],[4,5,6],[7,8,9]])
# print("A=",a)

matrix = [
    [1000,2,3],
    [4,3000,6],
    [7,200,9]
]
for dong in matrix:
    for phan_tu in dong:
        print("{:<10}".format(phan_tu),end="")
    print()
