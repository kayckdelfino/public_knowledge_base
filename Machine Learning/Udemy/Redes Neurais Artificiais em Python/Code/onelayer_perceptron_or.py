# The OR gate is an example of a problem that is linearly separable,
# meaning it can be separated by a straight line or plane in the input space.

# Unlike the XOR problem, the OR problem can be solved using a single-layer
# perceptron because the OR gate's truth table exhibits linear separability.

# The perceptron iteratively adjusts its weights until it learns a decision
# boundary that separates the two classes (0 and 1) of the OR gate outputs.

# Therefore, the training process for the OR gate problem with a single-layer
# perceptron is expected to converge, and the final weights will correctly
# represent the OR gate logic.


import numpy as np

# Define inputs, outputs, weights, and learning rate for OR gate
inputs = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
outputs = np.array([0, 1, 1, 1])  # OR gate outputs
weights = np.array([0.0, 0.0])  # Initialize weights
learning_rate = 0.1

# Step function
def stepFunction(s):
    if s >= 1:
        return 1
    return 0

# Calculate the output
def calculateOutput(record):
    summation = record.dot(weights)
    return stepFunction(summation)

# Training the perceptron
def train():
    totalError = 1
    while totalError != 0:
        totalError = 0
        for i in range(len(outputs)):
            calculatedOutput = calculateOutput(np.asarray(inputs[i]))
            error = outputs[i] - calculatedOutput
            totalError += error
            for j in range(len(weights)):
                # Update weights based on error and learning rate
                weights[j] = weights[j] + (learning_rate * inputs[i][j] * error)
                print('Updated weight: ' + str(weights[j]))
        print('Total errors: ' + str(totalError))
        
train()
print('Neural network trained')
print(calculateOutput(inputs[0]))
print(calculateOutput(inputs[1]))
print(calculateOutput(inputs[2]))
print(calculateOutput(inputs[3]))