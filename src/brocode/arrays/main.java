package brocode.arrays;

public class main {

    public static void main(String[] args) {
        // array = used to store multi
        String[] cars = {"Camaro","BMW","Tesla"};

        cars[0] = "Mustang";
// so can the boundarys be placed  
        String[] cars01 = new String[4];
        cars01[0] = "Opel";
        cars01[2] = "Porsch";
        cars01[3] = "Kopika";


        for(int i = 0; i <cars01.length; i++) {

        System.out.println(cars01[i]);
        }

       
    }

}
