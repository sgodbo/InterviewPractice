package com.shan.graph;
import java.util.*;
public class PrimsMST {
	private Graph g;
	private BinaryHeapMap<Integer> b;
	private Map<String,String> mstPath;
	private Map<Integer,String> mapVertexLabel;
	private Map<Integer,Edge> mapVertexEdge;
	private int INF_VAL_SUB = 1000000;
	private Map<Integer,Integer> mapHeap;
	private Queue<Integer> minHeap;
	public PrimsMST(){
		g = new Graph();
		b = new BinaryHeapMap<Integer>();
		mstPath = new HashMap<String,String>();
		mapVertexEdge = new HashMap<Integer,Edge>();
		mapVertexLabel = new HashMap<Integer,String>();
		
	}
	
	public Map<String,String> scanTree() {
		Scanner in = new Scanner(System.in);
		String inp = "";
		int startingVertex = -1;
		while (in.hasNextLine() && !(inp = in.nextLine()).trim().isEmpty()) {
			String[] splits = inp.split(" ");
			g.addEdge(splits[0], splits[1], Integer.parseInt(splits[2]));
			if (startingVertex == -1) {
				startingVertex = 0;
			}
			b.addNode(g.getVKey(splits[0]), INF_VAL_SUB);
			b.addNode(g.getVKey(splits[1]), INF_VAL_SUB);
			mapVertexLabel.put(g.getVKey(splits[0]), splits[0]);
			mapVertexLabel.put(g.getVKey(splits[1]), splits[1]);
		}
		in.close();

		b.removeMin();
		while (!b.isEmpty()) {
			for (Edge e : g.getAdjEdges(startingVertex)) {
				int adjVertex = e.getAdjVertex(startingVertex);
				//b.updateNode(adjVertex.getKey(), e.getWeight());
				if (b.containsNode(adjVertex) && b.getNodeVal(adjVertex) > e.getWeight()){
					b.updateNode(adjVertex, e.getWeight());
					mapVertexEdge.put(adjVertex, e);
				}					
			}
			startingVertex = b.removeMin().key;
			Edge mstPathEdge = mapVertexEdge.get(startingVertex);
			mstPath.put(mapVertexLabel.get(mstPathEdge.getSource()),mapVertexLabel.get(mstPathEdge.getDest()));
		}
		return mstPath;
	}
}
