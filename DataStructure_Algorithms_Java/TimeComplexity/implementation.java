package DataStructure_Algorithms_Java.TimeComplexity;

public class implementation {
    public static void main(String[] args) {

    
    int nums[] = new int [1000];
    int target = 600;

    int result = linearSearch(nums, target);
    int result2 = binarySearch(nums, target);

    if(result != -1)
        System.out.println("the Element found at index : " + result);
    else 
        System.out.println("The Element not found");    
  
    }

    public static int linearSearch(int[] nums, int target) {

        int steps = 0;
        for(int i = 0; i < nums.length; i++) {
            steps ++;
            if(nums[i] == target) {

            System.out.println("linearSearch" + steps);
            return i;
            }
        }
        System.out.println("linearSearch" + steps);
        return -1;

        }

        public static int binarySearch(int[] nums, int target) {

            int steps = 0;
            int left = 0;
            int right = nums.length -1;
            	
            while(left <= right) {
                steps++;
                int mid = (left + right) / 2;

            if(nums[mid] == target) {
                System.out.println("binarySearch" + steps);
                return mid;

                }
                else if(nums[mid] < target) {
                    left = mid + 1;  
                }
                else
                    right = mid - 1;
            }  

        System.out.println("binarySearch" + steps);    
        return -1;
    
        }
}
