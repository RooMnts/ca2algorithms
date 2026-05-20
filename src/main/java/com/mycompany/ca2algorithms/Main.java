/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RooMnts
 */
public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Dummy data manual (20 empleados)
        List<Ca2algorithms> employees = new ArrayList<>();
        employees.add(new Ca2algorithms("Kate Summer", "Senior", "IT Development"));
        employees.add(new Ca2algorithms("Ken Winter", "Middle", "IT Development"));
        employees.add(new Ca2algorithms("James Anderson", "Manager", "Sales"));
        employees.add(new Ca2algorithms("Sarah Johnson", "Assistant Manager", "HR"));
        employees.add(new Ca2algorithms("John Smith", "Senior Manager", "Finance"));
        employees.add(new Ca2algorithms("Emily Brown", "Middle", "Marketing"));
        employees.add(new Ca2algorithms("Michael Williams", "Intern", "IT Development"));
        employees.add(new Ca2algorithms("Sophia Taylor", "Junior", "IT Development"));
        employees.add(new Ca2algorithms("David Wilson", "Senior", "IT Development"));
        employees.add(new Ca2algorithms("Olivia Martinez", "Contract", "Accounting"));
        employees.add(new Ca2algorithms("Ethan Anderson", "Senior", "Finance"));
        employees.add(new Ca2algorithms("Mia Clark", "Middle", "Operations"));
        employees.add(new Ca2algorithms("John Anderson", "Manager", "Sales"));
        employees.add(new Ca2algorithms("Sam Johnson", "Manager", "HR"));
        employees.add(new Ca2algorithms("John Brown", "Manager", "Finance"));
        employees.add(new Ca2algorithms("Emma Brown", "Junior", "Marketing"));
        employees.add(new Ca2algorithms("Max Williams", "Intern", "Technical Support"));
        employees.add(new Ca2algorithms("Sonya Taylor", "Junior", "Customer Service"));
        employees.add(new Ca2algorithms("Denis Wilson", "Manager", "IT Development"));
        employees.add(new Ca2algorithms("Olga Martinez", "Contract", "Accounting"));

        List<String> names = new ArrayList<>();
        for (Ca2algorithms e : employees) names.add(e.getName());

        BinaryTree tree = new BinaryTree();

        boolean running = true;

        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. SORT");
            System.out.println("2. SEARCH");
            System.out.println("3. ADD RECORD");
            System.out.println("4. CREATE TREE");
            System.out.println("5. EXIT");

            int choice = sc.nextInt();
            sc.nextLine();

            MenuOption option = MenuOption.values()[choice - 1];

            switch (option) {

                case SORT:
                    Sorting.mergeSort(names);
                    System.out.println("\nFirst 20 sorted names:");
                    for (int i = 0; i < 20 && i < names.size(); i++) {
                        System.out.println(names.get(i));
                    }
                    break;

                case SEARCH:
                    System.out.println("Enter name to search:");
                    String target = sc.nextLine();

                    Sorting.mergeSort(names);
                    int index = Searching.binarySearch(names, target, 0, names.size() - 1);

                    if (index == -1) {
                        System.out.println("Name not found.");
                    } else {
                        System.out.println("Found: " + names.get(index));
                    }
                    break;

                case ADD_RECORD:
                    System.out.println("Enter name:");
                    String name = sc.nextLine();

                    System.out.println("Enter manager type:");
                    String mt = sc.nextLine();

                    System.out.println("Enter department:");
                    String dep = sc.nextLine();

                    Ca2algorithms newEmp = new Ca2algorithms(name, mt, dep);
                    employees.add(newEmp);
                    names.add(newEmp.getName());

                    System.out.println("Record added successfully!");
                    break;

                case CREATE_TREE:
                    System.out.println("Building binary tree with 20 employees...");
                    for (Ca2algorithms e : employees) tree.insert(e);

                    System.out.println("\nLevel Order Traversal:");
                    tree.printLevelOrder();

                    System.out.println("\nTree Height: " + tree.getHeight());
                    System.out.println("Total Nodes: " + tree.getNodeCount());
                    break;

                case EXIT:
                    running = false;
                    break;
            }
        }
        sc.close();
    }    
}
