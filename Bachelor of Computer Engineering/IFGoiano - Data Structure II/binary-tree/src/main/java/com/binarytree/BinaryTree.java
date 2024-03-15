package com.binarytree;

public class BinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {
    @Override
    public Node<T> createTree(T element) {
        // Checks if the element is null
        if (element == null) {
            return null;
        } else {
            // Creates a new node to be the root of the tree
            Node<T> rootNode = new Node<>();
            // Sets the value of the element for the root
            rootNode.setValue(element);

            return rootNode;
        }
    }

    @Override
    public Node<T> createTree(T[] elements) {
        // Checks if the array of elements is null or empty
        if (elements == null || elements.length == 0) {
            return null;
        } else {
            // Creates the root of the tree with the first element of the array
            Node<T> rootNode = createTree(elements[0]);

            // Inserts the remaining elements of the array into the tree
            for (int i = 1; i < elements.length; i++) {
                insert(rootNode, elements[i]);
            }

            return rootNode;
        }
    }

    @Override
    public Integer degree(Node<T> rootNode, T nodeElement) {
        // Checks if the root node is null
        if (rootNode == null) {
            return null;
        } else {
            // Gets the node corresponding to the specified element in the tree
            Node<T> node = getByElement(rootNode, nodeElement);

            // Checks if the corresponding node was found
            if (node == null) {
                return null;
            } else {
                int degree = 0; // Initializes the node degree as zero

                // Checks if the node has a left child and increments the degree if it does
                if (node.getLeft() != null) {
                    degree++;
                }
                // Checks if the node has a right child and increments the degree if it does
                if (node.getRight() != null) {
                    degree++;
                }

                return degree;
            }
        }
    }

    @Override
    public void insert(Node<T> rootNode, T element) {
        // Checks if the root node is null
        if (rootNode == null) {
            throw new IllegalArgumentException("Root node cannot be null."); // If null, throws an exception
        } else {
            // If the element is less than the value of the root node
            if (element.compareTo(rootNode.getValue()) < 0) {
                // Checks if the left node is empty and inserts the element to the left if it is
                if (rootNode.getLeft() == null) {
                    rootNode.setLeft(createTree(element));
                } else {
                    // If not empty, recursively calls the method to insert to the left
                    insert(rootNode.getLeft(), element);
                }
                // If the element is greater than the value of the root node
            } else if (element.compareTo(rootNode.getValue()) > 0) {
                // Checks if the right node is empty and inserts the element to the right if it is
                if (rootNode.getRight() == null) {
                    rootNode.setRight(createTree(element));
                } else {
                    // If not empty, recursively calls the method to insert to the right
                    insert(rootNode.getRight(), element);
                }
            }
        }
    }

    @Override
    public boolean remove(Node<T> rootNode, T nodeElement) {
        // Finds the node to be removed in the tree
        Node<T> nodeToRemove = getByElement(rootNode, nodeElement);
        // Finds the parent of the node to be removed in the tree
        Node<T> fatherNode = getFather(rootNode, nodeElement);

        // Checks if the node to be removed was found in the tree
        if (nodeToRemove == null) {
            return false; // If not found, returns false (nothing to be removed)
        }

        // Case 1: Node to be removed has no children
        if (nodeToRemove.getLeft() == null && nodeToRemove.getRight() == null) {
            if (fatherNode == null) {
                rootNode.setValue(null); // If the node to be removed is the root, makes the root null
            } else if (fatherNode.getLeft() == nodeToRemove) {
                fatherNode.setLeft(null); // Removes the reference from the parent to the node to be removed (on the left side)
            } else {
                fatherNode.setRight(null); // Removes the reference from the parent to the node to be removed (on the right side)
            }
        }

        // Case 2: Node to be removed has only one child
        else if (nodeToRemove.getLeft() == null || nodeToRemove.getRight() == null) {
            // Selects the child node (left or right) of the node to be removed
            Node<T> childNode = (nodeToRemove.getLeft() != null) ? nodeToRemove.getLeft() : nodeToRemove.getRight();
            
            // Updates the parent reference to the child node
            if (fatherNode == null) {
                // If the node to be removed is the root, updates the root to the child node
                rootNode.setValue(childNode.getValue());
                rootNode.setLeft(childNode.getLeft());
                rootNode.setRight(childNode.getRight());
            } else if (fatherNode.getLeft() == nodeToRemove) {
                fatherNode.setLeft(childNode); // Updates the parent reference to the child node (left side)
            } else {
                fatherNode.setRight(childNode); // Updates the parent reference to the child node (right side)
            }
        }

        // Case 3: Node to be removed has two children
        else {
            // Finds the predecessor node
            Node<T> predecessorNode = nodeToRemove.getLeft();
            // Finds the successor node
            Node<T> successorNode = nodeToRemove.getRight();
        
            // Replaces the value of the node to be removed with the value of the successor node
            nodeToRemove.setValue(successorNode.getValue());

            // Updates the references of the node to be removed to the successor nodes
            nodeToRemove.setLeft(successorNode.getLeft());
            nodeToRemove.setRight(successorNode.getRight());

            // Retrieves the left node in the successor node's subtree
            Node<T> successorLeftNode = successorNode.getLeft();

            // If this left node is not null
            if (successorLeftNode != null) {
                // Traverse until finding the leftmost node
                while (successorLeftNode.getLeft() != null) {
                    successorLeftNode = successorLeftNode.getLeft();
                }
                
                successorLeftNode.setLeft(predecessorNode); // Connects the predecessor node to the leftmost node of the successor
            } else {
                nodeToRemove.setLeft(predecessorNode); // Connects the predecessor node directly to the node to be removed
            }
        }
        
        return true; // Returns true indicating the removal was successful
    }

    @Override
    public Node<T> getFather(Node<T> rootNode, T nodeElement) {
        // Checks if the root node is null or if the value of the root node is equal to the searched element
        if (rootNode == null || rootNode.getValue().equals(nodeElement)) {
            return null;
        } else {
            // Checks if the left child of the root node exists and if its value is equal to the searched element
            if (rootNode.getLeft() != null && rootNode.getLeft().getValue().equals(nodeElement)) {
                return rootNode; // Returns the root node (parent of the searched node)
            }
            
            // Checks if the right child of the root node exists and if its value is equal to the searched element
            else if (rootNode.getRight() != null && rootNode.getRight().getValue().equals(nodeElement)) {
                return rootNode; // Returns the root node (parent of the searched node)
            }
            
            else {
                // Recursively searches for the parent of the searched node in the left child
                Node<T> leftFather = getFather(rootNode.getLeft(), nodeElement);
                if (leftFather != null) {
                    return leftFather; // If found in the left child, returns the found parent
                }

                // Recursively searches for the parent of the searched node in the right child
                Node<T> rightFather = getFather(rootNode.getRight(), nodeElement);
                if (rightFather != null) {
                    return rightFather; // If found in the right child, returns the found parent
                }

                return null; // If not found, returns null (no parent exists)
            }
        }
    }

    @Override
    public Node<T> getBrother(Node<T> rootNode, T nodeElement) {
        // Gets the parent of the node corresponding to the specified element
        Node<T> fatherNode = getFather(rootNode, nodeElement);

        // Checks if the parent does not exist (root or node is not in the tree)
        if (fatherNode == null) {
            return null;
        }

        // Checks if the node is the left child of the parent
        else if (fatherNode.getLeft() != null && fatherNode.getLeft().getValue().equals(nodeElement)) {
            return fatherNode.getRight();
        }

        // Checks if the node is the right child of the parent
        else if (fatherNode.getRight() != null && fatherNode.getRight().getValue().equals(nodeElement)) {
            return fatherNode.getLeft();
        }
        
        // If the node is neither the left nor right child of the parent, it has no brother
        else {
            return null;
        }
    }

    @Override
    public Node<T> getByElement(Node<T> rootNode, T element) {
        // Checks if the root node is null
        if (rootNode == null) {
            return null;
        } else {
            // Checks if the value of the root node is equal to the searched element
            if (rootNode.getValue().equals(element)) {
                return rootNode;
            } else {
                // Recursively searches for the element in the left child
                Node<T> leftNode = getByElement(rootNode.getLeft(), element);
                // If the element is found in the left child, returns the corresponding node
                if (leftNode != null) {
                    return leftNode;
                }

                // Recursively searches for the element in the right child
                Node<T> rightNode = getByElement(rootNode.getRight(), element);
                // If the element is found in the right child, returns the corresponding node
                if (rightNode != null) {
                    return rightNode;
                }

                // If the element is not found in either child, returns null
                return null;
            }
        }
    }

    @Override
    public Integer calculateTreeDepth(Node<T> rootNode) {
        // Checks if the root node is null
        if (rootNode == null) {
            return -1;
        }
        
        // Calculates the depth of the left subtree
        int leftDepth = calculateTreeDepth(rootNode.getLeft());
        // Calculates the depth of the right subtree
        int rightDepth = calculateTreeDepth(rootNode.getRight());
        
        // Returns the maximum depth between the left and right subtrees, adding 1 to include the root node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    @Override
    public Integer calculateNodeLevel(Node<T> rootNode, T nodeElement) {
        // Checks if the root node is null
        if (rootNode == null) {
            return null;
        }
        
        // Checks if the value of the root node is equal to the searched element
        if (rootNode.getValue().equals(nodeElement)) {
            return 0;
        }
        
        // Recursively calculates the level of the element in the left and right children
        Integer leftLevel = calculateNodeLevel(rootNode.getLeft(), nodeElement);
        Integer rightLevel = calculateNodeLevel(rootNode.getRight(), nodeElement);
        
        // Checks if the element was found in both children
        if (leftLevel != null && rightLevel != null) {
            // Returns the minimum level between the children plus 1 to include the root node
            return Math.min(leftLevel, rightLevel) + 1;
        }
        
        else if (leftLevel != null) {
            // Returns the level of the left child plus 1 to include the root node
            return leftLevel + 1;
        }
        
        else if (rightLevel != null) {
            // Returns the level of the right child plus 1 to include the root node
            return rightLevel + 1;
        }
        
        else {
            return null; // Returns null if the element was not found
        }
    }

    @Override
    public String toString(Node<T> rootNode) {
        if (rootNode == null) {
            return ""; // Returns an empty string if the tree is empty
        }
        
        StringBuilder result = new StringBuilder();
        String prefix = ""; // Sets the prefix for the current node
        
        // Checks if the root node is the parent node, if yes, the prefix is "root:", otherwise, determines if it is the left or right child
        if (getFather(rootNode, rootNode.getValue()) == null) {
            prefix = "root:";
        } else {
            Node<T> fatherNode = getFather(rootNode, rootNode.getValue());
            prefix = fatherNode.getLeft() == rootNode ? "left:" : "right:";
        }

        // Adds the prefix and the value of the root node to the tree representation
        result.append(prefix).append(rootNode.getValue()).append(" ");
        
        // Checks if the root node has children
        if (rootNode.getLeft() != null || rootNode.getRight() != null) {
            result.append("(");

            // Adds the representation of the children to the tree representation
            if (rootNode.getLeft() != null) {
                result.append(toString(rootNode.getLeft(), rootNode));
            }

            if (rootNode.getRight() != null) {
                result.append(toString(rootNode.getRight(), rootNode));
            }

            result.append(")");
        } 

        return result.toString(); // Returns the tree representation as a string
    }

    private String toString(Node<T> rootNode, Node<T> fatherNode) {
        // Checks if the node is null
        if (rootNode == null) {
            return ""; // Returns an empty string if the node is empty
        }

        StringBuilder result = new StringBuilder();
        String prefix = fatherNode.getLeft() == rootNode ? "left:" : "right:"; // Sets the prefix for the current node based on the parent node

        // Adds the prefix and the value of the node to the subtree representation
        result.append(prefix).append(rootNode.getValue()).append(" ");
        
        // Checks if the node has children
        if (rootNode.getLeft() != null || rootNode.getRight() != null) {
            result.append("(");

            // Adds the representation of the children to the subtree representation
            if (rootNode.getLeft() != null) {
                result.append(toString(rootNode.getLeft(), rootNode));
            }

            if (rootNode.getRight() != null) {
                result.append(toString(rootNode.getRight(), rootNode));
            }
            
            result.append(")");
        } 

        return result.toString(); // Returns the subtree representation as a string
    }
}