# Xây dựng một mảng ngẫu nhiên hai chiều có shape = (m, n) mà các phần tử của nó tuần theo phân phối chuẩn có kỳ vọng bằng a và phương sai là s.
import numpy as np

def generate_random_array(a, s, m, n):
    arr = np.random.normal(a, np.sqrt(s), size=(m, n))
    return arr
print(generate_random_array(1, 1, 3, 4))