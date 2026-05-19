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
public class BinaryTree {
    
    Node root;

    public void insert(Ca2algorithms emp) {
        Node newNode = new Node(emp);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left == null) {
                temp.left = newNode;
                return;
            } else queue.add(temp.left);

            if (temp.right == null) {
                temp.right = newNode;
                return;
            } else queue.add(temp.right);
        }
    }

    public void printLevelOrder() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.data);

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }

    public int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int getHeight() {
        return height(root);
    }

    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int getNodeCount() {
        return countNodes(root);
    }
}
