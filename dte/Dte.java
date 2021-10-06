package dte;

import monthinfo.*;


public class Dte {

        private int year;
        private int month;
        private int day;
    
        //array of 12 MonthInfo objects
        private  MonthInfo [] monthData = {new MonthInfo(1, 31),
                                                 new MonthInfo(2, 28),
                                                 new MonthInfo(3, 31),
                                                 new MonthInfo(4, 30),
                                                 new MonthInfo(5, 31),
                                                 new MonthInfo(6, 30),
                                                 new MonthInfo(7, 31),
                                                 new MonthInfo(8, 31),
                                                 new MonthInfo(9, 30),
                                                 new MonthInfo(10, 31),
                                                 new MonthInfo(11, 30),
                                                 new MonthInfo(12, 31)};
    
    // no-arg constructor
    // creates a Dte with default values
    public Dte(){
        
        month = 0;
        day =  0;
        year = 0;
    
    }
    
    // three-arg constructor
    // builds a Dte with value month/day/year
    public Dte(int month, int day, int year){
    
        this.month = month;
        this.day = day;
        this.year =year;
    }
    
    // Dte constructor
    // builds a new Dte with the same value as its input
    public Dte(Dte a){
        month = a.month;
        day = a.day;
        year = a.year;
    }
    
    // getters
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    
    // setters
    public void setYear(int year){
        this.year = year;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setDay(int day){
        this.day = day;
    }
    
    
    
    // addDays
    // adds n days to the Dte it is called with
    public void addDays(int daysToAdd){
    
        if ( year % 4 == 0 && year %100==0 && year%400==0){
            monthData[1].setMonthday(29);
        }
    
        day+=daysToAdd;
    
        month--;
    
        int maxday = monthData[month].getMonthday();
    
        while(day>maxday){
            day-=maxday;
            month++;
            if (month > 11){
                year++;
                month = 0;
            }
    
            maxday=monthData[month].getMonthday();
        }
        month++;
    
        
    }
    
    // subtracts n days from the Dte it is called with
    public void subDays(int daysToSub){

        //every four year there is a leap year
        //if leap yea feb has 29 days
        if ((year % 4 == 0 && year%100==0 && year%400==0)){
    
    
            monthData[1].setMonthday(29);
    
        }
        boolean firsttimethrough = true;
        if(daysToSub < day){
            day-=daysToSub;
        }
        else{
    
        daysToSub-=day;
        while(daysToSub != 0){
            
            if (month == 0){
                year--;
                month = 11;
            }
            else{
                month--;
                if(firsttimethrough == true)
                //above accounts for zero based
                    if(month == 0){
                        month = 11;
                        year--;
                    }
                    else{
                        if(month == 12){
                            month = 10;
                        }
                        else
                            month--;
                    }
           
                     firsttimethrough = false;
            }
    
            int daysinmonth = monthData[month].getMonthday();
    
            if(month < 0){
                month = 11;
            }
            if (daysToSub < daysinmonth){
                daysinmonth-=daysToSub;
                day = daysinmonth;
                month++;
                daysToSub=0;
                }
            else {
                daysToSub-=daysinmonth;
                }
            }
        }

    }
    // addDays
    // adds n days to the Dte in the first argument
    public static Dte addDays(Dte d, int daysToAdd){
    
        d.getDay();
        d.getMonth();
        d.getYear();
    
        d.addDays(daysToAdd);
    
        return d;
    
    }
    // subDays
    // subtracts n days from the Dte in the first argument
    public static Dte subDays(Dte d, int daysToSub){
        d.getDay();
        d.getMonth();
        d.getYear();
    
        d.subDays(daysToSub);
            
        return d;
    }
    
    @Override
    public String toString(){
    
        String day1 = String.valueOf(day);
        String month1 = String.valueOf(month);
        String year1 = String.valueOf(year);
    
        return month1+ '/' + day1 + '/' + year1; 
    
    }
    
    }

