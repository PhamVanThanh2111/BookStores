# Cho một ma trận A, viết hàm myfunc tính tổng các phần tử trên các cột có chỉ số chẵn (0, 2, 4, ...) của ma trận đó.
import numpy as numpy
def myfunc(A):
    return numpy.sum(A[:,::2])
A = numpy.array([[1,2],[3,4]])
print(myfunc(A))    

