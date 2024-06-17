package mz;

public class BinarySearch {
    public static void main(String[] args) {

        int nums[] = {5,7,9,11,23,44};
        int target = 5;

        int result = binarySearch(nums,target);

        if(result != -1) {
            System.out.println("Element found at Index : " + result);
        }
        else {
            System.out.println("Element not found at Index");
        }
    }

    public static int binarySearch(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target ) {
                return mid;
            }
            // if the target less than mid do shift to the left
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        return - 1;

    }

}
