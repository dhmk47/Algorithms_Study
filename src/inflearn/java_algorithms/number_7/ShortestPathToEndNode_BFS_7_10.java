package inflearn.java_algorithms.number_7;
import java.io.*;
import java.util.*;

class Node_BFS_7_10 {
	int data;
	Node_BFS_7_10 lt;
	Node_BFS_7_10 rt;
	
	Node_BFS_7_10(int val) {
		this.data = val;
		this.lt = null;
		this.rt = null;
	}
}

public class ShortestPathToEndNode_BFS_7_10 {
	public static void main(String[] args) {
		ShortestPathToEndNode_BFS_7_10 prc = new ShortestPathToEndNode_BFS_7_10();
		try {
			prc.run();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void run() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Node_BFS_7_10 root = new Node_BFS_7_10(1);
		root.lt = new Node_BFS_7_10(2);
		root.rt = new Node_BFS_7_10(3);
		
		root.lt.lt = new Node_BFS_7_10(4);
		root.lt.rt = new Node_BFS_7_10(5);
		
//		root.rt.lt = new Node_BFS_7_10(6);
//		root.rt.rt = new Node_BFS_7_10(7);
		
		try {
			bw.write(String.valueOf(bfs(root, 0)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int bfs(Node_BFS_7_10 node, int n) {
		Queue<Node_BFS_7_10> q = new LinkedList<>();
		
		q.offer(node);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Node_BFS_7_10 temp = q.poll();
				if(temp.lt == null && temp.rt == null) {
					return n;
				}
				if(temp.lt != null) q.offer(temp.lt); 
				if(temp.rt != null) q.offer(temp.rt); 
			}
			n++;
		}

		return n;
	}
}