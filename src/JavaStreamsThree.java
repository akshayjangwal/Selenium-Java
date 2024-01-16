import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.Assert;

import com.google.common.collect.Streams;

public class JavaStreamsThree {

	public static void main(String[] args) {
		
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Azhar");
		names1.add("Aamir");
		names1.add("Don");
		names1.add("Zubair");
		names1.add("Ahmed");
		
		ArrayList<String> names2 = new ArrayList<String>();
		names1.add("Ram");
		names1.add("Shyam");
		names1.add("Ghanshyam");
		names1.add("Rajedra");
		names1.add("Amit");
		
/**** Merge the two different lists together ****/
		
		Stream<String> newStream = Stream.concat(names1.stream(), names2.stream()); //concat() method helps to concatenate two strings
		
		//newStream.sorted().forEach(s->System.out.println(s));
		// OUTPUT should be ----> Aamir Ahmed Amit Azhar Don Ghanshyam Rajedra Ram Shyam Zubair

		
/**** See if a particular name is present in the list ****/	
		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Zubair"));
		System.out.println(flag);
		
		
// ---> Till now, we have taken the list -> converted that into stream -> Modified it -> printed it in the output <-----
		
/* --->  Now using streamCollect() method, we will take the list -> convert it into stream -> do all the manipulations -> convert the final result 
		back to the list i.e. a new list (refer JavaStreamsFour) <--- */
		
		
		
		
		
		

	}

}
