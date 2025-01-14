package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JumpKing_16173 {
	int nodeSize = 0;
	int[][] node = null;
	boolean[][] visit = null;
	boolean pass = false;
	
	
	public static void main(String[] args) {
		JumpKing_16173 prc = new JumpKing_16173();
		prc.run();
	}
	
	private void run() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int x = 1;
			int y = 1;
			String print = "Hing";
			
			initMap();
			
			int jumpValue = node[x][y];
			
			dfs(x, y + jumpValue);
			dfs(x + jumpValue, y);
			
			if(pass) {
				print = "HaruHaru";
			}
			
			bw.write(print);
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int moveX, int moveY) {
		// 배열 크기 초과 체크 및 정답일 경우
		if(outOfIndex(moveX, moveY) || pass) {
			return;
		}
		
		// 방문하지 않은 노드만
		if(!visit[moveX][moveY]) {
			visit[moveX][moveY] = true;
			
			int jumpValue = node[moveX][moveY];
			
//			System.out.println(jumpValue);
			if(jumpValue == -1) {
				pass = true;
				return;
			}
			
			dfs(moveX, moveY +  + jumpValue);
			dfs(moveX + jumpValue, moveY);
		}
	}
	
	private boolean outOfIndex(int x, int y) {
		return x > nodeSize || y > nodeSize;
	}
	
	private void initMap() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		nodeSize = Integer.parseInt(br.readLine());
		node = new int[nodeSize + 1][nodeSize + 1];
		visit = new boolean[nodeSize + 1][nodeSize + 1];
		
		for(int i = 0; i < nodeSize; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < nodeSize; j++) {
				node[i + 1][j + 1] =  Integer.parseInt(st.nextToken());
			}
			
		}
	}
	
//	private void printMap(String[][] map) {
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}
}