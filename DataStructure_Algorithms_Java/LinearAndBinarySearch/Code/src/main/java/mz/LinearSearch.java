package mz;

public class LinearSearch {
    public static void main(String[] args) {

        // with the linearSearch it dont matter if it is sorted Array
        // but in the binarySearch it must be specifited for sorted
        int nums[] = {5,6,7,8,4,3};
        int target = 3;

        // gives the index number where it belongs to
        int result = linearSearch(nums,target);

        if(result != -1) {
            System.out.println("Element found at Index : " + result);
        }
        else {
            System.out.println("Element not found at Index");
        }
    }

    public static int linearSearch(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        // if the value not in the list
        return - 1;

    }
}