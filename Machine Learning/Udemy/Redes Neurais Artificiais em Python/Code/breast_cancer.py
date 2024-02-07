import numpy as np
from sklearn import datasets

# Sigmoid activation function
def sigmoid(soma):
    return 1 / (1 + np.exp(-soma))

# Derivative of sigmoid activation function
def sigmoid_derivative(sig):
    return sig * (1 - sig)

# Load breast cancer dataset from sklearn
base = datasets.load_breast_cancer()
inputs = base.data
output_values = base.target
outputs = np.empty([569, 1], dtype=int)
for i in range(569):
    outputs[i] = output_values[i]

# Initialize random weights for input and hidden layers
weights_input_hidden = 2 * np.random.random((30,5)) - 1
weights_hidden_output = 2 * np.random.random((5,1)) - 1

# Define training parameters
epochs = 10000  # Number of epochs
learning_rate = 0.3  # Learning rate
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
    error_output_layer = outputs - output_layer
    mean_absolute_error = np.mean(np.abs(error_output_layer))
    print("Error: " + str(mean_absolute_error))
    
    # Backpropagation
    derivative_output = sigmoid_derivative(output_layer)
    delta_output = error_output_layer * derivative_output
    
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