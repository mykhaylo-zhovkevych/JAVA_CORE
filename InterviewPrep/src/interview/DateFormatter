package com.datum;
import com.datum.DatumFormatter;

public class Main {

    public static void main(String[] args) {
    	// user enters the day, month and year
        Datum datum1 = new Datum(1, 1, 2024);
        Datum datum2 = new Datum(1, 1, 2024);
      
        
        
        
        //  System.out.println(formatDatum(datum1, "CH"));
        // End result
        System.out.println(DatumFormatter.formatDatum(datum1, "CH"));
        System.out.println(DatumFormatter.formatDatum(datum2, "US"));
        System.out.println(DatumFormatter.formatDatum(datum1, "ISO"));
        
        
        // The first Idea of the code implementation 
        System.out.println("CH Format: " + datum1.convertCH());
        System.out.println("US Format: " + datum1.convertUS());
        System.out.println("ISO Format: " + datum1.convertISO());
    }
    
}
package com.datum;

public class Datum {

	// a) Erste teil von Aufgabe 
	
    private int tag;
    private int monat;
    private int jahr;
    
    public Datum(int tag, int monat, int jahr) {
        this.tag = tag;  
        this.monat = monat;
        this.jahr = jahr;
    }
    
    public void setTag(int tag){
        this.tag = tag;
    }
    
    public void setMonat(int monat){
        this.monat = monat;
    }
    
    public void setJahr(int jahr){
        this.jahr = jahr;
    }

    public int getTag(){
        return tag;
    }
    
    public int getMonat(){
        return monat;
    }
    
    public int getJahr(){
        return jahr;
    }
    
    
// b) zweite Teil von Aufgabe
    
    public String convertCH() {
        // 18.04.2005
        return String.format("%02d.%02d.%d", tag, monat, jahr);
    }
    
    public String convertUS() {
        // 04/18/2005
        return String.format("%02d/%02d/%d", monat, tag, jahr);
    }
    
    public String convertISO() {
        // 2005-04-18
        return String.format("%d-%02d-%02d", jahr, monat, tag);
    }
    
    public String convertInvalid() {
    	
    	return "not valied";
    }
    
}
package com.datum;

public class DatumFormatter {

	
	static public String formatDatum(Datum date, String format) {
		
		switch (format) {
        case "CH":
            return date.convertCH();
           
        case "US":
            return date.convertUS();
          
        case "ISO":
            return date.convertISO();
           
        default: 
        	return date.convertInvalid();

		}
	}
}
