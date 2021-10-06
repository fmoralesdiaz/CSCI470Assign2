package monthinfo;

public class MonthInfo {
    
   
    private int monthnum;
    private int monthday;

    public MonthInfo( int monthnum , int monthday ){

        this.monthnum = monthnum;
        this.monthday = monthday;
        // this.fullyear = fullyear;
    }

    public int getMonthnum(){
        return monthnum;
    }
    public int getMonthday(){
        return monthday;
    }
    // public int getFullyear(){
    //     return fullyear;
    // }
    public void setMonthnum(int monthnum){
        this.monthnum = monthnum;
    }
    public void setMonthday(int monthday){
        this.monthday = monthday;
    }
    // public void setFullyear(int fullyear){
    //     this.fullyear = fullyear;
    // }
    

}


