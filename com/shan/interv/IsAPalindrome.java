package com.shan.interv;
import java.util.*;
public class IsAPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "A man, a plan, a canal: Panama";
		isPalindrome(test);
	}

	public static boolean isPalindrome(String s) {
        if(s.isEmpty())
            return true;
        Set<Character> alphas = new HashSet<Character>();
        char[] alphaStrArr = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        for(char c:alphaStrArr){
            alphas.add(c);
        }
        char[] sArr = s.toCharArray();
        Stack<Character> stk = new Stack<Character>();
        Queue<Character> q = new LinkedList<Character>();
        for(char c:sArr){
            if(alphas.contains(Character.toLowerCase(c))){
                stk.push(Character.toLowerCase(c));
                q.offer(Character.toLowerCase(c));
            }
        }
        
        while(!stk.isEmpty() && !q.isEmpty()){
            char c1 = stk.pop();
            char c2 = q.poll();
            if(c1 != c2)
                return false;        
        }
        
        return true;
    }

}
