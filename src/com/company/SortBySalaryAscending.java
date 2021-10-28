package com.company;

import java.util.Comparator;

public class SortBySalaryAscending implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getSalary() - o2.getSalary()==0)return o1.getName().compareTo(o2.getName());
        else return o1.getSalary() - o2.getSalary();
    }
}
