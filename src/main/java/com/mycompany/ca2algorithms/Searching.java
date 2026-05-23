/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2algorithms;

import java.util.List;

/**
 *
 * @author RooMnts
 */
public class Searching {
    
        // Performs a recursive binary search on a sorted list of strings
        public static int binarySearch(List<String> list, String target, int low, int high) {
        if (low > high) return -1; // Base case: the target is not found in the list

        int mid = (low + high) / 2; // Calculates the middle index of the current search range
        int compare = list.get(mid).compareToIgnoreCase(target); // Compares the middle element with the target (case-insensitive)

        if (compare == 0) return mid; // If the middle element matches the target, return its index
        if (compare > 0) return binarySearch(list, target, low, mid - 1); // If the target is smaller, search in the left half
        return binarySearch(list, target, mid + 1, high); // Otherwise, search in the right half
    }
    
}
