package com.shan.graph;

import java.io.*;
import java.util.*;

public class PrimMSTShort {
	static class Edge{
		int srcNode;
		int destNode;
		int weight;
		
		public Edge(int src,int dest,int w){
			srcNode = src;
			destNode = dest;
			weight = w;
		}
		
		public int getAdjVertex(int m){
			if(m == srcNode)
				return destNode;
			if(m == destNode)
				return srcNode;
			return Integer.MIN_VALUE;
		}
	}
	
	static class Node implements Comparable<Node>{
		int key;
		int val;
		
		public Node(int k,int v){
			key = k;
			val = v;
		}
		
		public int compareTo(Node n){
			return this.val - n.val;
		}
	}
    
    static Map<Integer,List<Edge>> mapVertexAdjEdge = new HashMap<Integer,List<Edge>>();
    static Queue<Node> pq = new PriorityQueue<Node>();
    static Map<Integer,Node> mapVertexNode = new HashMap<Integer,Node>();
    static List<Edge> mstPath = new ArrayList<Edge>();
    static Map<Integer,Edge> mapVertexEdgeMst = new HashMap<Integer,Edge>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();
		while(n>0){
			Node node = new Node(n,Integer.MAX_VALUE);
			pq.offer(node);
			mapVertexNode.put(n, node);
			n--;
		}
		
		while(m-->0){
			int src,dest;
            src = in.nextInt();
            dest = in.nextInt();
            
			Edge e = new Edge(src,dest,in.nextInt());
			List<Edge> adjList1 = new ArrayList<Edge>();
			List<Edge> adjList2 = new ArrayList<Edge>();
			
			if(mapVertexAdjEdge.containsKey(src)){
				adjList1 = mapVertexAdjEdge.get(src);
			}
			if(mapVertexAdjEdge.containsKey(dest)){
				adjList2 = mapVertexAdjEdge.get(dest);
			}
			
			adjList1.add(e);
			adjList2.add(e);
			
			mapVertexAdjEdge.put(src, adjList1);
			mapVertexAdjEdge.put(dest, adjList2);
		}	
		
		
		
		int startingVertex = in.nextInt();
        in.close();
        updateMinHeapVal(startingVertex,0);
        
		while(!mapVertexNode.isEmpty()){
            int current = pq.poll().key;
            mapVertexNode.remove(current);
            mstPath.add(mapVertexEdgeMst.remove(current));
			for(Edge e:mapVertexAdjEdge.get(current)){
				int adjV = e.getAdjVertex(current);
				if(mapVertexNode.containsKey(adjV)){
					int weight = mapVertexNode.get(adjV).val;
					if(weight > e.weight){
                        updateMinHeapVal(adjV, e.weight);
						mapVertexEdgeMst.put(adjV, e);
					}
				}								
			}			
		}
		int sum = 0;
		for(Edge e:mstPath){
            if(e != null)
			    sum += e.weight;
		}
		
		System.out.println(sum);
	}
    
    public static void updateMinHeapVal(int k,int v){
        pq.remove(mapVertexNode.get(k));
        Node tempNode = new Node(k,v);
        pq.offer(tempNode);
        mapVertexNode.put(k,tempNode);
    }


}
