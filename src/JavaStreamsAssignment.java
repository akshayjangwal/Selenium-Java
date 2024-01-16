import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamsAssignment {

	public static void main(String[] args) {


	/*** Array = {3,2,2,7,5,1,9,7} 
	 1. Print unique numbers from this array
	 2. Sort the array -> output should be 1,2,3,5,7,9
	 3. Print the third index of sorted array in step 2 ***/

	// STEP 1 : Convert array into streams
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		
		//values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> ls = values.stream().distinct().sorted().collect(Collectors.toList());
	    System.out.println(ls.get(2));
	
	
	
	}

}
