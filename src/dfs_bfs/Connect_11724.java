package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Connect_11724 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visit;
	static int N;
	static boolean dfs(int x, int y) {
		if(visit[x]) return false;
		visit[x] = true;
		for(int i = 0; i < graph.get(x).size(); i++) {
			int nx = graph.get(x).get(i);
			dfs(nx, 0);
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int a = 0;
		int b = 0;
		int count = 0;
		visit = new boolean[N + 1];
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for(int i = 0; i < N; i++) {
			if(dfs(i + 1, 0)) count++;
		}
		System.out.println(count);
	}
}
