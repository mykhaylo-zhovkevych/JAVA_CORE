package ArrayList_Arrays;

public class MaxArray {
    public static void main(String[] args) {
        int [] arr = {1112,23,1,232,0};
    System.out.println(maxRange(arr, 0, 4));

}

    static int max (int[] arr) {
        
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > maxVal){
                maxVal = arr[i];
            }

        }
        return maxVal;


    }


    static int maxRange (int[] arr, int start, int end) {
        
        int maxVal = arr[start];
        for (int i = start; i <= end; i++){
            if (arr[i] > maxVal){
                maxVal = arr[i];
            }

        }
        return maxVal;


    }




}
