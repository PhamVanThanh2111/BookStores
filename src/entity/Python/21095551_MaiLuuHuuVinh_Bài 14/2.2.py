import numpy as np
# print(np.eye(3))   
 
# Với một số tự nhiên n, hãy viết hàm trả về ma trận có dạng:tức đường chéo phụ ngay dưới đường chéo chính nhận các giá trị từ 1 đến 
# n. Các thành phần là kiểu số nguyên.


# def f(n):
#     return np.eye(n, k=-1, dtype=int)
# print("nhap n: ")4
# n=int(input())
# print(f(n))


print("nhap n: ")
n=int(input())
A=np.diag(np.arange(1,n+1),k=-1)
print(A)

