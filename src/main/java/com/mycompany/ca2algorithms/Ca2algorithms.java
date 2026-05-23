/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ca2algorithms;

/**
 *
 * @author RooMnts 
 */
    public class Ca2algorithms {

        private String name; // Stores the employee name
        private String managerType; // Stores the type of manager assigned to the employee
        private String department; // Stores the department where the employee works

        // Constructor: creates a new employee with name, manager type and department
        public Ca2algorithms(String name, String managerType, String department) {
            this.name = name;
            this.managerType = managerType;
            this.department = department;
        }

        public String getName() { // Returns the employee name
            return name;
        }

        public String getManagerType() { // Returns the manager type assigned to the employee
            return managerType;
        }

        public String getDepartment() { // Returns the employee department
            return department;
        }

        @Override
        public String toString() { // Converts the employee information into a readable string format
              return name + " | " + managerType + " | " + department;
        }
    }
