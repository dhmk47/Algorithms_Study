package inflearn.java_algorithms.number_7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node_BFS {
	int data;
	Node_BFS lt;
	Node_BFS rt;
	
	Node_BFS(int val) {
		this.data = val;
		this.lt = null;
		this.rt = null;
	}
}

public class BinaryTreeCircuit_BFS_7_7 {
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		BinaryTreeCircuit_BFS_7_7 prc = new BinaryTreeCircuit_BFS_7_7();
		prc.run();
	}
	
	private void run() {
		Node_BFS root = new Node_BFS(1);
		root.lt = new Node_BFS(2);
		root.rt = new Node_BFS(3);
		
		root.lt.lt = new Node_BFS(4);
		root.lt.rt = new Node_BFS(5);
		root.rt.lt = new Node_BFS(6);
		root.rt.rt = new Node_BFS(7);
		
		bfs(root);
		
	}
	
	private void bfs(Node_BFS root) {
		Queue<Node_BFS> q = new LinkedList<>();
		
		q.offer(root);
		try {
			int level = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				bw.write(level + ": ");
				
				for(int i = 0; i < size; i++) {
					Node_BFS node = q.poll();
					bw.write(node.data + " ");
					
					if(node.lt != null) {
						q.offer(node.lt);
					}
					if(node.rt != null) {
						q.offer(node.rt);
					}
				}
				bw.write("\n");
				level++;
			}
			
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}