package com.company;

import java.util.Comparator;

public class SortByBonusDescending implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o2.bonus() - o1.bonus() == 0) return o2.getName().compareTo(o1.getName());
        else return o2.bonus() - o1.bonus();
    }
}
