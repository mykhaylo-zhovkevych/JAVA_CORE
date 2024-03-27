package telusko.Arrays;

public class threeDArray {
    public static void main(String[] args) {
        // Create a 3-dimensional array with dimensions 3x4x5
        int[][][] nums = new int[3][4][5];

        // Accessing elements in the 3D array
        nums[0][0][0] = 1;
        nums[1][2][3] = 10;

        // Printing elements of the 3D array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.println("nums[" + i + "][" + j + "][" + k + "] = " + nums[i][j][k]);
                }
            }
        }
    }
}
