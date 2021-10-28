package com.company;

public class FlightDeckCrew extends FlightCrew {

    private int basicSalary = 38500;
    private boolean isCaptain;

    public FlightDeckCrew(String name, int age, boolean isMale, int yearsOfService, boolean isCaptain) {
        super(name, age, isMale, yearsOfService);
        this.isCaptain = isCaptain;
        setSalary(calculateSalary(basicSalary));
    }

    public boolean getIsCaptain() {
        return isCaptain;
    }

    public void setIsCaptain(boolean captain) {
        isCaptain = captain;
        setSalary(calculateSalary(basicSalary));    }

    @Override
    public String toString() {
        return "Anstnr: " + adjustStringLength(4, String.valueOf(getStaffNumber())) +
                " Avdeln: Flight Deck  Namn: " + adjustStringLength(18, getName()) +
                " Ålder: " + adjustStringLength(4, String.valueOf(getAge())) +
                " Kön: " + printGender() +
                " Lön- " + adjustStringLength(8, String.valueOf(getSalary()) + "kr") +
                " Bonus: " + adjustStringLength(10, String.valueOf(bonus()) + "kr") +
                " Kapten:    " + printIsCaptain();
    }

    private String printIsCaptain() {
        if(isCaptain){
            return "Ja";
        }else {
            return "Nej";
        }
    }

    private int calculateSalary(int basicSalary){
        if(isCaptain){
            return (int) (basicSalary * 1.5);
        }
        else {
            return basicSalary;
        }
    }

}
