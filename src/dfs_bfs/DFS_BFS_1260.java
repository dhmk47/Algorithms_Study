package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_1260{
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dfs(int start, boolean[] visit) {
		visit[start] = true;
		System.out.print(start + " ");
		for(int i = 0; i < graph.get(start).size(); i++) {
			Collections.sort(graph.get(start));
			int y = graph.get(start).get(i);
			if(!visit[y]) dfs(y, visit);
		}
	}
	
	static void bfs(int start, boolean[] visit2){
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()) {
			int x = q.poll();
			visit2[x] = true;
			System.out.print(x + " ");
			for(int i = 0; i < graph.get(x).size(); i++) {
				Collections.sort(graph.get(x));
				int y = graph.get(x).get(i);
				if(!visit2[y]) {
					q.offer(y);
					visit2[y] = true;
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[N + 1];
		boolean[] visit2 = new boolean[N + 1];
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y); 
			graph.get(y).add(x);
		}
		dfs(V, visit);
		System.out.println();
		bfs(V, visit2);
	}
}
