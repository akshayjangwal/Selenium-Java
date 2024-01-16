import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreamsTwo {

	public static void main(String[] args) {
		
/*** Print names whose last letter is 'y' & covert that name to uppercase ***/
		
		//Stream.of("Akshay","Ram","Aman","Gagan","Ahmed").filter(s->s.endsWith("y")).map(s->s.toUpperCase())
		//.forEach(s->System.out.println(s));
		
     //Whenever we require some modification (like convert to uppercase/lowercase), use map method after filtering.
	
/*** Print names which have first letter as 'A' in uppercase and in sorted order, so output is in order Akshay, Aman, Azgar sequence in uppercase ***/	
 
	List<String> names = Arrays.asList("Azgar","Akshay","Mayank","Syed","Aman");  //----> converting arrays to array list
		
	names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		
		
		
		
		
		
		
	}

}
