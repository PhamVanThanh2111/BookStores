# Bài tập: Viết hàm myfunc tính tổng tất cả các phần tử có cả hai chỉ số đều chẵn của một ma trận A bất kỳ
import numpy as numpy
def myfunc(A):
    return numpy.sum(A[::2,::2])
A = numpy.array([[ 1,  2,  3,  4],[ 5,  6,  7,  8],[ 9, 10, 11, 12]])
print(myfunc(A))