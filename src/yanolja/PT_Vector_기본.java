package yanolja;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class PT_Vector_±âº» {
	
	private static final String[] city=new String[] {"Seoul","Tokyo","Busan","New York","Paris","London","Nice","Amsterdam"};

	public static void main(String[] args) {
		
		Vector v1=new Vector();
		
		v1.add("FF7");
		v1.add(123);
		v1.add('c');
		
		String str=(String)v1.get(0);
		System.out.println(str);
		
		Integer num=(Integer)v1.get(1);
		System.out.println(num);
		
		char ch=(char)v1.get(2);
		System.out.println(ch);
		
		Vector<String> v2=new Vector<String>();
		
		for(String strs:city) {
			v2.add(strs);
		}
		
		System.out.println();
		
		System.out.println(v2.size());
		System.out.println(v2.capacity());
		System.out.println(v2.firstElement());
		System.out.println(v2.lastElement());
		System.out.println(v2.get(3));
		
		System.out.println();
		
		//--------------------------------------------
		
		for(int i=0;i<v2.size();i++) {
			System.out.print(v2.get(i)+" ");
		}
		
		System.out.println();
		
		//--------------------------------------------
		
		for(String strs:v2) {
			System.out.print(strs+" ");
		}
		
		System.out.println();
		
		//--------------------------------------------
		
		Iterator<String> it=v2.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
	}

}
