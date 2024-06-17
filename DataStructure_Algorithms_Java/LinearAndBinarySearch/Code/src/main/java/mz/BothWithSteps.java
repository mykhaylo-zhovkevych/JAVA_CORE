package mz;

public class BothWithSteps {
    public static void main(String[] args) {
        int nums[] = {5, 7, 9, 11, 23, 44};
        int target = 444;

        int result01 = linearSearch(nums, target);
        int result02 = binarySearch(nums, target);

//        System.out.println("Element found at Index : " + (result01 != -1 ? result01 : result02));
        if (result01 != -1) {
            System.out.println("Element found at Index (Linear Search): " + result01);
        } else if (result02 != -1) {
            System.out.println("Element found at Index (Binary Search): " + result02);
        } else {
            System.out.println("Element not found");
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) >> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
