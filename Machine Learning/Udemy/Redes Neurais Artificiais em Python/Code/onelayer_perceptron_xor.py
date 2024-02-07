# XOR problem: XOR is a nonlinearly separable problem,
# meaning a single straight line cannot separate the classes.
# This limitation of perceptron arises because it can only
# learn linear decision boundaries.

# Due to the XOR problem, this perceptron training is not
# going to converge as it attempts to learn linear separation
# for a problem that is inherently nonlinear.

# The weights will keep updating, but the total error will not
# converge to zero because the problem cannot be solved with
# a single-layer perceptron.

# To solve the XOR problem, a more complex neural network
# architecture such as a multi-layer perceptron (MLP) is required,
# which can learn nonlinear decision boundaries.


import numpy as np

# Define inputs, outputs, weights, and learning rate
inputs = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
outputs = np.array([0, 1, 1, 0])  # XOR outputs
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