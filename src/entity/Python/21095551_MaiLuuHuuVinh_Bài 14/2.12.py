import numpy as np

def softmax(Z):
    A = np.exp(Z) / np.sum(np.exp(Z), axis=0, keepdims=True)
    return A
print(softmax(np.array([[1, 2, 3], [4, 5, 6]])))