package com.company;

import java.util.Comparator;

public class SortByStaffNrAscending implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getStaffNumber() - o2.getStaffNumber();
    }
}
