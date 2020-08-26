package selenium_Practise_pack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetClass {

	public static void main(String[] args) {
		Set s=new HashSet();
		s.add("A");
		s.add("B");
		s.add("C");
		s.add("a");
		s.add("A");
		System.out.println(s.size());
		Iterator<String> it=s.iterator();
		/*System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		*/
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
