package inflearn.java_algorithms.number_7;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class PathSearch_DFS_7_12 {
	boolean[] visit;
	int destination = 5;
	public static void main(String[] args) {
		PathSearch_DFS_7_12 prc = new PathSearch_DFS_7_12();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			List<List<Integer>> graph = prc.initGraph();
			prc.visit[1] = true;
			bw.write(String.valueOf(prc.dfs(graph, 1, 0)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int dfs(List<List<Integer>> graph, int v, int count) {
		if(v == destination) {
			System.out.println("destination!!");
			count++;
		}else {
			for(int nv : graph.get(v)) {
				if(!visit[nv]) {
					visit[nv] = true;
					System.out.println(v + " >>> " + nv);
					count = dfs(graph, nv, count);
					visit[nv] = false;
				}
			}
		}
		
		return count;
	}
	
	private List<List<Integer>> initGraph() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>();
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