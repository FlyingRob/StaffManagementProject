package com.company;

import java.io.EOFException;
import java.io.IOException;

import static com.company.IO.*;
import static com.company.Sorting.*;
import static com.company.Statistics.showStatistics;
import static com.company.UI.*;
import static com.company.EmployeeManagement.*;
import static com.company.Utilities.*;

public class AirlineMain {

    public static void main(String[] args) {

        readFromFile();

        System.out.print("\nVill du autogenerera några anställda? J/N: ");
        if (sc.nextLine().equalsIgnoreCase("J")) {
            employees.add(new FinanceAssistant("John Doe", 30, true));
            employees.add(new AircraftMechanic("Ben Strong", 47, true, 14));
            employees.add(new FinanceAssistant("Jane Doe", 34, false));
            employees.add(new AircraftMechanic("Stina Strong", 45, false, 17));
            employees.add(new FlightDeckCrew("Stina Stark", 36, false, 9, true));
            employees.add(new FlightDeckCrew("Sture Svag", 25, true, 2, false));
            employees.add(new CabinCrew("Janne Lång", 51, true, 12, true));
            employees.add(new CabinCrew("Karina Kort", 22, false, 3, false));
        }

        System.out.println(textYellow + "\nVälkommen till Flygbolagets personalhanteringssystem.");
        boolean runMenu = true;
        while (runMenu) {
            switch (showMainMenu()) {
                case "1" -> addEmployee();
                case "2" -> updateEmployee();
                case "3" -> {
                    //sortByStaffNrAscending();
                    printAllEmployees();
                }
                case "4" -> printEmployeeByType();
                case "5" -> printEmployeeByNr();
                case "6" -> searchForEmployee();
                case "7" -> deleteEmployee();
                case "8" -> showStatistics();
                case "9" -> showSorting();
                case "0" -> {
                    writeToFile();
                    System.out.println(textRed + "\nProgrammet avslutas.");
                    runMenu = false;
                }
                default -> System.out.println(textRed + "\nDu måste välja en siffra från 0 till 9." + textReset);
            }
        }
    }

}

