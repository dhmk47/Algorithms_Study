package inflearn.java_algorithms.number_7;
import java.io.*;
import java.util.StringTokenizer;
public class PathSearch_List_DFS_7_13 {
	boolean[] visit;
	int destination = 5;
	public static void main(String[] args) {
		PathSearch_List_DFS_7_13 prc = new PathSearch_List_DFS_7_13();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int[][] graph = prc.initGraph();
			prc.visit[1] = true;
			bw.write(String.valueOf(prc.dfs(graph, 1, 0)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int dfs(int[][] graph, int from, int count) {
		if(from == destination) {
			System.out.println("destination!!");
			count++;
		}else {
			for(int i = 1; i < graph[from].length; i++) {
				if(graph[from][i] > 0 && !visit[i]) {
					visit[i] = true;
					System.out.println(from + " >>> " + i);
					count = dfs(graph, i, count);
					visit[i] = false;
				}
			}
		}
		
		return count;
	}
	
	private int[][] initGraph() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from][to] = 1;
		}
		
		return graph;
	}
}