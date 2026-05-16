/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ca2algorithms;

/**
 *
 * @author RooMnts 
 */
public class Ca2algorithms {

    private String name;
    private String managerType;
    private String department;

    public Ca2algorithms(String name, String managerType, String department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getManagerType() {
        return managerType;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " | " + managerType + " | " + department;
    }
}
