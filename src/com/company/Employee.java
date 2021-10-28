package com.company;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    // Serializable för att flagga att ett objekt av klassen får skickas till fil eller över nätet
    public static int counter;
    private int staffNumber;
    private String name;
    private int age;
    private boolean isMale;
    private int salary;
    private final double basicBonus;

    abstract public int bonus();

    public Employee(String name, int age, boolean isMale) {
        this.staffNumber = ++counter;
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.salary = 0;
        this.basicBonus = 1000;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    public int getStaffNumber() {
        return staffNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getBasicBonus() {
        return basicBonus;
    }

    public static String adjustStringLength(int size, String string) {
        if (string.length() < size) {
            while (string.length() < size) {
                string += " ";
            }
        } else {
            string = string.substring(0, size - 1) + " ";
        }
        return string;
    }

    public String printGender() {
        if (isMale) {
            return "Man   ";
        } else {
            return "Kvinna";
        }
    }

}
