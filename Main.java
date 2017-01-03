package com.company;

public class Main {
    public static void main(String[] args) {
        try {
            Calendar calendar;
            if (args.length>1) calendar = new Calendar(Integer.parseInt(args[1]));
            else calendar = new Calendar();
            calendar.show();
        } catch(IllegalArgumentException e){
            System.err.println("Incorrect month value.");
        } catch (Exception e){
            System.err.println("Some error occurred.");
            e.printStackTrace();
        }
    }
}
