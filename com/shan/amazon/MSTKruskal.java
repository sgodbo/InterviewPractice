package com.shan.amazon;
import java.util.*;
import java.io.*;
public class MSTKruskal {

	static class Edge implements Comparable<Edge>{
		int srcNode;
		int destNode;
		int weight;
		
		public Edge(int s,int d,int w){
			srcNode = s;
			destNode = d;
			weight = w;
		}
		
		public int compareTo(Edge e){
			return this.weight - e.weight;
		}
	}
	static int[] djSetRanks;
	static int[] djSetParents;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Map<String,Integer> vertexMap = new HashMap<String,Integer>();
		List<Edge> edgeList = new ArrayList<Edge>();
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		djSetRanks = new int[n];
		djSetParents = new int[n];
		
		for(int i = 0;i < n;i++){
			djSetParents[i] = i;
		}
		
		in.nextLine();
		while(m-->0){
			String[] inp = in.nextLine().split(" ");
			if(!vertexMap.containsKey(inp[0])){
				vertexMap.put(inp[0],vertexMap.size());
			}
			if(!vertexMap.containsKey(inp[1])){
				vertexMap.put(inp[1],vertexMap.size());
			}
			Edge e = new Edge(vertexMap.get(inp[0]),vertexMap.get(inp[1]),Integer.parseInt(inp[2]));
			edgeList.add(e);
		}
		
		Collections.sort(edgeList);
		
		List<Edge> mstPath = new ArrayList<Edge>();
		for(Edge e:edgeList){
			int parent1 = findSet(e.srcNode);
			int parent2 = findSet(e.destNode);
			
			if(parent1 != parent2){
				union(e.srcNode,e.destNode);
				mstPath.add(e);
			}
		}
		int sum = 0;
		for(Edge e:mstPath){
			sum += e.weight;
		}
		
		System.out.println(sum);
	}
	
	public static int findSet(int k){
		int parent = djSetParents[k];
		if(parent != k){
			parent = findSet(parent);
			djSetParents[k] = parent;
		}
		
		return parent;
	}
	
	public static void union(int k1,int k2){
		int parent1 = findSet(k1);
		int parent2 = findSet(k2);
		
		if(djSetRanks[parent1] >= djSetRanks[parent2]){
			if(djSetRanks[parent1] == djSetRanks[parent2]){
				djSetRanks[parent1]++;
			}
			djSetRanks[parent2] = 0;
			djSetParents[parent2] = djSetParents[parent1];
		}	else{
			djSetRanks[parent1] = 0;
			djSetParents[parent1] = djSetParents[parent2];
		}
	}

}
