package ch_01;
/**
 * 1.12 (Average speed in kilometers) Assume a runner runs 24 miles in 1 hour, 40 minutes,
 * and 35 seconds. Write a program that displays the average speed in kilometers per
 * hour. (Note that 1 mile is 1.6 kilometers.)
 */



public class aufgabe06 {

    public static void main(String[] args) {
        
        int stunde = 1;
        int minutes = 40;
        int seconds = 35;
        int totalDistanz = 24;
        double totalDistanzkilo = totalDistanz * 1.6;
        double convertZumAlles = stunde * 60 + minutes + seconds / 60;
        // konvertieren von stunden zu minuten
        
        double KPH = 60 * totalDistanzkilo / convertZumAlles;
        // konvertieren von minuten zu stunden

        System.out.println(KPH);



    }
}