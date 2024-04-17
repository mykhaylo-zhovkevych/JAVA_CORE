package ArrayList_Arrays;

public class TwoDArray01 {

    int[][] twoDArray = new int[5][5];

    public void initializeAndPrintArray() {
        // Initializing the 2D array with values
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                twoDArray[i][j] = i + j;
            }
        }

        // Printing the 2D array
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TwoDArray01 array = new TwoDArray01();
        array.initializeAndPrintArray();
    }
}
