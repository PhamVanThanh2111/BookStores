# Viết hàm số tính tổng trị tuyệt đối các phần tử của một mảng một chiều.
# (Gợi ý: np.abs.)
import numpy as np
def tinh_tong(x):
    return sum(np.abs(x))
# x = np.array([1, 2, 3, 4, 5])
n=int(input("nhap mang mot chieu: "))
x=np.zeros(n)
for i in range(0,n,1):
    x[i]=float(input("nhap phan tu thu %d: "%(i+1)))
print("Tổng trị tuyệt đối các phần tử của một mảng một chiều :",tinh_tong(x))

# import numpy as np1
# A = np.array([-1, 3, 6, -10, -12, -60])
# B = np.zeros(shape = (A.size))
# for i in range(0, A.size, 1):
#     B[i] = np.abs(A[i])
# print(B)
