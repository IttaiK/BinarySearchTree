Author: Ittai Kohavi
Acknowledgments: Mr. Kuzmaul
                 Zev Meyers -> collaberated on Node successor method

List of written methods for the Binary Tree (BinaryTree class):
    insert:
        In: An int 
        Out: Nothing
        Effect: Inserts node in the correct location in the Binary Tree
    deleteNum:
        In: An int
        Out: Nothing
        Effect: Deletes a node of given value, without breaking the Tree
    findMinimum:
        In: Nothing
        Out: an Int
        Effect: returns the smallest Int value of any node in the tree
    getRoot:
        In: Nothing
        Out: An integer
        Effect: returns the value of the root of the tree
    successor:
        In: A BSTnode
        Out: A BSTnode
        Effect: Returns the successive node by value, if two of equal value, returns the higher one in the tree
    printWalk:
        In: Nothing
        Out: A string
        Effect: Returns a string of all the values in the tree in order

Other methods in the BinaryTree class:
    depth: (written by Mr. Kuzmaul)
        In: Nothing
        Out: An int
        Effect: Returns an int equal to the distance from the root to the "deepest" node

List of methods in the BSTnode class
    setBchild:
        In: A node
        out: Nothing
        Effect: Sets the Bchild of a node to a given other node

    depth: (Written by Mr. Kuzmaul)
        In: Nothing
        Out: An int
        Effect: Returns an int equal to the distance from the root to the "deepest" node
    
    getSchild:
        In: Nothing
        Out: A Node
        Effect: gets the Schild of a node

    getBchild:
        In: Nothing
        Out: A Node
        Effect: gets the Bchild of a node

    getParent:
        In: Nothing
        Out: A Node
        Effect: gets the Parent of a node

    setParent:
        In: A node
        out: Nothing
        Effect: Sets the Parent of a node to a given other node

    setSchild:
        In: A node
        out: Nothing
        Effect: Sets the Schild of a node to a given other node

    getNum:
        In: Nothing
        Out: A Node
        Effect: gets the int value of a node

    insert:
        In: An int 
        Out: Nothing
        Effect: Makes and inserts a node in the correct location in the Binary Tree

    findMin:
        In: Nothing
        Out: A BSTnode
        Effect: Finds the  the smallest value from called upon node to all following children

    changeChild:
        In: An int, A BSTnode
        Out: 
        Effect: Changes one of the child BSTnode refrences based on given value

    deleteNum:
        In: An int
        Out: Nothing
        Effect: Deletes a node of given value, without breaking the Tree

    scrub:
        In: Nothing
        Out: Nothing
        Effect: Deletes a BSTnode with no children

    splice:
        In: Nothing
        Out: Nothing
        Effect: Deletes a BSTnode with one child

    rotate:
        In: Nothing
        Out: Nothing
        Effect: Deletes a BSTnode with two children

    hasChild:
        In: Nothing
        Out: A Boolean
        Effect: Checks if a given node has a child

    successor:
        In: A BSTnode
        Out: A BSTnode
        Effect: Returns the successive node by value, if two of equal value, returns the higher one in the tree
