# The XOR problem is an example of a non-linearly separable problem,
# meaning a single straight line or plane cannot separate the classes.
# In the XOR problem, the output is 1 if the inputs are different and 0 if they are the same.
# A single-layer neural network cannot solve this problem because it can only learn linear decision boundaries.

# To solve non-linearly separable problems like XOR, we use a multi-layer neural network.
# The hidden layer(s) of a multi-layer neural network allow for the creation of non-linear transformations
# of the input space, enabling the network to learn and represent non-linear decision boundaries.
# This allows the network to solve problems that are not solvable by single-layer networks.

# In this code, we use a multi-layer neural network with one hidden layer to solve the XOR problem.
# The hidden layer introduces non-linearity into the network, enabling it to learn the XOR function
# and correctly classify the input patterns.


import numpy as np

# Sigmoid activation function
def sigmoid(soma):
    return 1 / (1 + np.exp(-soma))

# Derivative of sigmoid activation function
def sigmoid_derivative(sig):
    return sig * (1 - sig)

# Define input and output data for training (XOR gate)
inputs = np.array([[0,0],
                   [0,1],
                   [1,0],
                   [1,1]])

outputs = np.array([[0],[1],[1],[0]])

# Initialize random weights for the input layer and hidden layer
weights_input_hidden = 2 * np.random.random((2,3)) - 1
weights_hidden_output = 2 * np.random.random((3,1)) - 1

# Define training parameters
epochs = 1000000  # Number of epochs
learning_rate = 0.5  # Learning rate
momentum = 1  # Momentum (not used in this implementation)

# Training loop
for j in range(epochs):
    # Forward propagation
    input_layer = inputs
    sum_synapse_input_hidden = np.dot(input_layer, weights_input_hidden)
    hidden_layer = sigmoid(sum_synapse_input_hidden)
    
    sum_synapse_hidden_output = np.dot(hidden_layer, weights_hidden_output)
    output_layer = sigmoid(sum_synapse_hidden_output)
    
    # Calculate error and print mean absolute error
    error_hidden_output = outputs - output_layer
    mean_absolute_error = np.mean(np.abs(error_hidden_output))
    print("Error: " + str(mean_absolute_error))
    
    # Backpropagation
    derivative_output = sigmoid_derivative(output_layer)
    delta_output = error_hidden_output * derivative_output
    
    weights_hidden_output_transpose = weights_hidden_output.T
    delta_output_x_weight = delta_output.dot(weights_hidden_output_transpose)
    delta_hidden_layer = delta_output_x_weight * sigmoid_derivative(hidden_layer)
    
    # Update weights using gradients
    hidden_layer_transpose = hidden_layer.T
    new_weights_hidden_output = hidden_layer_transpose.dot(delta_output)
    weights_hidden_output = (weights_hidden_output * momentum) + (new_weights_hidden_output * learning_rate)
    
    input_layer_transpose = input_layer.T
    new_weights_input_hidden = input_layer_transpose.dot(delta_hidden_layer)
    weights_input_hidden = (weights_input_hidden * momentum) + (new_weights_input_hidden * learning_rate)