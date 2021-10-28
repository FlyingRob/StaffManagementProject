package com.company;

public class FlightCrew extends Employee {

    private int yearsOfService;

    public FlightCrew(String name, int age, boolean isMale, int yearsOfService) {
        super(name, age, isMale);
        this.yearsOfService = yearsOfService;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    @Override
    public int bonus() {
        return (int) (yearsOfService * getBasicBonus());
    }

}
