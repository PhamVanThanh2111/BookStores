# Bài tập: Hãy tạo ma trận A sau một cách nhanh nhất, không dùng cách thủ công ghi từng phần tử ra.
# [[ 1  5  9 2]
#  [ 6  10 3 7]
#  [ 11 41 8 12]
# sử dụng np.arange(),transpose(),reshape()
import numpy as numpy
A=numpy.arange(1,13).reshape(4,3)
A=numpy.transpose(A)
print(A)



