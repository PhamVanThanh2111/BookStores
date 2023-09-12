# Bài tập: Cho hai số tự nhiên N > k > 0 viết hàm số sample_no_replace(N, k) trả về ngẫu nhiên k số tự nhiên nằm trong tập {0, 1, ..., N-1} sao cho không có hai số nào trùng nhau.

# Việc ngẫu nhiên ở đây sẽ được kiểm chứng bằng cách gọi hàm sample_no_replace(N, k) nhiều lần. Trong toàn bộ các kết quả trả về, tần suất xuất hiện của mỗi số trong tập {0, 1, ..., N-1} phải gần bằng nhau.

# Giả sử X là ma trận chứa N điểm dữ liệu theo hàng. Nếu idx =sample_no_replace(N, k) là kết quả trả về của hàm bạn đã viết, k điểm ngẫu nhiên của X có thể được lấy ra bằng X[idx, :].
import numpy as np
def sample_no_replace(N, k):  
    if (k >  N) or (k == N) : 
        raise ValueError("0 < k < N: ")
    idx = np.random.choice(N, size=k, replace=False)
    return idx
print(sample_no_replace(10 , 5))