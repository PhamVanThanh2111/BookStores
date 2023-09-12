#  Cho một ma trận A bất kỳ. Trong mỗi hàng, ta định nghĩa độ biến động của nó là sự khác nhau giữa giá trị lớn nhất và nhỏ nhất của các phần tử trong hàng đó. Hãy viết hàm myfunc trả về tổng độ biến động của tất cả các hàng trong ma trận đó.

# Ví dụ với ma trận A trong bài học, độ biến động của mỗi hàng lần lượt là 2.0, 4.0, 3.0. Vậy myfunc(A) = 9.0.
import numpy as numpy
def myfunc(A):
    return numpy.sum(numpy.max(A,axis=1)-numpy.min(A,axis=1))
A = numpy.array([[1., 2, 3, 2], [4, 3, 7, 4], [1, 4, 2, 3]])
print("myfunc(A) =",myfunc(A))
