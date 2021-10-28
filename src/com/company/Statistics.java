package com.company;

import java.util.IntSummaryStatistics;
import java.util.OptionalInt;

import static com.company.EmployeeManagement.*;
import static com.company.UI.*;
import static com.company.Utilities.*;

public class Statistics {

    public static void showStatistics() {
        boolean runMenu = true;
        while (runMenu) {
            switch (showStatisticsMenu()) {
                case "1" -> showGenderStatistics();
                case "2" -> showBonusStatistics();
                case "3" -> showSalaryStatistics();
                case "0" -> {
                    System.out.println(textRed + "\nÅtergår till huvudmeny." + textReset);
                    runMenu = false;
                }
                default -> System.out.println(textRed + "\nDu måste välja en siffra från 0 till 3." + textReset);
            }
        }
    }

    private static void showGenderStatistics() {
        double male = 0;
        for (Employee e : employees) {
            if (e.getIsMale()) {
                male++;
            }
        }
        System.out.printf(textYellow + "\nAv företagets " + employees.size() +
                          " anställda är %.1f%% män och %.1f%% kvinnor.\n" +
                          textReset, male / employees.size() * 100, (100 - (male / employees.size() * 100)));
//        System.out.print(textYellow + "\nAv företagets " + employees.size() + " anställda är ");
//        System.out.format("%.1f", male / employees.size() * 100);
//        System.out.print("% män och ");
//        System.out.format("%.1f", (100 - (male / employees.size() * 100)));
//        System.out.println("% kvinnor." + textReset);
    }

/*    private static void showBonusStatistics() {
        IntSummaryStatistics bonusStatistics = employees.stream()
                .map(e -> e.bonus())
                .mapToInt(e -> e)
                .summaryStatistics();
       *//* int bonusMax = employees.stream()
                //.map(e -> e.bonus())
                .mapToInt(e -> e.bonus())
                .max();*//*
        int nrOfFinanceAssistants = 0, nrOfCabinCrew = 0, nrOfFlightDeckCrew = 0, nrOfMechanics = 0;
        int totBonus = 0, totBonusFA = 0, totBonusCC = 0, totalBonusFD = 0, totBonusME = 0;
        int bonusMax = 0;
        int bonusMin = employees.get(0).bonus();
        for (Employee e : employees) {
            totBonus += e.bonus();
            if (e.bonus() > bonusMax) {
                bonusMax = e.bonus();
            } else if (e.bonus() < bonusMin) {
                bonusMin = e.bonus();
            }
            if (e instanceof FinanceAssistant) {
                nrOfFinanceAssistants++;
                totBonusFA += e.bonus();
            }
            if (e instanceof CabinCrew) {
                nrOfCabinCrew++;
                totBonusCC += e.bonus();
            }
            if (e instanceof FlightDeckCrew) {
                nrOfFlightDeckCrew++;
                totalBonusFD += e.bonus();
            }
            if (e instanceof AircraftMechanic) {
                nrOfMechanics++;
                totBonusME += e.bonus();
            }
        }
        if (nrOfFinanceAssistants == 0) nrOfFinanceAssistants++;
        if (nrOfCabinCrew == 0) nrOfCabinCrew++;
        if (nrOfFlightDeckCrew == 0) nrOfFlightDeckCrew++;
        if (nrOfMechanics == 0) nrOfMechanics++;
        System.out.print(textPurple + "\n-----------STATISTIK BONUS-------------" +
                         "\n  Högsta bonusen:       " + bonusMax + " kr." +
                         "\n  Lägsta bonusen:       " + bonusMin + " kr." +
                         "\n  Total bonuskostnad:   " + totBonus + " kr." +
                         "\n  Medelbonus alla:      " + totBonus / employees.size() + " kr." +
                         "\n  Medelbonus ekonomi:   " + totBonusFA / nrOfFinanceAssistants + " kr." +
                         "\n  Medelbonus kabin:     " + totBonusCC / nrOfCabinCrew + " kr." +
                         "\n  Medelbonus pilot:     " + totalBonusFD / nrOfFlightDeckCrew + " kr." +
                         "\n  Medelbonus mekaniker: " + totBonusME / nrOfMechanics + " kr." +
                         "\n---------------------------------------\n" + textReset);
        pause();
    }*/

/*
    private static void showSalaryStatistics() {
        int nrOfFinanceAssistants = 0, nrOfCabinCrew = 0, nrOfFlightDeckCrew = 0, nrOfMechanics = 0;
        int totSalary = 0, totSalaryFA = 0, totSalaryCC = 0, totalSalaryFD = 0, totSalaryME = 0;
        int salaryMax = 0;
        int salaryMin = employees.get(0).getSalary();
        for (Employee e : employees) {
            totSalary += e.getSalary();
            if (e.getSalary() > salaryMax) {
                salaryMax = e.getSalary();
            } else if (e.getSalary() < salaryMin) {
                salaryMin = e.getSalary();
            }
            if (e instanceof FinanceAssistant) {
                nrOfFinanceAssistants++;
                totSalaryFA += e.getSalary();
            }
            if (e instanceof CabinCrew) {
                nrOfCabinCrew++;
                totSalaryCC += e.getSalary();
            }
            if (e instanceof FlightDeckCrew) {
                nrOfFlightDeckCrew++;
                totalSalaryFD += e.getSalary();
            }
            if (e instanceof AircraftMechanic) {
                nrOfMechanics++;
                totSalaryME += e.getSalary();
            }
        }
        if (nrOfFinanceAssistants == 0) nrOfFinanceAssistants++;
        if (nrOfCabinCrew == 0) nrOfCabinCrew++;
        if (nrOfFlightDeckCrew == 0) nrOfFlightDeckCrew++;
        if (nrOfMechanics == 0) nrOfMechanics++;
        System.out.print(textBlue + "\n-------------STATISTIK LÖN--------------" +
                         "\n  Högsta lönen:       " + salaryMax + " kr/mån." +
                         "\n  Lägsta lönen:       " + salaryMin + " kr/mån." +
                         "\n  Total lönekostnad:  " + totSalary + " kr/mån." +
                         "\n  Medellön alla:      " + totSalary / employees.size() + " kr/mån." +
                         "\n  Medellön ekonomi:   " + totSalaryFA / nrOfFinanceAssistants + " kr/mån." +
                         "\n  Medellön kabin:     " + totSalaryCC / nrOfCabinCrew + " kr/mån." +
                         "\n  Medellön pilot:     " + totalSalaryFD / nrOfFlightDeckCrew + " kr/mån." +
                         "\n  Medellön mekaniker: " + totSalaryME / nrOfMechanics + " kr/mån." +
                         "\n----------------------------------------\n" + textReset);
        pause();
    }
*/

    private static void showBonusStatistics() {
        IntSummaryStatistics bonusStatisticsAll = employees.stream()
                .mapToInt(e -> e.bonus())
                .summaryStatistics();
        IntSummaryStatistics bonusStatisticsFA = employees.stream()
                .filter(e -> e instanceof FinanceAssistant)
                .mapToInt(e -> e.bonus())
                .summaryStatistics();
        IntSummaryStatistics bonusStatisticsCC = employees.stream()
                .filter(e -> e instanceof CabinCrew)
                .mapToInt(e -> e.bonus())
                .summaryStatistics();
        IntSummaryStatistics bonusStatisticsFD = employees.stream()
                .filter(e -> e instanceof FlightDeckCrew)
                .mapToInt(e -> e.bonus())
                .summaryStatistics();
        IntSummaryStatistics bonusStatisticsME = employees.stream()
                .filter(e -> e instanceof AircraftMechanic)
                .mapToInt(e -> e.bonus())
                .summaryStatistics();
        System.out.print(textPurple + "\n---------------STATISTIK BONUS----------------" +
                         "\n  Högsta bonusen:        " + bonusStatisticsAll.getMax() + " kr." +
                         "\n  Lägsta bonusen:        " + bonusStatisticsAll.getMin() + " kr." +
                         "\n  Total bonuskostnad:    " + bonusStatisticsAll.getSum() + " kr." +
                         "\n  Medelbonus alla:       " + (int) bonusStatisticsAll.getAverage() + " kr. (" +
                         bonusStatisticsAll.getCount() + " st.)" +
                         "\n  Medelbonus ekonomi:    " + (int) bonusStatisticsFA.getAverage() + " kr. (" +
                         bonusStatisticsFA.getCount() + " st.)" +
                         "\n  Total bonus ekonomi:   " + bonusStatisticsFA.getSum() + " kr." +
                         "\n  Medelbonus kabin:      " + (int) bonusStatisticsCC.getAverage() + " kr. (" +
                         bonusStatisticsCC.getCount() + " st.)" +
                         "\n  Total bonus kabin:     " + bonusStatisticsCC.getSum() + " kr." +
                         "\n  Medelbonus pilot:      " + (int) bonusStatisticsFD.getAverage() + " kr. (" +
                         bonusStatisticsFD.getCount() + " st.)" +
                         "\n  Total bonus pilot:     " + bonusStatisticsFD.getSum() + " kr." +
                         "\n  Medelbonus mekaniker:  " + (int) bonusStatisticsME.getAverage() + " kr. (" +
                         bonusStatisticsME.getCount() + " st.)" +
                         "\n  Total bonus mekaniker: " + bonusStatisticsME.getSum() + " kr." +
                         "\n-----------------------------------------------\n" + textReset);
        pause();
    }

    private static void showSalaryStatistics() {
        IntSummaryStatistics salaryStatisticsAll = employees.stream()
                .mapToInt(e -> e.getSalary())
                .summaryStatistics();
        IntSummaryStatistics salaryStatisticsFA = employees.stream()
                .filter(e -> e instanceof FinanceAssistant)
                .mapToInt(e -> e.getSalary())
                .summaryStatistics();
        IntSummaryStatistics salaryStatisticsCC = employees.stream()
                .filter(e -> e instanceof CabinCrew)
                .mapToInt(e -> e.getSalary())
                .summaryStatistics();
        IntSummaryStatistics salaryStatisticsFD = employees.stream()
                .filter(e -> e instanceof FlightDeckCrew)
                .mapToInt(e -> e.getSalary())
                .summaryStatistics();
        IntSummaryStatistics salaryStatisticsME = employees.stream()
                .filter(e -> e instanceof AircraftMechanic)
                .mapToInt(e -> e.getSalary())
                .summaryStatistics();
        System.out.print(textBlue + "\n--------------STATISTIK LÖN---------------" +
                         "\n  Högsta lönen:        " + salaryStatisticsAll.getMax() + " kr/mån." +
                         "\n  Lägsta lönen:        " + salaryStatisticsAll.getMin() + " kr/mån." +
                         "\n  Total lönekostnad:   " + salaryStatisticsAll.getSum() + " kr/mån." +
                         "\n  Medellön alla:       " + (int) salaryStatisticsAll.getAverage() + " kr/mån. (" +
                         salaryStatisticsAll.getCount() + "st.)" +
                         "\n  Medellön ekonomi:    " + (int) salaryStatisticsFA.getAverage() + " kr/mån. (" +
                         salaryStatisticsFA.getCount() + "st.)" +
                         "\n  Total lön ekonomi:   " + salaryStatisticsFA.getSum() +
                         "\n  Medellön kabin:      " + (int) salaryStatisticsCC.getAverage() + " kr/mån. (" +
                         salaryStatisticsCC.getCount() + "st.)" +
                         "\n  Total lön kabin:     " + salaryStatisticsCC.getSum() +
                         "\n  Medellön pilot:      " + (int) salaryStatisticsFD.getAverage() + " kr/mån. (" +
                         salaryStatisticsFD.getCount() + "st.)" +
                         "\n  Total lön pilot:     " + salaryStatisticsFD.getSum() +
                         "\n  Medellön mekaniker:  " + (int) salaryStatisticsME.getAverage() + " kr/mån. (" +
                         salaryStatisticsME.getCount() + "st.)" +
                         "\n  Total lön mekaniker: " + salaryStatisticsME.getSum() +
                         "\n------------------------------------------\n" + textReset);
        pause();
    }

}
