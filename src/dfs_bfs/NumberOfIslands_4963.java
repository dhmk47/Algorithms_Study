package dfs_bfs;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class NumberOfIslands_4963 {
	
	static boolean[][] visit = null;
	static boolean isIslandFlag = false;
	static int width = 0;
	static int heigth = 0;
	static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		
		while(true) {
			int count = 0;
			st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			heigth = Integer.parseInt(st.nextToken());
			visit = new boolean[heigth][width];
			
			if(heigth == 0) {
				break;
			}
			graph = new ArrayList<ArrayList<Integer>>();;
			
			for(int i = 0; i < heigth; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < heigth; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < width; j++) {
					int num = Integer.parseInt(st.nextToken());
					graph.get(i).add(num);
					
				}
			}
			
			for(int i = 0; i < heigth; i++) {
				for(int j = 0; j < width; j++) {
					dfs(i, j);
					
					if(isIslandFlag) {
						count++;
					}
				}
			}
			
			bw.write(count + "\n");
			bw.flush();
			
		}
	}
	
	static void dfs(int x, int y) {
		if(visit[x][y]) {
			isIslandFlag = false;
			return;
		}

		visit[x][y] = true;

		isIslandFlag = true;
		if(graph.get(x).get(y) == 0) {
			isIslandFlag = false;
			return;
			
		}
		
		// 좌측 노드가 존재하면
		if(y != 0) {
			dfs(x, y - 1);
		}
		
		// 우측 노드가 존재하면
		if(y + 1 < width) {
			dfs(x, y + 1);
			
		}
		
		// 윗 노드가 존재하면
		if(x != 0) {
			// 윗 노드로 이동
			dfs(x - 1, y);
			
		}
		
		// 아래 노드가 존재하면
		if(x + 1 < heigth) {
			// 아래 노드로 이동
			dfs(x + 1, y);
			
		}
		
		// 좌상단 대각선이 존재하면
		if(x != 0 && y != 0) {
			dfs(x - 1, y - 1);
			
		}
		
		// 우상단 대각선이 존재하면
		if(x != 0 && y + 1 < width) {
			dfs(x - 1, y + 1);
			
		}
		
		// 좌하단 대각선이 존재하면
		if(x + 1 < heigth && y != 0) {
			dfs(x + 1, y - 1);
			
		}
		
		// 우하단 대각선이 존재하면
		if(x + 1 < heigth && y + 1 < width) {
			dfs(x + 1, y + 1);
			
		}
		
		isIslandFlag = true;
	}
	
}