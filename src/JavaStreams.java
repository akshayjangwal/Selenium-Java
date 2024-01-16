import java.util.ArrayList;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) {
		
// --------> Count number of names starting with letter 'A' in a list. <---------
		
/**** Approach 1 ---> Using ArrayList ****/
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Akshay");
		names.add("Ram");
		names.add("Abhishek");
		names.add("Ahmed");
		names.add("Varun");
		/*int count = 0; 
		
		for (int i=0; i<names.size(); i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}		
		}
		System.out.println(count); */
		
		/* 1. There is no life for intermediate operation if there is no terminal operation
		   2. Terminal operation will execute only if intermediate operation .filter() returns true
		*/
		
/**** Approach 2.1 ---> Using Java Streams ****/
		
		// We converted our ArrayList object to streams by using .stream()
		
		/*Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);*/
		

/**** Approach 2.2 ****/	
		
		/*Long d = Stream.of("Akshay","Ram","Abhishek","Ahmed","Varun").filter(s->s.startsWith("A")).count();
		System.out.println(d);       
		*/
		
// --------> Print all names in the list with length greater than 4 <-----------
	
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		/* forEach() pulls each & every item created in the new filter (s->s.length()>4) & helps us scan through them
	     We have a main stream names, created a substream with strings having length greater than 4 from it by using filter 
	     From that substream, forEach() pulls each & every item created in the new filter (s->s.length()>4) and it falls in s
		 Then we perform action on that by just printing it */
	
	
// --------> See only first name <----------
	
	
	names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	
	
	
	
	}

}
