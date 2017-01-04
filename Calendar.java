package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Calendar {
    public final static String RED = "\u001B[31m";   //ANSI escape sequences
    public final static String BLUE = "\u001B[34m";  //responsible for coloring the text
    public final static String RESET = "\u001B[0m";  //this sequences might not work properly in some terminals

    private LocalDate today;             //date of current day
    private LocalDate firstDayOfMonth;

    Calendar(){
        today = LocalDate.now();
        firstDayOfMonth = today.withDayOfMonth(1);
    }

    Calendar(int monthNumber){
        if (monthNumber>12||monthNumber<1) throw new IllegalArgumentException();
        today = LocalDate.now();
        firstDayOfMonth = LocalDate.of(today.getYear(), monthNumber, 1);
    }

    public void show(){           //printing the grid
        System.out.println(firstDayOfMonth.getMonth() + "\nMON TUE WED THR FRI SAT SUN");
          //printing free spaces before the first day of specified month in grid
        for (int i = 1; i < firstDayOfMonth.getDayOfWeek().getValue(); i++) System.out.print("    ");
        LocalDate thisDay;
        for(int i = 1; i < firstDayOfMonth.lengthOfMonth(); i++){
            thisDay = firstDayOfMonth.withDayOfMonth(i);
            if(thisDay.equals(today)) System.out.print(BLUE+thisDay.getDayOfMonth() + "  " + RESET);
            else if(thisDay.getDayOfWeek() == DayOfWeek.SATURDAY || thisDay.getDayOfWeek() == DayOfWeek.SUNDAY)
                System.out.print(RED+thisDay.getDayOfMonth() + "  " + RESET);
            else System.out.print(thisDay.getDayOfMonth() + "  ");
              //printing additional space between daysOfMonth if current day of month is only one digit
            if (thisDay.getDayOfMonth() < 10) System.out.print(" ");
            if (thisDay.getDayOfWeek() == DayOfWeek.SUNDAY) System.out.print("\n");
        }
    }
}