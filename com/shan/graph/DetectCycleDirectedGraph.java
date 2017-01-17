package com.shan.graph;
import java.io.*;
import java.util.*;

public class DetectCycleDirectedGraph {
	int flag = 0;
	int V;
	LinkedList<Integer> adj[];

	DetectCycleDirectedGraph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int e) {
		adj[v].add(e);
	}

	void DFSUtil(boolean visited[], int i, Stack<Integer> st) {
		st.push(i);
		visited[i] = true;
		for (int k : adj[i]) {
			if (!visited[k])
				DFSUtil(visited, k, st);
			else if (st.contains(k))
				flag = 1;
		}
		if (flag != 1)
			st.pop();
	}

	void DFS() {
		Stack<Integer> st = new Stack<Integer>();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				DFSUtil(visited, i, st);
		}
	}

	public static void main(String args[]) {
		DetectCycleDirectedGraph g = new DetectCycleDirectedGraph(5);
		
		g.addEdge(1, 0);
		g.addEdge(2, 0);
		g.addEdge(3, 0);
		g.addEdge(0, 4);
		g.DFS();
		if (g.flag == 1)
			System.out.println("contains cycle");
		else
			System.out.println("no cycle");
	}
}
