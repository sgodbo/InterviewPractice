package com.shan.interv;
import java.util.*;
public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,3,6,7};
		int target = 7;
		int min = Integer.MAX_VALUE;
		HashSet<Integer> candidateSet = new HashSet<Integer>();
		for(int num:candidates){
			candidateSet.add(num);
			if(num < min)
				min = num;
		}
		
		List<List<Integer>> collatedSolSet = new ArrayList<List<Integer>>();
 		
		for(int i = 0;i < candidates.length;i++){
			recGetPath(target, candidates[i], candidateSet, min);
		}
	}

	private static HashSet<Integer> recGetPath(int target, int candidate, HashSet<Integer> candidateSet, int min) {
		// TODO Auto-generated method stub
		int diff = target - candidate;
		HashSet<Integer> localCandidateSet = new HashSet<Integer>();
		if(diff < min){
			//return localCandidateSet; Do nothing;
		}	else if(diff == min){
			localCandidateSet.add(min);			
		}	else{
			if(candidateSet.contains(diff))
				localCandidateSet.add(diff);
			else
		}
		return localCandidateSet;
	}

}
