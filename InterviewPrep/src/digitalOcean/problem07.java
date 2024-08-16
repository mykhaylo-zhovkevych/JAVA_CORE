package digitalOcean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class problem07 {

	public static void main (String [] args) {
		
	// merging two list 
		
		List<String> list1 = new ArrayList<>();
		
		list1.add("1");
		
		List<String> list2 = new ArrayList<>();
		
		list2.add("2");
		
		
		List<String> mergedList = new ArrayList<>(list1);
		
		mergedList.addAll(list2);
		System.out.println(mergedList);
		
		
		
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date); // 06-23-2020

	
		String str1 = "abc  dABCD  abcdAB  CD";
		
		str1 = str1.replace(" ", "");
		
		System.out.println(str1);
		
		
		
		
		String s1 = "Java"; // "Java" String created in pool and reference assigned to s1

		String s2 = s1; //s2 also has the same reference to "Java" in the pool

		System.out.println(s1 == s2); // proof that s1 and s2 have the same reference

		s1 = "Python"; 
		//s1 value got changed above, so how String is immutable?

		//in the above case a new String "Python" got created in the pool
		//s1 is now referring to the new String in the pool 
		//BUT, the original String "Java" is still unchanged and remains in the pool
		//s2 is still referring to the original String "Java" in the pool

		// proof that s1 and s2 have different reference
		System.out.println(s1 == s2); 

		System.out.println(s2); 
		// prints "Java" supporting the fact that original String value is unchanged, hence String is immutable
		
		
		
	}
	
}
