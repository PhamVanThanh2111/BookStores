# Cho một mảng hai chiều A, hãy viết hàm fro_trace tính bình phương của Frobineus norm của ma trận này dựa vào công thức trên.
# Gợi ý:# sử dụng hàm np.diag, np.dot, np.trace
import numpy as np
def fro_trace(A):
    return np.trace(np.dot(A.T, A))
A = np.array([[1, 2, 3], [4, 5, 6]])
print(fro_trace(A))
