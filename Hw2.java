import java.io.*;
import java.util.regex.Matcher;

import java.util.regex.Pattern;


import dte.*;




public class Hw2 {
    
private static BufferedReader buffer;
    public static void main(String[] args) throws IOException {

        Dte date= new Dte(3,5,2011);
        Dte test = new Dte(12,30,1899);

        Dte date1 = new Dte(date);
        Dte memtest = new Dte(date);
        Dte memtest2 = new Dte(date);
        Dte date2= new Dte(3,5,2014);

        Dte date3 = new Dte(date2);

        //member functions
        test.addDays(365);
        date1.addDays(100);
        date3.subDays(30);

        //non member functions
        Dte.addDays(memtest, 100);
        Dte.subDays(memtest2, 100);



        System.out.print(test);
        System.out.println("\nstatic add: "+date+" + 100 = " +date1);
        System.out.println("static sub: "+date2+" -  30 = "+date3);
        System.out.println("\nmember add: "+date+" + 100 = "+memtest);
        System.out.println("member sub: "+date+" - 100 = "+memtest2);
        System.out.print("\n--------------------\n");
        
    String file;
    String inputLine ="";
    int recordcount=0; 

    String dateregex = "^\\s*(\\d{1,2})\\/(\\d{1,2})\\/(\\d{4})\\s+(\\d{1,3})";
    String slashesregex = "(\\d{1,2}\\/)";
    String incrementregex = "^(\\d{1,2})\\/(\\d{1,2})\\/(\\d{4})$";
    String notnumeric = "^(\\d{1,2}\\/(\\D))";
    String incrementnotnumeric = "^(\\d{1,2})\\/(\\d{1,2})\\/(\\d{4})\\s+(\\D{1,3})$";
    String monthnotnumeric = "^\\D{1,2}";
    String empty= "\\s*";
    String notinrange = "^(\\d{1,2})";

    int month1=0;
    int day1=0;
    int year1=0;
    int daystoadd=0;

    Pattern pattern = Pattern.compile(dateregex);
    Pattern monthpattern = Pattern.compile(slashesregex);
    Pattern incrementpattern = Pattern.compile(incrementregex);
    Pattern numericpatter = Pattern.compile(notnumeric);
    Pattern incrementnumeic = Pattern.compile(incrementnotnumeric);
    Pattern emptyline = Pattern.compile(empty);
    Pattern mnotnumeric = Pattern.compile (monthnotnumeric);
    Pattern outofrange = Pattern.compile(notinrange);


         file = "test1.text";
       
        if (args.length != 0){

            file = args[0];
        
        }

    
       try{
         

           buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        //    System.out.println("File opened sucessfully");
       }
       catch(IOException e){
            
        System.out.println("error opening file");
        System.out.println(e.getCause());
        System.exit(1);
       }
       try{

        System.out.println("Input file is: "+file);

            // inputLine = buffer.readLine();
           
           while((inputLine=buffer.readLine())!= null){

            // inputLine.strip();
            System.out.printf("\n"+inputLine.strip());
            Matcher m = pattern.matcher(inputLine);
            Matcher k = monthpattern.matcher(inputLine);
            Matcher j = incrementpattern.matcher(inputLine);
            Matcher i = numericpatter.matcher(inputLine);
            Matcher f = incrementnumeic.matcher(inputLine);
            Matcher b = emptyline.matcher(inputLine);
            Matcher a = mnotnumeric.matcher(inputLine);
            Matcher c = outofrange.matcher(inputLine);
            


            if(m.find()){

                
                
                    month1 = Integer.parseInt(m.group(1));
                    day1 = Integer.parseInt(m.group(2));
                    year1 = Integer.parseInt(m.group(3));
                    daystoadd = Integer.parseInt(m.group(4));

                    if (day1!=0){

                    Dte d = new Dte(month1, day1, year1);
                    Dte x = new Dte(d);
                    Dte y = new Dte(d);
                    y.addDays(daystoadd);
                    x.subDays(daystoadd);
                    System.out.print("\t\t"+y);
                    System.out.print("\t\t\t\t"+x);

                    }
                
            }
            

            if (a.matches()){
                System.out.print("\t\tmonth is not numeric");
            }



            if (f.find()){
                System.out.print("\t\tincrement is not numeric");
            }
            if(i.find()){
                System.out.print("\t\tday is not numeric");
            }
            if(j.find()){
                System.out.print("\t\tno increment");
            }
            
            if (c.matches()){
                System.out.print("\t\tday is out of range");
            }
           
            if (b.matches()){
                System.out.print("\t\t\tline is empty");
            }
            else if (!k.find()){
                System.out.print("\t\t\tdate has no slashes");
            }

            recordcount++;

            
           }
           System.out.println("\n\nNo. of records = "+recordcount);


         

       }
       
       catch(IllegalStateException e){

        System.out.println(" does not match expresion");  
        
        
        e.getCause();

        }
    }

}

