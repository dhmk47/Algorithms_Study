package inflearn.java_algorithms.number_7;
import java.io.*;
import java.util.*;
public class GraphShortestDistance_BFS_7_14 {
	boolean[] visit;
	int destination = 5;
	public static void main(String[] args) {
		GraphShortestDistance_BFS_7_14 prc = new GraphShortestDistance_BFS_7_14();
		
		try {
			prc.bfs(prc.initGraph(), 1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void bfs(List<List<Integer>> graph, int v) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dis = new int[graph.size()];
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(v);
		visit[v] = true;
		dis[v] = 0;
		
		while(!q.isEmpty()) {
			int currentV = q.poll();
			
			for(int nv : graph.get(currentV)) {
				if(!visit[nv]) {
					visit[nv] = true;
					q.offer(nv);
					dis[nv] = dis[currentV] + 1;
				}
			}
		}
		
		for(int i = 1; i < dis.length; i++) {
			bw.write(String.valueOf(i + " : " + dis[i] + "\n"));
		}
		bw.flush();
	}
	
	private List<List<Integer>> initGraph() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<List<Integer>> graph = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n + 1];
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
		}
		
		return graph;
	}
}