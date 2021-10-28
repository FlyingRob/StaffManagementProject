package com.company;

public class CabinCrew extends FlightCrew {

    private int basicSalary = 28500;
    private boolean isCabinSupervisor;

    public CabinCrew(String name, int age, boolean isMale, int yearsOfService, boolean isCabinSupervisor) {
        super(name, age, isMale, yearsOfService);
        this.isCabinSupervisor = isCabinSupervisor;
        setSalary(calculateSalary(basicSalary));
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public boolean getIsCabinSupervisor() {
        return isCabinSupervisor;
    }

    public void setIsCabinSupervisor(boolean cabinSupervisor) {
        isCabinSupervisor = cabinSupervisor;
        setSalary(calculateSalary(basicSalary));
    }

    @Override
    public String toString() {
        return "Anstnr: " + adjustStringLength(4, String.valueOf(getStaffNumber())) +
               " Avdeln: Kabin        Namn: " + adjustStringLength(18, getName()) +
               " Ålder: " + adjustStringLength(4, String.valueOf(getAge())) +
               " Kön: " + printGender() +
               " Lön- " + adjustStringLength(8, String.valueOf(getSalary()) + "kr") +
               " Bonus: " + adjustStringLength(10, String.valueOf(bonus()) + "kr") +
               " Kabinchef: " + printIsCabinSupervisor();
    }

    private String printIsCabinSupervisor() {
        if (isCabinSupervisor) {
            return "Ja";
        } else {
            return "Nej";
        }
    }

    private int calculateSalary(int basicSalary) {
        if (isCabinSupervisor) {
            return (int) (basicSalary * 1.3);
        } else {
            return basicSalary;
        }
    }

}
