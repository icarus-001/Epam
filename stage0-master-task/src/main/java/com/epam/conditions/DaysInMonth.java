package com.epam.conditions;

import java.time.YearMonth;

public class DaysInMonth {

    public void printDays(int year, int month) {

        if(year <= 0 || month < 1 || month > 12) {
            System.out.println("invalid date");
            return;
        }
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        System.out.println(daysInMonth);

    }

}
