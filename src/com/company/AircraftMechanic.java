package com.company;

public class AircraftMechanic extends Employee {

    private int numberOfAircraftRepaired;

    public AircraftMechanic(String name, int age, boolean isMale, int numberOfAircraftRepaired) {
        super(name, age, isMale);
        setSalary(35700);
        this.numberOfAircraftRepaired = numberOfAircraftRepaired;
    }

    public int getNumberOfAircraftRepaired() {
        return numberOfAircraftRepaired;
    }

    public void setNumberOfAircraftRepaired(int numberOfAircraftRepaired) {
        this.numberOfAircraftRepaired = numberOfAircraftRepaired;
    }

    @Override
    public String toString() {
        return "Anstnr: " + adjustStringLength(4, String.valueOf(getStaffNumber())) +
                " Avdeln: Tekniska     Namn: " + adjustStringLength(18, getName()) +
                " Ålder: " + adjustStringLength(4, String.valueOf(getAge())) +
                " Kön: " + printGender() +
                " Lön- " + adjustStringLength(8, String.valueOf(getSalary()) + "kr") +
                " Bonus: " + adjustStringLength(10, String.valueOf(bonus()) + "kr") +
                " Reparerade flygplan: " + adjustStringLength(5, String.valueOf(numberOfAircraftRepaired));
    }

    @Override
    public int bonus() {
        return (int) (numberOfAircraftRepaired * getBasicBonus());
    }

}
