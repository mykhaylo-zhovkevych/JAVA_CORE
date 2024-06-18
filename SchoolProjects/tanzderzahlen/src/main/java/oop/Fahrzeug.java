package oop;

	//Beispiel für Bubble Sort aus der Internet
		
	class BubbleSort { 
	    void bubbleSort(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i = 0; i < n - 1; i++) 
	            for (int j = 0; j < n - i - 1; j++) 
	                if (arr[j] > arr[j + 1]) { 
	                    // swap temp and arr[i] 
	                    int temp = arr[j]; 
	                    arr[j] = arr[j + 1]; 
	                    arr[j + 1] = temp; 
	                } 
	    } 
	  
	    // Prints the array 
	    void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i = 0; i < n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	  
	    
	    
	    // Driver method to test above 
	    public static void main(String args[]) 
	    { 
	        BubbleSort ob = new BubbleSort(); 
	        int arr[] = { 64, 34, 25, 12, 22, 11, 90 }; 
	        ob.bubbleSort(arr); 
	        System.out.println("Sorted array"); 
	        ob.printArray(arr); 
	        
	        
	        
	    // Mein einziges Beispiel für Bubble Sort 
	        
	        int nums[] = {1, 2, 3, 4, 5, 6};
	        int size = nums.length;
	        int temp = 0;
	        
	        System.out.println("before sorting");
	        for(int num : nums) {
	        	System.out.print(num + " ");
	        	
	        }
	        // Ich denke, dass dies keine wirkliche Optimierung ist, da sie Schleifen macht und auch getestet werden muss
	        boolean isSorted = true;
	        for (int c = 0; c < size - 1; c++) {
	        	// das check ob erste elemnt grösser als die zweite, wenn ja dann es wird false sein 
	        	if(nums[c] > nums[c + 1]) {
	        		isSorted = false;
	        		break;
	        	}
	        }
	        
	        
	        if (isSorted) {
	        	System.out.println();
	            System.out.println("Array is already sorted!");
	            return;
	        }
	        
	        // In bubble sort the two values will be compared and swapped
	        // for making the bubble sort there must be made nested loop 
	        // the outer loop will be responsible for number of interetions(passes)
	        // and the inner loop is responsible for the swapping
	        
	        //the outer and the inner loop starting from the 0 and end by the size of the array
	        
	        
	        for(int a = 0; a < size; a++) {
	        	for(int b = 0; b < size - 1; b++) {
	        		//comprising of the nums by adding 1 to move to the next number
	        		if(nums[b] > nums[b + 1]) {
	        			// swapping 
	        			temp = nums[b];
	        			nums[b] = nums[b + 1];
	        			nums[b + 1] = temp;
	        			
	        		}
	        	}
	        	size --;
	        }
	        
	        System.out.println();
	        System.out.println("after sorting");
	        for(int num : nums) {
	        	System.out.print(num + " ");
	        }
	          
	        
	        
	    
	    // Mein Beispiel02 mit bessere Optiemierung
	    
	    
	        int nums02[] = {1, 2, 3, 4, 3, 5};
	        int size02 = nums02.length;
	        int temp02 = 0;
	        
	        System.out.println("before sorting");
	        for(int num02 : nums02) {
	            System.out.print(num02 + " ");
	        }

	        
	        for (int a02 = 0; a02 < size02 - 1; a02++) {
	            boolean swapped = false; 

	            for (int b02 = 0; b02 < size02 - 1 - a02; b02++) { 
	                if (nums02[b02] > nums02[b02 + 1]) {
	                    // Swap
	                    temp02 = nums02[b02];
	                    nums02[b02] = nums02[b02 + 1];
	                    nums02[b02 + 1] = temp02;
	                    swapped = true; // Set flag to true indicating a swap occurred
	                }
	            }

	            // If no elements were swapped, array is sorted
	            if (!swapped) break;
	        }

	        System.out.println();
	        System.out.println("after sorting");
	        for(int num02 : nums02) {
	            System.out.print(num02 + " ");
	     
	    }
	}   
}