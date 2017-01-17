package com.shan.interv;

import java.util.*;
public class FindFirstRepeated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "He had had quite enough of this nonsense.";
		System.out.println(firstRepeatedWord(test));
	}
	
	static String firstRepeatedWord(String s) {
        String[] sSplits = s.split("\\s|\\t|[,]|[:]|[;]|[-]|[.]");
        Set<String> setOfStrings = new HashSet<String>();
        for(String sp:sSplits){
            if(setOfStrings.contains(sp)){
                System.out.println(sp);
                return sp;
            }
            setOfStrings.add(sp);
        }
        
        return "";
    }

}
