package com.example.employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private static final List<Employee> employeeList = new ArrayList();

    private EmployeeList(){
    }

    static{
        employeeList.add(new Employee("Rodrigo","Pires","12-12-1980","Tech manager","Desenvolvimento","rodrigo.pires@abc.com"));

    }

    public static List<Employee> getInstance(){
        return employeeList;
    }
}
