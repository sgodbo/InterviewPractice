package com.shan.graph;
import java.util.*;
public class KruskalsMST {
	private Graph g;
	private List<Edge> edgeList;
	private DisjointSet d;
	private List<Edge> mstPath;
	public KruskalsMST(){
		g = new Graph();
		d = new DisjointSet();
		mstPath = new ArrayList<Edge>();
	}
	
	public List<Edge> scanTree(){
		Scanner in = new Scanner(System.in);
		String inp = "";
		while(in.hasNextLine() && !(inp = in.nextLine()).trim().isEmpty()){
			String[] splits = inp.split(" ");
			g.addEdge(splits[0], splits[1], Integer.parseInt(splits[2]));			
		}
		in.close();
		edgeList = g.getEdgeList();
		int vertexCount = g.numVertices();
		while(vertexCount-->0){
			d.makeSet(vertexCount);
		}
		
		Collections.sort(edgeList);
		for(Edge e:edgeList){			
			int parent1 = d.findSet(e.getSource());
			int parent2 = d.findSet(e.getDest());
			
			if(parent1 != parent2){
				d.union(e.getSource(), e.getDest());
				mstPath.add(e);
			}
		}
		return mstPath;
	}
}
