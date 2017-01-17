package com.shan.graph;

import java.util.*;
public class DetectCycleUndirectedGraph {
	Graph g;
	DisjointSet d;
	
	public DetectCycleUndirectedGraph(){
		g = new Graph();
		d = new DisjointSet();
	}
	
	public boolean scanTree(){
		Scanner in = new Scanner(System.in);
		String inp = "";
		while(in.hasNextLine() && !(inp = in.nextLine()).trim().isEmpty()){
			String[] splits = inp.split(" ");
			g.addEdge(splits[0], splits[1], Integer.parseInt(splits[2]));
		}
		in.close();
		int vertexCount = g.numVertices();
		while(vertexCount-->0){
			d.makeSet(vertexCount);
		}
		List<Edge> edgeList = g.getEdgeList();
		for(Edge e:edgeList){
			int parent1 = d.findSet(e.getSource());
			int parent2 = d.findSet(e.getDest());
			if(parent1 != parent2)
				d.union(e.getSource(), e.getDest());
			else
				return true;
		}
		return false;
	}
}
