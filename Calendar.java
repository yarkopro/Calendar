package com.company;

import java.time.LocalDate;

public class Calendar {
    public final static String RED = "\u001B[31m";   //ANSI escape sequences
    public final static String BLUE = "\u001B[34m";  //responsible for coloring the text
    public final static String RESET = "\u001B[0m";  //this sequences might not work properly in some terminals

    private LocalDate firstDayOfMonth,   //date of first day of specified month
                      today;             //date of current day
    private int monthValue,              //specified month
                yearValue;               //current year

    Calendar(){
        monthValue = LocalDate.now().getMonthValue();
        yearValue = LocalDate.now().getYear();
        today = LocalDate.now();
        firstDayOfMonth = LocalDate.of(yearValue, monthValue, 1);
    }

    Calendar(int monthNumber){
        if (monthNumber>12||monthNumber<1) throw new IllegalArgumentException();
        monthValue = monthNumber;
        yearValue = LocalDate.now().getYear();
        today = LocalDate.now();
        firstDayOfMonth = LocalDate.of(yearValue, monthValue, 1);
    }

    public void show(){           //printing the grid
        System.out.println("MON TUE WED THR FRI SAT SUN");
        int dayOfWeek; //specify the day week in numeric
          //printing free spaces before the first day of specified month in grid
        for (int i = 1; i < firstDayOfMonth.getDayOfWeek().getValue(); i++) System.out.print("    ");
        for (int i = 1; i <= firstDayOfMonth.lengthOfMonth(); i++){
            dayOfWeek = (firstDayOfMonth.getDayOfWeek().getValue()+i-1)%7;
              //Verifying whether the date in calendar is equals to current date
            if (today.equals(LocalDate.of(yearValue, monthValue, i))) System.out.print(BLUE+i+"  "+RESET);
              //Verifying whether it is weekend
            else if (dayOfWeek==6||dayOfWeek==0) System.out.print(RED+i+"  "+RESET);
              //printing this day of the month
            else System.out.print(i+"  ");
              //printing more space in grid if the day of month has one digit
            if (i<10) System.out.print(" ");
              //printing new line at the week ending
            if (dayOfWeek==0) System.out.print("\n"+RESET);
        }
    }
}