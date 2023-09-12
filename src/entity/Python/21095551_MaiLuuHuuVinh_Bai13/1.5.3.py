# Bài tập: Cho trước một số tự nhiên n. Tạo một mảng có n phần tử mà các phần tử có chỉ số chẵn (bắt đầu từ 0) là một cấp số cộng bắt đầu từ 2, công sai bằng -0.5; các phần tử có chỉ số lẻ bằng -1
# Với n=4, kết quả trả về là mảng [ 2. -1. 1.5 -1. ]. Với n=5, kết quả trả về là mảng [ 2. -1. 1.5 -1. 1. ].

def tao_mang(n):
    arr = []
    for i in range(n):
        if i % 2 == 0:
            arr.append(2 + (-0.5 * (i / 2)))
        else:
            arr.append(-1)
    return arr
n = int(input("nhap n: "))
print(tao_mang(n))




