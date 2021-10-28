package com.company;

import static com.company.EmployeeManagement.*;

public class FinanceAssistant extends Employee {

    public FinanceAssistant(String name, int age, boolean isMale) {
        super(name, age, isMale);
        setSalary(30000);
    }

    @Override
    public String toString() {
        return "Anstnr: " + adjustStringLength(4, String.valueOf(getStaffNumber())) +
                " Avdeln: Ekonomi      Namn: " + adjustStringLength(18, getName()) +
                " Ålder: " + adjustStringLength(4, String.valueOf(getAge())) +
                " Kön: " + printGender() +
                " Lön- " + adjustStringLength(8, String.valueOf(getSalary()) + "kr") +
                " Bonus: " + adjustStringLength(10, String.valueOf(bonus()) + "kr");
    }

    @Override
    public int bonus() {
        if (companyYearlyResult > 0){
            return (int) (companyYearlyResult / 1000000.0 * getBasicBonus());
        }else {
            return 0;
        }
    }

}
