package com.company;

import org.junit.jupiter.api.Test;

import static com.company.Employee.adjustStringLength;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void adjustStringLengtShort() {
        String text = adjustStringLength(5,"x");
        assertEquals(5,text.length());
    }

    @Test
    void adjustStringLengtLong() {
        String text = adjustStringLength(5,"XXXXXX");
        assertEquals(5,text.length());
    }

}