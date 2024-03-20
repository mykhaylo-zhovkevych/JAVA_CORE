package telusko;

public class multiDimensionalArray {
    
    public static void main(String a[]) {
        
        // Declare and initialize a 2D array of integers with dimensions 3x4
        int nums[][] = new int [3][4];

        // row ---- columns |----|
        //                  |----|
        // Loop to iterate over the rows of the array
        for(int i=0; i<3; i++) { 
            // Loop to iterate over the columns of the array
            for(int j=0; j<4; j++) {
                // Generate a random integer between 0 and 99 and assign it to the current element of the array
                nums[i][j] = (int)(Math.random() * 2);
            } 
        }

        // Loop to iterate over the rows of the array
        for(int i=0; i<3; i++) { 
            // Loop to iterate over the columns of the array
            for(int j=0; j<4; j++) {
                // Print the current element of the array followed by a space
                System.out.print(nums[i][j] + " ");
            }
            // Print a newline character to move to the next row of the array
            System.out.println();
        }

        // another loop
        for(int n[] : nums)
        {
            for(int m: n)
            {
                System.out.print(m + " ");

            }
            System.out.println();
        }
    }
}

