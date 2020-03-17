import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Lambda {
	
	public static void main(String[] args) {
		Map<Integer,String> a = new HashMap();
		a.put(1, "a");
		a.put(2, "b");
		a.put(3, "c");
		a.put(4, "d");
		a.keySet().forEach(i->System.out.println(i+" " + a.get(i)));
		a.entrySet().forEach(i->System.out.println(i));
		
		
		String s;
		s = "Time to code in Java";
		String []arr = s.split(" ");
		int max=0;
		String word="";
		for (String i : arr)
		{
			if (i.length()>max && i.length()%2==0)
			{
				max = i.length();
				word=i;
			}
		}
		System.out.println(word);
		
		System.out.println(Arrays.stream(s.split(" ")).filter(i->i.length()%2==0).max(Comparator.comparingInt(String::length)).get());
	}
}
