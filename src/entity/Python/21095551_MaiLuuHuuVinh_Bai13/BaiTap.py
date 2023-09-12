# Bài tập 1: Xây dựng mảng các luỹ thừa của 2 nhỏ hơn 1025, bao gồm cả 1 = 2**0. Gợi ý: Nếu a là một mảng và b là một số thì b**a sẽ trả về một mảng cùng kích thước với a mà phần tử có chỉ số i bằng b**a[i], với ** là toán tử luỹ thừa.
a=[]
for i in range (1):
    a.append(2**i)
print(a)

# Bài tập 2: Xây dựng mảng gồm 10 phần tử, trong đó 9 phần tử đầu bằng 3, phần tử cuối cùng bằng 1.5.
a=[] 
for i in range (9):
    a.append(3)
a.append(1.5)
print(a)

# Bài tập: Thay toàn bộ các phần tử của mảng bằng trung bình cộng các phần tử trong mảng đó, sử dụng vòng for. Hàm này không trả về biến nào mà chỉ thay đổi các giá trị của biến đầu vào x.
def thay_the_bang_trung_binh(arr):
    tong = sum(arr)
    trung_binh = tong / len(arr)
    for i in range(len(arr)):
        arr[i] = trung_binh
x = [1, 2, 3, 4, 5,7]
thay_the_bang_trung_binh(x)
print(x)



