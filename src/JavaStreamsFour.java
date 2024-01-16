import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsFour {

	public static void main(String[] args) {
		
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Azhar");
		names1.add("Aamir");
		names1.add("Don");
		names1.add("Zubair");
		names1.add("Ahmed");
		
		List<String> ls = names1.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(ls); // prints all values
		
		System.out.println(ls.get(0)); // prints first value
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
