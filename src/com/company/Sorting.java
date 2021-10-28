package com.company;

import static com.company.EmployeeManagement.employees;
import static com.company.EmployeeManagement.printAllEmployees;
import static com.company.UI.showSortingMenu;
import static com.company.Utilities.*;

public class Sorting {

    public static void showSorting() {
        boolean runMenu = true;
        while (runMenu) {
            switch (showSortingMenu()) {
                case "1" -> sortByName();
                case "2" -> sortByAge();
                case "3" -> sortBySalary();
                case "4" -> sortByBonus();
                case "0" -> {
                    System.out.println(textRed + "\nÅtergår till huvudmeny." + textReset);
                    runMenu = false;
                }
                default -> System.out.println(textRed + "\nDu måste välja en siffra från 0 till 4." + textReset);
            }
        }
    }

    private static void sortByName() {
        if (ascendingOrDescending()) {
            //employees.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
            //employees.sort(new SortByNameAscending());
            System.out.println(textRed + "\nAnställda sorterade efter namn i bokstavsordning." + textReset);
            employees.stream()
                    .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                    .forEach(e -> System.out.println(e));
        } else {
            //employees.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
            //employees.sort(new SortByNameDescending());
            System.out.println(textRed + "\nAnställda sorterade efter namn i omvänd bokstavsordning." + textReset);
            employees.stream()
                    .sorted((e1, e2) -> e2.getName().compareTo(e1.getName()))
                    .forEach(e -> System.out.println(e));
        }
        //printAllEmployees();
    }

    private static void sortByAge() {
        if (ascendingOrDescending()) {
            /* employees.sort((o1, o2) -> {
                if (o1.getAge() == o2.getAge()) return o1.getName().compareTo(o2.getName());
                return o1.getAge() - o2.getAge();
            });*/
            //employees.sort(new SortByAgeAscending());
            System.out.println(textRed + "\nAnställda sorterade efter ålder i stigande ordning." + textReset);
            employees.stream()
                    .sorted((e1, e2) -> e1.getAge() - e2.getAge())
                    .forEach(e -> System.out.println(e));
        } else {
          /*  employees.sort((o1, o2) -> {
                if (o2.getAge() == o1.getAge()) return o2.getName().compareTo(o1.getName());
                return o2.getAge() - o1.getAge();
            });*/
            //employees.sort(new SortByAgeDescending());
            System.out.println(textRed + "\nAnställda sorterade efter ålder i fallande ordning." + textReset);
            employees.stream()
                    .sorted((e1, e2) -> e2.getAge() - e1.getAge())
                    .forEach(e -> System.out.println(e));
        }
        //printAllEmployees();
    }

    private static void sortBySalary() {
        if (ascendingOrDescending()) {
            /*employees.sort((o1, o2) -> {
                if (o1.getSalary() == o2.getSalary()) return o1.getName().compareTo(o2.getName());
                return o1.getSalary() - o2.getSalary();
            });*/
            //employees.sort(new SortBySalaryAscending());
            System.out.println(textRed + "\nAnställda sorterade efter lön i stigande ordning." + textReset);
            employees.stream()
                    .sorted((e1, e2) -> e1.getSalary() - e2.getSalary())
                    .forEach(e -> System.out.println(e));
        } else {
            /*employees.sort((o1, o2) -> {
                if (o2.getSalary() == o1.getSalary()) return o2.getName().compareTo(o1.getName());
                return o2.getSalary() - o1.getSalary();
            });*/
            //employees.sort(new SortBySalaryDescending());
            System.out.println(textRed + "\nAnställda sorterade efter lön i fallande ordning." + textReset);
            employees.stream()
                    .sorted((e1, e2) -> e2.getSalary() - e1.getSalary())
                    .forEach(e -> System.out.println(e));
        }
        //printAllEmployees();
    }

    private static void sortByBonus() {
        if (ascendingOrDescending()) {
            /*employees.sort((o1, o2) -> {
                if (o1.bonus() == o2.bonus()) return o1.getName().compareTo(o2.getName());
                return o1.bonus() - o2.bonus();
            });*/
            //employees.sort(new SortByBonusAscending());
            System.out.println(textRed + "\nAnställda sorterade efter bonus i stigande ordning." + textReset);
            employees.stream()
                    .sorted((e1, e2) -> e1.bonus() - e2.bonus())
                    .forEach(e -> System.out.println(e));
        } else {
            /*employees.sort((o1, o2) -> {
                if (o2.bonus() == o1.bonus()) return o2.getName().compareTo(o1.getName());
                return o2.bonus() - o1.bonus();
            });*/
            //employees.sort(new SortByBonusDescending());
            System.out.println(textRed + "\nAnställda sorterade efter bonus i fallande ordning." + textReset);
            employees.stream()
                    .sorted((e1, e2) -> e2.bonus() - e1.bonus())
                    .forEach(e -> System.out.println(e));
        }
        //printAllEmployees();
    }

    public static void sortByStaffNrAscending() {
        employees.sort(new SortByStaffNrAscending());
        System.out.println("\nAnställda sorterade efter anställningsnummer.");
    }

    private static boolean ascendingOrDescending() {
        while (true) {
            System.out.print("Vill du sortera i [S]tigande eller [F]allande ordning?: ");
            String userSelection = sc.nextLine();
            if (userSelection.equalsIgnoreCase("S"))
                return true;
            else if (userSelection.equalsIgnoreCase("F"))
                return false;
            else {
                System.out.println(textRed + "Du måste välja S eller F." + textReset);
            }
        }
    }

}
