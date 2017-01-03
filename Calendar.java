package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Calendar {
    public final static String RED = "\u001B[31m";   //ANSI escape sequences
    public final static String BLUE = "\u001B[34m";  //responsible for coloring the text
    public final static String RESET = "\u001B[0m";  //this sequences might not work properly in some terminals

    private LocalDate today;             //date of current day
    private ArrayList<LocalDate> days;

    Calendar(){
        today = LocalDate.now();
        days = new ArrayList<>();
        for(int i = 1; i <= this.today.lengthOfMonth(); i++) this.days.add(today.withDayOfMonth(i));
    }

    Calendar(int monthNumber){
        if (monthNumber>12||monthNumber<1) throw new IllegalArgumentException();
        today = LocalDate.now();
        days = new ArrayList<>();
        for(int i = 1; i <= LocalDate.of(today.getYear(), monthNumber, 1).lengthOfMonth(); i++)
            this.days.add(LocalDate.of(today.getYear(), monthNumber, i));
    }

    public void show(){           //printing the grid
        System.out.println("MON TUE WED THR FRI SAT SUN");
          //printing free spaces before the first day of specified month in grid
        for (int i = 1; i < days.get(0).getDayOfWeek().getValue(); i++) System.out.print("    ");
          //
        for(LocalDate x:days){
            if(x.equals(today)) System.out.print(BLUE+x.getDayOfMonth()+"  "+RESET);
            else if(x.getDayOfWeek() == DayOfWeek.SATURDAY || x.getDayOfWeek() == DayOfWeek.SUNDAY)
                System.out.print(RED+x.getDayOfMonth() + "  " + RESET);
            else System.out.print(x.getDayOfMonth() + "  ");
              //printing additional space between days if current day of month is only one digit
            if (x.getDayOfMonth() < 10) System.out.print(" ");
            if (x.getDayOfWeek() == DayOfWeek.SUNDAY) System.out.print("\n");
        }
    }
}