package ch_02;

import java.io.*;
// an array named list and a file named output.txt. Here, we are trying to read data from the array and storing to the file.
public class aufgabe04 {
    
        // create an integer array
        private int[] list = { 5, 6, 8, 9, 2 };
    
        // method to write data from array to a file
        public void writeList() {
            PrintWriter out = null;
            FileWriter fileWriter = null; 
            // By initializing it with null here, you ensure that the variable is in scope throughout the method, including in the finally block.
    
            try {
                System.out.println("Entering try statement");
    
                // creating a new file OutputFile.txt or open it
                fileWriter = new FileWriter("OutputFile.txt");
                //When you create a PrintWriter wrapped around a FileWriter, it provides convenient methods for writing formatted text to the file.
                out = new PrintWriter(fileWriter);
               
    
                // writing values from list array to Output.txt
                // Ensure the loop stays within the bounds of the array
                for (int i = 0; i < list.length; i++) {
                    out.println("Value at: " + i + " = " + list[i]);
                }
            }
    
            catch (Exception e) {
                System.out.println("Exception => " + e.getMessage());
            }
    
            finally {
                // checking if PrintWriter has been opened
                if (out != null) {
                    System.out.println("Closing PrintWriter");
                    // close PrintWriter
                    out.close();
                } else {
                    System.out.println("PrintWriter not open");
                }
            }
        }
    }
    
    class Main {
        public static void main(String[] args) {
            aufgabe04 list = new aufgabe04(); // can be bypassed if  the list is static 
            list.writeList();
        
        }
    }

