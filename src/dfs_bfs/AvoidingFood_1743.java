package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class AvoidingFood_1743 {
	static int height = 0;
	static int width = 0;
	static int[][] graph = null;
	static int answer = 0;
	static int[] ny = {-1, 1, 0, 0};
	static int[] nx = {0, 0, 1, -1};
	static int tempAnswer = 0;
	
	static public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		graph = new int[height][width];
		int amount = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < height; i++) {
			Arrays.fill(graph[i], 0);
		}
		
		for(int i = 0; i < amount; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			graph[a][b] = 1;
		}
		
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[i].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

		for(int i = 0; i < graph.length; i++) {
			
			for(int j = 0;j < graph[i].length; j++) {
				int point = graph[i][j];
				tempAnswer = 0;
				
				if(point > 0) {
					dfs(i, j);
					answer = Math.max(answer, tempAnswer);
				}
			}
		}
		
		bw.write(answer + "\n");
		bw.flush();
	}
	
	static void dfs(int y, int x) {
		tempAnswer++;
		graph[y][x] = 0;
			
//		if(answer < tempAnswer) {
//			answer = tempAnswer;
//		}
		
		for(int i = 0; i < nx.length; i++) {
			int nextX = x + nx[i];
			int nextY = y + ny[i];
			// 상 하 우 좌
			if(nextX > -1 && nextY > -1 && nextX < width && nextY < height && graph[nextY][nextX] > 0) {
				dfs(nextY, nextX);
			}
		}
		
	}
}