/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author RooMnts
 */
public class BinaryTree { // Represents a binary tree structure used to store employee nodes
    
    Node root; // Root node of the tree

    public void insert(Ca2algorithms emp) { // Inserts a new employee into the tree using level-order insertion
        Node newNode = new Node(emp);

        if (root == null) { // If the tree is empty, the new node becomes the root
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>(); // Queue used to traverse the tree level by level
        queue.add(root);

        while (!queue.isEmpty()) { // Finds the first available position (left or right)
            Node temp = queue.poll();

            if (temp.left == null) { // Insert on the left if empty
                temp.left = newNode;
                return;
            } else queue.add(temp.left);

            if (temp.right == null) { // Insert on the right if empty
                temp.right = newNode;
                return;
            } else queue.add(temp.right);
        }
    }

    public void printLevelOrder() { // Prints the tree in level-order (breadth-first traversal)
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) { // Visits each node and prints its data
            Node temp = queue.poll();
            System.out.println(temp.data);

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }

    public int height(Node node) { // Recursively calculates the height of the tree
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right)); // Height = 1 + the tallest subtree
    }

    public int getHeight() { // Returns the height of the entire tree
        return height(root);
    }

    public int countNodes(Node node) { // Recursively counts all nodes in the tree
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right); // Count = 1 (current node) + left subtree + right subtree
    }

    public int getNodeCount() { // Returns the total number of nodes in the tree
        return countNodes(root);
    }
}
