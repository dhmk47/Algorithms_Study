package inflearn.java_algorithms.number_7;
import java.io.*;
import java.util.*;

class Node_DFS_7_9 {
	int data;
	Node_DFS_7_9 lt;
	Node_DFS_7_9 rt;
	
	Node_DFS_7_9(int val) {
		this.data = val;
		this.lt = null;
		this.rt = null;
	}
}

public class ShortestPathToEndNode_DFS_7_9 {
	public static void main(String[] args) {
		ShortestPathToEndNode_DFS_7_9 prc = new ShortestPathToEndNode_DFS_7_9();
		try {
			prc.run();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void run() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Node_DFS_7_9 root = new Node_DFS_7_9(1);
		root.lt = new Node_DFS_7_9(2);
		root.rt = new Node_DFS_7_9(3);
		
		root.lt.lt = new Node_DFS_7_9(4);
		root.lt.rt = new Node_DFS_7_9(5);
		
//		root.rt.lt = new Node_DFS_7_9(6);
//		root.rt.rt = new Node_DFS_7_9(7);
		
		try {
			bw.write(String.valueOf(dfs(root, 0)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int dfs(Node_DFS_7_9 node, int n) {
		if(node == null) {
			return n - 1;
		}

		int ltCount = dfs(node.lt, n + 1);
		int rtCount = dfs(node.rt, n + 1);
		
		return Math.min(ltCount, rtCount);
	}
}