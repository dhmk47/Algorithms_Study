package inflearn.java_algorithms.number_7;

class Node {
	int data;
	Node lt;
	Node rt;
	public Node(int val) {
		data = val;
		lt = null;
		rt = null;
	}
}
public class BinaryTreeCircuit_DFS_7_5 {
	Node root;
	
	public static void main(String[] args) {
		BinaryTreeCircuit_DFS_7_5 tree = new BinaryTreeCircuit_DFS_7_5();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);

		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		
		tree.dfs(tree.root);
	}
	
	private void dfs(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.println(root.data + " "); // 전위 순회
		dfs(root.lt);
		System.out.println(root.data + " "); // 중위 순회
		dfs(root.rt);
		System.out.println(root.data + " "); // 후위 순회
	}
}