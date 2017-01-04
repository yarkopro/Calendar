package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Calendar {
    public final static String RED = "\u001B[31m";   //ANSI escape sequences
    public final static String BLUE = "\u001B[34m";  //responsible for coloring the text
    public final static String RESET = "\u001B[0m";  //this sequences might not work properly in some terminals

    private LocalDate today;             //date of current day
    private ArrayList<LocalDate> daysOfMonth;

    Calendar(){
        today = LocalDate.now();
        daysOfMonth = new ArrayList<>();
        for(int i = 1; i <= this.today.lengthOfMonth(); i++) daysOfMonth.add(today.withDayOfMonth(i));
    }

    Calendar(int monthNumber){
        if (monthNumber>12||monthNumber<1) throw new IllegalArgumentException();
        today = LocalDate.now();
        daysOfMonth = new ArrayList<>();
        daysOfMonth.add(LocalDate.of(today.getYear(), monthNumber, 1));
        for(int i = 2; i <= daysOfMonth.get(0).lengthOfMonth(); i++)
            this.daysOfMonth.add(daysOfMonth.get(0).withDayOfMonth(i));
    }

    public void show(){           //printing the grid
        System.out.println(daysOfMonth.get(0).getMonth() + "\nMON TUE WED THR FRI SAT SUN");
          //printing free spaces before the first day of specified month in grid
        for (int i = 1; i < daysOfMonth.get(0).getDayOfWeek().getValue(); i++) System.out.print("    ");
        for(LocalDate x : daysOfMonth){
            if(x.equals(today)) System.out.print(BLUE+x.getDayOfMonth() + "  " + RESET);
            else if(x.getDayOfWeek() == DayOfWeek.SATURDAY || x.getDayOfWeek() == DayOfWeek.SUNDAY)
                System.out.print(RED+x.getDayOfMonth() + "  " + RESET);
            else System.out.print(x.getDayOfMonth() + "  ");
              //printing additional space between daysOfMonth if current day of month is only one digit
            if (x.getDayOfMonth() < 10) System.out.print(" ");
            if (x.getDayOfWeek() == DayOfWeek.SUNDAY) System.out.print("\n");
        }
    }
}