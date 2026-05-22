/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2algorithms;

import java.io.File;
import java.io.FileNotFoundException;
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
        
        List<String> names = new ArrayList<>();
    List<Ca2algorithms> employees = new ArrayList<>();

    try (Scanner fileScanner = new Scanner(new File("src/main/resources/Applicants_Form.txt"))) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (!line.isEmpty()) {
                names.add(line);
            }
        }
        System.out.println("File read successfully!");
    } catch (FileNotFoundException e) {
        System.out.println("Applicants_Form.txt not found!");
        return;
    }
    
    List<String> validManagers = List.of("Senior Manager", "Assistant Manager", "Manager", "Intern", "Junior", "Contract");
    List<String> validDepartments = List.of("IT Development", "HR", "Finance", "Marketing", "Accounting", "Operations", "Technical Support", "Customer Service", "Sales");

    
    for (String n : names) {
    String randomManager = validManagers.get((int)(Math.random() * validManagers.size()));
    String randomDepartment = validDepartments.get((int)(Math.random() * validDepartments.size()));

    Ca2algorithms emp = new Ca2algorithms(n, randomManager, randomDepartment);
    employees.add(emp);
       }

        BinaryTree tree = new BinaryTree();

        boolean running = true;

        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Sort");
            System.out.println("2. Search");
            System.out.println("3. Add Record");
            System.out.println("4. Create Tree");
            System.out.println("5. Exit");

            String input = sc.nextLine();

            if (!input.matches("[0-9]+")) {
            System.out.println("Please enter a number only.");
            continue;
            }

            int choice = Integer.parseInt(input);

            if (choice < 1 || choice > MenuOption.values().length) {
            System.out.println("Invalid option. Please try again.");
            continue;
            }
            
            MenuOption option = MenuOption.values()[choice - 1];

            switch (option) {

                case SORT ->{
                    Sorting.mergeSort(names);
                    System.out.println("\nFirst 20 sorted names:");
                    for (int i = 0; i < 20 && i < names.size(); i++) {
                        System.out.println(names.get(i));
                    }
                }

                case SEARCH -> {
                    System.out.println("Enter name to search:");
                    String target = sc.nextLine();

                    Sorting.mergeSort(names);
                    int index = Searching.binarySearch(names, target, 0, names.size() - 1);

                    if (index == -1) {
                        System.out.println("Name not found.");
                    } else {
                        System.out.println("Found: " + names.get(index));
                    }
                }

                case ADD_RECORD ->{
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    
                    if (!name.matches("[a-zA-Z ]+")) {
                    System.out.println("Invalid name. Only letters and spaces are allowed.");
                    break;
                        }

                    if (name.trim().isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    break;
                        }
                
                String mt = "";
                while (true) {
                    System.out.println("Select Manager Type:");
                    for (int i = 0; i < validManagers.size(); i++) {
                    System.out.println((i + 1) + ". " + validManagers.get(i));
                        }

                    String mtInput = sc.nextLine();

                    if (!mtInput.matches("[0-9]+")) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                        }

                    int mtIndex = Integer.parseInt(mtInput) - 1;

                    if (mtIndex < 0 || mtIndex >= validManagers.size()) {
                    System.out.println("Invalid option. Please select a valid manager type.");
                    continue;
                        }
                    
                    mt = validManagers.get(mtIndex);
                    break;
                }

                String dep = "";
                while (true) {
                    System.out.println("Select department:");
                    for (int i = 0; i < validDepartments.size(); i++) {
                    System.out.println((i + 1) + ". " + validDepartments.get(i));
                        }

                    String depInput = sc.nextLine();

                    if (!depInput.matches("[0-9]+")) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                        }

                    int depIndex = Integer.parseInt(depInput) - 1;

                    if (depIndex < 0 || depIndex >= validDepartments.size()) {
                    System.out.println("Invalid option. Please select a valid department.");
                    continue;
                        }
                    
                    dep = validDepartments.get(depIndex);
                        break;
                }
                    
                    Ca2algorithms newEmp = new Ca2algorithms(name, mt, dep);
                    employees.add(newEmp);
                    names.add(newEmp.getName());

                    System.out.println("Record added successfully!");
                }

                case CREATE_TREE ->{
                    System.out.println("Building binary tree with 20 employees...");
                    for (Ca2algorithms e : employees) tree.insert(e);

                    System.out.println("\nLevel Order Traversal:");
                    tree.printLevelOrder();

                    System.out.println("\nTree Height: " + tree.getHeight());
                    System.out.println("Total Nodes: " + tree.getNodeCount());
                }

                case EXIT ->{
                    running = false;
                }
            }
        }
        sc.close();
    }    
}
