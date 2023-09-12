# Bài tập: Trong bài toán classification, sử dụng Softmax Regression, giả sử ta đã tính được xác suất để một điểm dữ liệu thuộc vào mỗi class. Các xác suất này được lưu dưới dạng một mảng một chiều mà phần tử thứ i là xác suất để điểm dữ liệu rơi vào lớp i. Nhãn của dữ liệu được dự đoán là chỉ số của lớp mà điểm dữ liệu rơi vào với xác suất cao nhất. Hãy viết một hàm số xác định chỉ số đó.
# Chú ý: Mảng chứa xác suất này thường được tính bằng cách áp dụng hàm softmax vào score vector. Hàm softmax giữ nguyên thứ tự của vector đầu vào, vì vậy chỉ số của lớp có xác suất cao nhất cũng là chỉ số của lớp có score cao nhất. (Mời bạn đọc thêm bài Softmax Regression để biết thêm chi tiết). 
import numpy as numpy
def predict_label(prob):
    return numpy.argmax(prob)




