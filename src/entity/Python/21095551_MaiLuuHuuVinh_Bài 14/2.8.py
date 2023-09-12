# Cho hai mảng hai chiều có cùng kích thước A và B. Viết hàm dist_fro tính bình phương Frobenious norm của hiệu hai ma trận được mô tả bởi hai mảng đó.
import numpy as numpy
def dist_fro(A,B):
    return numpy.sqrt(numpy.sum(numpy.square(A-B)))
A=numpy.array([[1,3],[2,5]])
B=numpy.array([[1,2],[3,4]])
print("dist_fro(A,B)=",dist_fro(A,B))

