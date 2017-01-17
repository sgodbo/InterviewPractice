package com.shan.graph;

import java.util.*;

public class SnakesAndLadders {

	static Map<Integer, Integer> ladders;
	static Map<Integer, Integer> snakes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int l = in.nextInt();
			ladders = new HashMap<Integer, Integer>();
			for (int i = 0; i < l; i++) {
				ladders.put(in.nextInt(), in.nextInt());
			}
			int s = in.nextInt();
			snakes = new HashMap<Integer, Integer>();
			for (int i = 0; i < s; i++) {
				snakes.put(in.nextInt(), in.nextInt());
			}
			System.out.println(bfs());
			snakes.clear();
			ladders.clear();
		}
		
		in.close();
	}

	public static int bfs() {
		Queue<Integer> qNodes = new LinkedList<Integer>();
		qNodes.offer(1);
		qNodes.offer(-1);
		Set<Integer> visited = new HashSet<Integer>();
		int moveCount = 1;
		int minMoveCount = 1;
		while (!qNodes.isEmpty()) {
			int temp = qNodes.poll();
			if (temp != -1) {
				for (int j = 1; j <= 6 && temp + j <= 100; j++) {
					int temp1 = temp + j;
					if (ladders.containsKey(temp + j)) {
						temp1 = ladders.get(temp + j);
					}
					if (snakes.containsKey(temp + j)) {
						temp1 = snakes.get(temp + j);
					}
					if (temp1 == 100){
						if(moveCount < minMoveCount)
							minMoveCount = moveCount;
					}
					if(!visited.contains(temp1)){
						qNodes.offer(temp1);
						visited.add(temp1);
					}					
				}
			} else {
				moveCount++;
				if (!qNodes.isEmpty()) {
					qNodes.offer(-1);
				}
			}
		}
		
		return minMoveCount;
	}

}
