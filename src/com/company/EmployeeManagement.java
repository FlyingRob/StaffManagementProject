package com.company;

import java.util.ArrayList;

import static com.company.Utilities.*;

public class EmployeeManagement {

    static ArrayList<Employee> employees = new ArrayList<>();
    protected static int companyYearlyResult = 2500000;

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> employees) {
        EmployeeManagement.employees = employees;
    }

    public static void addEmployee() {
        employees.add(createEmployee());
    }

    private static Employee createEmployee() {
        System.out.print("\nNamn?: ");
        String name = sc.nextLine();
        System.out.print("Ålder?: ");
        int age = readInt();
        boolean isMale = isMale();
        switch (selectDepartment()) {
            case "E":
                return new FinanceAssistant(name, age, isMale);
            case "K":
                System.out.print("Antal år som anställd?: ");
                int yearOfService = readInt();
                return new CabinCrew(name, age, isMale,
                        yearOfService, isSupervisor("Kabinchef? J/N: "));
            case "P":
                System.out.print("Antal år som anställd?: ");
                int yearsOfService = readInt();
                return new FlightDeckCrew(name, age, isMale,
                        yearsOfService, isSupervisor("Kapten? J/N: "));
            case "M":
                System.out.print("Antal reparerade flygplan?: ");
                return new AircraftMechanic(name, age, isMale, readInt());
            default:
                return createEmployee();
        }
    }

    public static boolean isMale() {
        System.out.print("Kön? [K]vinnligt/[M]anligt: ");
        switch (checkUserSelection("K", "M")) {
            case "K":
                return false;
            case "M":
                return true;
        }
        return false;
    }

    public static boolean isSupervisor(String question) {
        System.out.print(question);
        switch (checkUserSelection("J", "N")) {
            case "J":
                return true;
            case "N":
                return false;
        }
        return false;
    }

    public static void updateEmployee() {
        System.out.print("\nAnge anställningsnummer på den anställd du vill uppdatera: ");
        int stfNr = readInt();
        boolean idFound = false;
        for (Employee e : employees) {
            if (e.getStaffNumber() == stfNr && e instanceof FinanceAssistant) {
                idFound = true;
                System.out.println("\n" + e);
                updateFinanceAssistant(stfNr);
                System.out.println("\n" + e);
            }
            if (e.getStaffNumber() == stfNr && e instanceof CabinCrew) {
                idFound = true;
                System.out.println("\n" + e);
                updateCabinCrew(stfNr);
                System.out.println("\n" + e);
            }
            if (e.getStaffNumber() == stfNr && e instanceof FlightDeckCrew) {
                idFound = true;
                System.out.println("\n" + e);
                updateFlightDeckCrew(stfNr);
                System.out.println("\n" + e);
            }
            if (e.getStaffNumber() == stfNr && e instanceof AircraftMechanic) {
                idFound = true;
                System.out.println("\n" + e);
                updateAircraftMechanic(stfNr);
                System.out.println("\n" + e);
            }
        }
        if (!idFound) {
            System.out.println(textRed + "\nIngen anställd med anställningsnummer " + stfNr +
                               " hittades i listan." + textReset);
        }
    }

    private static void updateFinanceAssistant(int staffNr) {
        System.out.print("\nVill du uppdatera [N]amn eller [Å]lder?: ");
        switch (checkUserSelection("N", "Å")) {
            case "N":
                updateEmployeeName(staffNr);
                break;
            case "Å":
                updateEmployeeAge(staffNr);
                break;
        }
    }

    private static void updateCabinCrew(int staffNr) {
        System.out.print("\nVill du uppdatera [N]amn, [Å]lder eller [K]abinposition?: ");
        switch (checkUserSelection("N", "Å", "K")) {
            case "N":
                updateEmployeeName(staffNr);
                break;
            case "Å":
                updateEmployeeAge(staffNr);
                break;
            case "K":
                updateCabinCrewPosition(staffNr);
                break;
        }
    }

    private static void updateFlightDeckCrew(int staffNr) {
        System.out.print("\nVill du uppdatera [N]amn, [Å]lder eller [B]esättningsposition?: ");
        switch (checkUserSelection("N", "Å", "B")) {
            case "N":
                updateEmployeeName(staffNr);
                break;
            case "Å":
                updateEmployeeAge(staffNr);
                break;
            case "B":
                updateFlightDeckCrewPosition(staffNr);
                break;
        }
    }

    private static void updateAircraftMechanic(int staffNr) {
        System.out.print("\nVill du uppdatera [N]amn, [Å]lder eller [A]ntal reparerade flygplan?: ");
        switch (checkUserSelection("N", "Å", "A")) {
            case "N":
                updateEmployeeName(staffNr);
                break;
            case "Å":
                updateEmployeeAge(staffNr);
                break;
            case "A":
                updateNrOfAircraftRepaired(staffNr);
                break;
        }
    }

    private static void updateEmployeeName(int staffNr) {
        System.out.print("Ange det nya namnet: ");
        for (Employee e : employees) {
            if (e.getStaffNumber() == staffNr) {
                e.setName(sc.nextLine());
            }
        }
    }

    private static void updateEmployeeAge(int staffNr) {
        System.out.print("Ange den nya åldern: ");
        for (Employee e : employees) {
            if (e.getStaffNumber() == staffNr) {
                e.setAge(readInt());
            }
        }
    }

    private static void updateCabinCrewPosition(int staffNr) {
        System.out.print("Kabinchef? [J]/[N]: ");
        for (Employee e : employees) {
            if (e.getStaffNumber() == staffNr) {
                switch (checkUserSelection("J", "N")) {
                    case "J":
                        ((CabinCrew) e).setIsCabinSupervisor(true);
                        break;
                    case "N":
                        ((CabinCrew) e).setIsCabinSupervisor(false);
                }
            }
        }
    }

    private static void updateFlightDeckCrewPosition(int staffNr) {
        System.out.print("Kapten? [J]/[N]: ");
        for (Employee e : employees) {
            if (e.getStaffNumber() == staffNr) {
                switch (checkUserSelection("J", "N")) {
                    case "J":
                        ((FlightDeckCrew) e).setIsCaptain(true);
                        break;
                    case "N":
                        ((FlightDeckCrew) e).setIsCaptain(false);
                }
            }
        }
    }

    private static void updateNrOfAircraftRepaired(int staffNr) {
        System.out.print("Ange det nya antalet reparerade flygplan: ");
        for (Employee e : employees) {
            if (e.getStaffNumber() == staffNr) {
                ((AircraftMechanic) e).setNumberOfAircraftRepaired(readInt());
            }
        }
    }

    public static void printAllEmployees() {
        System.out.println();
        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println(textYellow + "Totalt antal anställda: " + employees.size() + textReset);
        pause();
    }

    public static void printEmployeeByType() {
        int nrOfEmployees = 0;
        switch (selectDepartment()) {
            case "E":
                for (Employee e : employees) {
                    if (e instanceof FinanceAssistant) {
                        System.out.println(e);
                        nrOfEmployees++;
                    }
                }
                break;
            case "K":
                for (Employee e : employees) {
                    if (e instanceof CabinCrew) {
                        System.out.println(e);
                        nrOfEmployees++;
                    }
                }
                break;
            case "P":
                for (Employee e : employees) {
                    if (e instanceof FlightDeckCrew) {
                        System.out.println(e);
                        nrOfEmployees++;
                    }
                }
                break;
            case "M":
                for (Employee e : employees) {
                    if (e instanceof AircraftMechanic) {
                        System.out.println(e);
                        nrOfEmployees++;
                    }
                }
                break;
        }
        System.out.println(textYellow + "Totalt " + nrOfEmployees + " anställda i denna yrkeskategori." + textReset);
    }

    public static String selectDepartment() {
        System.out.print("""
                   [E]konomi
                   [F]lyg
                   [M]ekaniker
                Välj avdelning: """);
        switch (checkUserSelection("E", "F", "M")) {
            case "E":
                return "E";
            case "F":
                System.out.print("[K]abinpersonal eller [P]ilot?: ");
                return checkUserSelection("K", "P");
            case "M":
                return "M";
        }
        return "E";
    }

    public static void printEmployeeByNr() {
        System.out.print("Mata in anställningsnummret på den anställda du vill visa: ");
        int nr = readInt();
        boolean nameFound = false;
        for (Employee e : employees) {
            if (nr == e.getStaffNumber()) {
                System.out.println("\n" + e);
                nameFound = true;
            }
        }
        if (!nameFound) {
            System.out.println(textRed + "\nIngen anställd med anställningsnummer " + nr +
                               " finns i listan." + textReset);
        }
    }

    public static void searchForEmployee() {
        System.out.print("Mata in namnet på den anställda du vill söka efter: ");
        String name = sc.nextLine();
        boolean nameFound = false;
        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                System.out.println("\n" + e);
                nameFound = true;
            }
        }
        if (!nameFound) {
            System.out.println(textRed + "\nIngen anställd med namnet " + name + " finns i listan." + textReset);
        }
    }

    public static void deleteEmployee() {
        System.out.print("Ange anställningsnummer på den anställda du vill ta bort: ");
        int id = readInt();
        boolean idFound = false;
        for (int i = employees.size() - 1; i >= 0; i--) {
            if (employees.get(i).getStaffNumber() == id) {
                System.out.println("\n" + employees.get(i));
                System.out.print(textRed + "\nÄr du säker på att du vill radera denna anställd från listan? J/N: "
                                 + textReset);
                if (sc.nextLine().equalsIgnoreCase("J")) {
                    System.out.println("\nFöljande anställd raderas från listan: \n" + employees.get(i));
                    employees.remove(i);
                } else {
                    System.out.println("\nRadering ångrad. Återgår till meny.");
                }
                idFound = true;
            }
        }
        if (!idFound) {
            System.out.println(textRed + "\nIngen anställd med anställningsnummer " +
                               id + " hittades i listan." + textReset);
        }
    }

    public static void fixCounter() {
        if(employees.size() != 0)
        Employee.counter = employees.get(employees.size() - 1).getStaffNumber();
    }

}


