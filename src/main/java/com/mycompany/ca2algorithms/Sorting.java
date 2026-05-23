/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2algorithms;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author RooMnts
 */
public class Sorting {
    
    public static void mergeSort(List<String> list) { // Performs merge sort on a list of strings
        if (list.size() <= 1) return; // Base case: a list with 0 or 1 elements is already sorted

        int mid = list.size() / 2; // Splits the list into two halves
        List<String> left = new ArrayList<>(list.subList(0, mid));
        List<String> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursively sorts both halves
        mergeSort(left);
        mergeSort(right);

        merge(list, left, right); // Merges the two sorted halves back into the original list
    }

    // Combines two sorted lists into one sorted list
    private static void merge(List<String> list, List<String> left, List<String> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) { // Compares elements from both lists and inserts the smallest one
            if (left.get(i).compareToIgnoreCase(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) list.set(k++, left.get(i++)); // Adds any remaining elements from the left list
        while (j < right.size()) list.set(k++, right.get(j++)); // Adds any remaining elements from the right list
    }
}
