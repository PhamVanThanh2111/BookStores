import numpy as np

def create_random_array(a, b, m, n):
    return np.random.uniform(a, b, size=(m, n))
a = 1  # giá trị a
b = 1   # giá trị b
m = 3    # số hàng
n = 4    # số cột
random_array = create_random_array(a, b, m, n)
print(random_array)