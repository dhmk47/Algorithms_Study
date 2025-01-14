package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Virus_2606{
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] visit;
	static int count;
	
	static void input() throws IOException{
		int cpu = Integer.parseInt(br.readLine());
		int line = Integer.parseInt(br.readLine());
		visit = new boolean[cpu + 1];
		for(int i = 0; i < cpu + 1; i++) {
			graph.add(new ArrayList<Integer>()); // 2차원 배열 할당
		}
		for(int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()); // 그래프 입력
			int x = Integer.parseInt(st.nextToken());
			graph.get(y).add(x);
			graph.get(x).add(y);
		}
	}
	
	static void dfs(int y, int x) {
		// 방문처리 후 방문할때마다 count 1증가
		if(!visit[y]) {
			visit[y] = true;
			count++;
			
		}else {
			return;
		}
		for(int i = 0; i < graph.get(y).size(); i++) {
			// 다음 노드로 가기 위한 반복문
			int next = graph.get(y).get(i);
			dfs(next, 0);
		}
	}
	public static void main(String[] args)throws IOException {
		input();
		dfs(1, 0);
		System.out.println(count - 1); // 시작 컴퓨터는 count에 해당하지 않으므로 - 1
	}
}
