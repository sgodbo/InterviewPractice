package com.shan.graph;

import java.io.*;
import java.util.*;

public class MinimumPenaltyPath {

	static class Edge {
		int srcNode;
		int destNode;
		int weight;

		public Edge(int src, int dest, int w) {
			srcNode = src;
			destNode = dest;
			weight = w;
		}

		public int getAdjVertex(int v) {
			if (v == srcNode)
				return destNode;
			if (v == destNode)
				return srcNode;
			return Integer.MIN_VALUE;
		}
	}

	static class Node implements Comparable<Node> {
		int key;
		int val;

		public Node(int k, int v) {
			key = k;
			val = v;
		}

		public int compareTo(Node n) {
			return this.val - n.val;
		}
	}

	static Map<Integer, List<Edge>> mapAdjVertex = new LinkedHashMap<Integer, List<Edge>>();
	static Queue<Node> pq = new PriorityQueue<Node>();
	static Map<Integer, Node> mapVertexToNode = new LinkedHashMap<Integer, Node>();
	static Map<Integer, Integer> parentMap = new LinkedHashMap<Integer, Integer>();
	static Map<Integer, Integer> distanceMap = new LinkedHashMap<Integer, Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		mapAdjVertex = new LinkedHashMap<Integer, List<Edge>>();
		pq = new PriorityQueue<Node>();
		mapVertexToNode = new LinkedHashMap<Integer, Node>();
		parentMap = new LinkedHashMap<Integer, Integer>();
		distanceMap = new LinkedHashMap<Integer, Integer>();

		for (int i = 1; i <= n; i++) {
			Node node = new Node(i, Integer.MAX_VALUE);
			pq.offer(node);
			mapVertexToNode.put(i, node);
		}

		while (m-- > 0) {
			int src = in.nextInt();
			int dest = in.nextInt();
			int weight = in.nextInt();

			Edge e = new Edge(src, dest, weight);
			List<Edge> adjList1 = new ArrayList<Edge>();
			List<Edge> adjList2 = new ArrayList<Edge>();
			if (mapAdjVertex.containsKey(src)) {
				adjList1 = mapAdjVertex.get(src);
			}
			if (mapAdjVertex.containsKey(dest)) {
				adjList2 = mapAdjVertex.get(dest);
			}
			adjList1.add(e);
			adjList2.add(e);
			mapAdjVertex.put(src, adjList1);
			mapAdjVertex.put(dest, adjList2);
		}

		int startingVertex = in.nextInt();
		int destVertex = in.nextInt();
		in.close();

		updateHeap(startingVertex, 0);
		distanceMap.put(startingVertex, 0);
		parentMap.put(startingVertex, Integer.MIN_VALUE);

		while (!mapVertexToNode.isEmpty()) {
			Node currentNode = pq.poll();
			int current = currentNode.key;

			if (mapVertexToNode.containsKey(current)) {
				if (mapVertexToNode.get(current).val == Integer.MAX_VALUE)
					break;
				distanceMap.put(current, mapVertexToNode.get(current).val);
				mapVertexToNode.remove(current);

				List<Edge> edgeList = mapAdjVertex.get(current);
				if (edgeList != null && !edgeList.isEmpty()) {
					for (Edge e : edgeList) {
						int adjV = e.getAdjVertex(current);
						if (mapVertexToNode.containsKey(adjV) && adjV > 0) {
							int tempWeight = e.weight;
							if (distanceMap.containsKey(current))
								tempWeight = distanceMap.get(current) | tempWeight;
							if (tempWeight < mapVertexToNode.get(adjV).val) {
								updateHeap(adjV, tempWeight);
								parentMap.put(adjV, current);
							}
						}
					}
				}
			}
		}

		if (distanceMap.containsKey(destVertex))
			System.out.println(distanceMap.get(destVertex));
		else
			System.out.println("-1");
	}

	public static void updateHeap(int key, int val) {
		Node tempNode = new Node(key, val);
		// mapVertexToNode.get(key).val = Integer.MAX_VALUE;
		mapVertexToNode.remove(key);
		mapVertexToNode.put(key, tempNode);
		pq.remove(mapVertexToNode.get(key));
		pq.offer(tempNode);
	}

}