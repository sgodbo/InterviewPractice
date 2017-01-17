package com.shan.graph;
import java.util.*;
public class Graph {
	private List<Edge> edgeList;
	private Map<String,Integer> vertexMap;
	private Map<Integer,List<Edge>> adjEdges;
	public Graph(){
		edgeList = new ArrayList<Edge>();
		vertexMap = new HashMap<String,Integer>();
		adjEdges = new HashMap<Integer,List<Edge>>();
	}
	
	public void addEdge(String src,String dest,int weight){
		int n1=Integer.MIN_VALUE,n2=Integer.MIN_VALUE;
		List<Edge> adjList1;
		List<Edge> adjList2;
				
		if(vertexMap.containsKey(src)){
			n1 = vertexMap.get(src);		
			adjList1 = adjEdges.get(n1);
		}	else{
			n1 = vertexMap.size();
			vertexMap.put(src, n1);
			adjList1 = new ArrayList<Edge>();
		}
		if(vertexMap.containsKey(dest)){
			n2 = vertexMap.get(dest);
			adjList2 = adjEdges.get(n2);
		}	else{
			n2 = vertexMap.size();
			vertexMap.put(dest, n2);
			adjList2 = new ArrayList<Edge>();
		}
		
		Edge e = new Edge(n1,n2,weight);
		adjList1.add(e);
		adjList2.add(e);
		adjEdges.put(n1,adjList1);
		adjEdges.put(n2,adjList2);
		edgeList.add(e);
	}
	
	public List<Edge> getEdgeList(){
		return edgeList;
	}	
	
	public List<Edge> getAdjEdges(int v){
		return adjEdges.get(v);
	}	
	
	public int numVertices(){
		return vertexMap.size();
	}
	
	public int getVKey(String key){
		return vertexMap.get(key);
	}
}
