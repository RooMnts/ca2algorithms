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
    
        public static int binarySearch(List<String> list, String target, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        int compare = list.get(mid).compareToIgnoreCase(target);

        if (compare == 0) return mid;
        if (compare > 0) return binarySearch(list, target, low, mid - 1);
        return binarySearch(list, target, mid + 1, high);
    }
    
}
