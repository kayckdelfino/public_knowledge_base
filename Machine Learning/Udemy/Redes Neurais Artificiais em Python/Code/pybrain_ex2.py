from pybrain.tools.shortcuts import buildNetwork
from pybrain.datasets import SupervisedDataSet
from pybrain.supervised.trainers import BackpropTrainer

# Example network construction with specific layer types
# network = buildNetwork(2, 3, 1, outclass=SoftmaxLayer, hiddenclass=SigmoidLayer, bias=False)

# Build a neural network with 2 input neurons, 3 hidden neurons, and 1 output neuron
network = buildNetwork(2, 3, 1)

# Create a supervised dataset for training
dataset = SupervisedDataSet(2, 1)
dataset.addSample((0, 0), (0, ))
dataset.addSample((0, 1), (1, ))
dataset.addSample((1, 0), (1, ))
dataset.addSample((1, 1), (0, ))
print(dataset["input"])
print(dataset["target"])

# Create a backpropagation trainer with specified learning rate and momentum
trainer = BackpropTrainer(network, dataset=dataset, learningrate=0.01, momentum=0.06)

# Train the network for a specified number of epochs
for i in range(1, 30000):
    error = trainer.train()
    if i % 1000 == 0:
        print("Error: %s" % error)

# Test the trained network
print(network.activate([0, 0]))
print(network.activate([1, 0]))
print(network.activate([0, 1]))
print(network.activate([1, 1]))