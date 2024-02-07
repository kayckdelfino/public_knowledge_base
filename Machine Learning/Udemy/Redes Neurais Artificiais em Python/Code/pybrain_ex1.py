from pybrain.structure import FeedForwardNetwork
from pybrain.structure import LinearLayer, SigmoidLayer, BiasUnit
from pybrain.structure import FullConnection

# Create a feedforward neural network
network = FeedForwardNetwork()

# Define layers: input layer with 2 neurons, hidden layer with 3 neurons, and output layer with 1 neuron
input_layer = LinearLayer(2)
hidden_layer = SigmoidLayer(3)
output_layer = SigmoidLayer(1)

# Define bias units for the hidden and output layers
bias_hidden = BiasUnit()
bias_output = BiasUnit()

# Add layers and bias units to the network
network.addInputModule(input_layer)
network.addModule(hidden_layer)
network.addOutputModule(output_layer)
network.addModule(bias_hidden)
network.addOutputModule(bias_output)

# Create connections between layers and bias units
input_hidden_connection = FullConnection(input_layer, hidden_layer)
hidden_output_connection = FullConnection(hidden_layer, output_layer)
bias_hidden_connection = FullConnection(bias_hidden, hidden_layer)
bias_output_connection = FullConnection(bias_output, output_layer)

# Add connections to the network
network.addConnection(input_hidden_connection)
network.addConnection(hidden_output_connection)
network.addConnection(bias_hidden_connection)
network.addConnection(bias_output_connection)

# Sort modules (necessary for the network to be operational)
network.sortModules()

# Print network information
print(network)

# Print parameters of connections
print("Input to hidden weights:", input_hidden_connection.params)
print("Hidden to output weights:", hidden_output_connection.params)
print("Hidden bias weights:", bias_hidden_connection.params)
print("Output bias weights:", bias_output_connection.params)