package lienearSearch;

public class liniaeSearch {

    /**
     * @param args
     */
    public static void main(String[] args) {
    int[] nums = {23, 45, 1, 2, 8, 19, -3, 16, -11, 28};
    int target = 23;
    int ans = Search(nums, target);
    System.out.println(ans);
    int ans2 = Search2(nums, target);
    System.out.println(ans2);


    }
    // search in the array: return the index if item found
    // otherwise if item not found return -1
    static int Search(int[] arr, int target) {
    if (arr.length == 0) {
    return -1;
    }
    // run a for loop
    for (int index = 0; index < arr.length; index++)
    {
    // check for element at every index
    int element = arr[index];

    if (element == target) {
    return index;

            }   
        }
        // this line is executed because nothing was found and that means that dont exist
        return -1;
    }
//--------------------------------------------------------
    static int Search2(int[] arr, int target) {
        if (arr.length == 0) {
        return -1;
        }
        // run a for loop
        for (int index = 0; index < arr.length; index++)
        {
        // check for element at every index
        int element = arr[index];
    
        if (element == target) {
        return element; // instead of return index will be returned  the number
    
                }   
            }
            // this line is executed because nothing was found and that means that dont exist
            return -1;
        }
   
}