package com.shan.graph;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;;
public class GraphImpl {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrimsMST p = new PrimsMST();
		//KruskalsMST p = new KruskalsMST();
		//DjikstraShortestPath p = new DjikstraShortestPath();
		//p.scanTree();
		/*List<Edge> mstPath = p.scanTree();
		for(Edge e:mstPath){
			System.out.println(e.getSource() + " -> " + e.getDest() + " " + e.getWeight());
		}*/
		/*Map<String,Integer> map1 = p.getShortestPathValsToVertices();
		Map<String,String> map2 = p.getShortestPathsToVertices();
		
		for(Entry<String,Integer> entry:map1.entrySet()){
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
		
		for(Entry<String,String> entry:map2.entrySet()){
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}*/
		//DetectCycleUndirectedGraph d1 = new DetectCycleUndirectedGraph();
		//System.out.println(d1.scanTree());
		/*DisjointSet d = new DisjointSet();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = in.nextInt();
        while(n-->0){
            d.makeSet(n);
        }
        while(i-->0){
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int parent1 = d.findSet(n1);
            int parent2 = d.findSet(n2);
            
            if(parent1 != parent2){
                d.union(n1,n2);
            }
        }    
        in.close();
        
        Map<Integer,Long> mapOfSizeOfSets = d.getMapOfSizeOfSets();
        Set<Integer> visited = new HashSet<Integer>();
        System.out.println(mapOfSizeOfSets.size());
        int count = 0;
        for(Entry<Integer,Long> entry:mapOfSizeOfSets.entrySet()){
            long temp = entry.getValue();
            visited.add(entry.getKey());
            for(Entry<Integer,Long> entry2:mapOfSizeOfSets.entrySet()){
                if(!visited.contains(entry2.getKey()))
                	count += temp*entry2.getValue();
            }
        }
        
        System.out.println(count);*/
		DetectCycleDirectedGraph d = new DetectCycleDirectedGraph();
		System.out.println(d.scanTree());
	}

}
