package com.shan.graph;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Test {    
	static class Edge{
		int srcNode;
		int destNode;
		int weight;
		
		public Edge(int src,int dest,int w){
			srcNode = src;
			destNode = dest;
			weight = w;
		}
		
		public int getAdjVertex(int v){
			if(v == srcNode)
				return destNode;
			if(v == destNode)
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
	
	public static void main(String[] args){		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
        	Map<Integer,List<Edge>> mapVertexAdjEdge = new HashMap<Integer,List<Edge>>();
    		Queue<Node> pq = new PriorityQueue<Node>();
    		Map<Integer,Node> mapVertexToNode = new HashMap<Integer,Node>();
    		Map<Integer,Integer> prevNodeMap = new HashMap<Integer,Integer>();
    		Map<Integer,Integer> distNodeMap = new HashMap<Integer,Integer>();
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            for(int i = 1;i <= n;i++){
                Node node = new Node(i,Integer.MAX_VALUE);
                pq.offer(node);
                mapVertexToNode.put(i, node);
                distNodeMap.put(i, -1);
            }

            while(m-->0){
                String[] inp = in.nextLine().split(" ");
                int src,dest;
                src = Integer.parseInt(inp[0]);
                dest = Integer.parseInt(inp[1]);

                List<Edge> adjList1 = new ArrayList<Edge>();
                List<Edge> adjList2 = new ArrayList<Edge>();

                if(mapVertexAdjEdge.containsKey(src)){
                    adjList1 = mapVertexAdjEdge.get(src);
                }
                if(mapVertexAdjEdge.containsKey(dest)){
                    adjList2 = mapVertexAdjEdge.get(dest);
                }

                Edge e = new Edge(src,dest,Integer.parseInt(inp[2]));
                adjList1.add(e);
                adjList2.add(e);

                mapVertexAdjEdge.put(src, adjList1);
                mapVertexAdjEdge.put(dest, adjList2);
            }

            int actStartingV = Integer.parseInt(in.nextLine());
            int startingVertex = actStartingV;
            
            //distNodeMap.remove(startingVertex);
            mapVertexToNode.remove(startingVertex);

            while(!mapVertexToNode.isEmpty()){
                for(Edge e:mapVertexAdjEdge.get(startingVertex)){
                    int adjV = e.getAdjVertex(startingVertex);
                    if(mapVertexToNode.containsKey(adjV)){
                        int tempWeight = e.weight;
                        if(distNodeMap.get(startingVertex) != -1)
                        	tempWeight += distNodeMap.get(startingVertex);
                        
                        if(mapVertexToNode.get(adjV).val > tempWeight){
                            mapVertexToNode.get(adjV).val = Integer.MAX_VALUE;
                            Node node = new Node(adjV,tempWeight);
                            mapVertexToNode.put(adjV, node);
                            pq.offer(node);

                            prevNodeMap.put(adjV, startingVertex);
                            distNodeMap.put(adjV, tempWeight);
                        }
                    }				
                }
                Node temp = pq.poll();
                startingVertex = temp.key;
                mapVertexToNode.remove(startingVertex);
            }

            for(int i = 1;i <= n;i++){
                if(i != actStartingV)
                    System.out.print(distNodeMap.get(i) + " ");
              }
            System.out.println();
        }
        in.close();
    }       
}