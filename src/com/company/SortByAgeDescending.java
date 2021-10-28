package com.company;

import java.util.Comparator;

public class SortByAgeDescending implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o2.getAge() - o1.getAge() == 0) return o2.getName().compareTo(o1.getName());
        else return o2.getAge() - o1.getAge();
    }
}
