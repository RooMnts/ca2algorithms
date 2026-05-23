/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2algorithms;

/**
 *
 * @author RooMnts
 */
public class Node { // Represents a single node inside the binary tree
    
    Ca2algorithms data; // Stores the employee information inside this node
    Node left; // Reference to the left child node
    Node right; // Reference to the right child node

    public Node(Ca2algorithms data) { // Creates a new node containing an employee object
        this.data = data;
    }    
}
