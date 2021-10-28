package com.company;

import java.util.Comparator;

public class SortBySalaryDescending implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o2.getSalary() - o1.getSalary() == 0) return o2.getName().compareTo(o1.getName());
        else return o2.getSalary() - o1.getSalary();
    }
}
