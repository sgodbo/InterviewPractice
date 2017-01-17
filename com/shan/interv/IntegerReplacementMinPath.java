package com.shan.interv;
import java.util.*;
public class IntegerReplacementMinPath {

	static Map<Long, Integer> mapTargetMinPath = new HashMap<Long, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long num = 2147483647L;
		integerReplacement(2147483647);
		System.out.println(integerReplacement(num));
	}

	public static int integerReplacement(long n) {
		if(n == 1)
			return 0;
		else{
			if(n%2 == 0){
				if(mapTargetMinPath.containsKey(n/2))
					return 1+mapTargetMinPath.get(n/2);
				else{
					int minPath = integerReplacement(n/2);
					mapTargetMinPath.put(n/2, minPath);
					return 1+minPath;
				}
			}	else{
				int p1 = 0;
				int p2 = 0;
				if(mapTargetMinPath.containsKey(n-1))
					p1 = mapTargetMinPath.get(n-1);
				else{
					p1 = integerReplacement(n-1);
					mapTargetMinPath.put(n-1, p1);
				}
				p1++;
				//if(n < Integer.MAX_VALUE){
					if(mapTargetMinPath.containsKey(n+1))
						p2 = mapTargetMinPath.get(n+1);
					else{
						p2 = integerReplacement(n+1);
						mapTargetMinPath.put(n+1, p2);
					}
					p2++;
					return p1 > p2 ? p2 : p1;
				//}
				//return p1;				
			}
		}
	}

}
