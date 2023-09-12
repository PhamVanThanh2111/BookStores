
#  zero-mean là trung bình cộng của toàn bộ dữ liệu là một vector có toàn bộ các thành phần bằng 0.
# Cho một mảng hai chiều X mô tả dữ liệu, trong đó X[i] là một mảng một chiều mô tả dữ liệu có chỉ số i. Hãy viết hàm zero_mean trả về ma trận dữ liệu đã chuẩn hoá theo zero-mean, trong đó mỗi hàng của ma trận là một vector dữ liệu đã chuẩn hoá theo zero-mean.
import numpy as np
def zero_mean(X):
    return X - np.mean(X, axis=0)
X = np.array([[1, 2, 3], [4, 5, 6]])
print(zero_mean(X))


 