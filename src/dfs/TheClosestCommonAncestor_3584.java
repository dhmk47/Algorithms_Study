package dfs;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TheClosestCommonAncestor_3584 {
	private List<List<Integer>> node;
	private boolean[] visit = new boolean[2];
	private int[] target = new int[2];

	public static void main(String[] args) {
		TheClosestCommonAncestor_3584 prc = new TheClosestCommonAncestor_3584();
		prc.run();
	}
	
	private void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int testCase = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < testCase; i++) {
				initNode(br);
				
				int minDepth = node.size();
				int answer = 0;
				
				// 전체 부모노드에서 시작
				for(int j = 1; j < node.size(); j++) {
					System.out.println("start");
					int depth = dfs(j, 0);
					
					// 공통 조상을 찾았으며 최대깊이보다 깊을 경우
					if(visit[0] && visit[1]) {
						if(depth < minDepth) {
							minDepth = depth;
							answer = j;
						}
					}
					
					visit[0] = false;
					visit[1] = false;
				}
				
				bw.write(answer + "\n");
			}
			bw.flush();
			bw.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int dfs(int move, int depth) {
		
		if(node.get(move).size() == 0) {
			return depth - 1;
		}
		
		for(int i = 0; i < node.get(move).size(); i++) {
			int pullNode = node.get(move).get(i);
			
			System.out.println("pullNode: " + move + " > " + pullNode);
			if(pullNode == target[0]) {
				visit[0] = true;
				System.out.println(pullNode);
			}else if(pullNode == target[1]) {
				visit[1] = true;
				System.out.println(pullNode);
			}
			
			if(visit[0] && visit[1]) {
				return depth;
			}
			depth = dfs(pullNode, depth + 1);
		}
		
		return depth;
	}
	
	private void initNode(BufferedReader br) throws Exception {
		StringTokenizer st = null;
		int height = Integer.parseInt(br.readLine());
		node = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < height + 1; i++) {
			node.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			if(i == (height - 1)) {
				target[0] = node1;
				target[1] = node2;
			}else {
				node.get(node1).add(node2);
			}
			
		}
		
		
	}
}