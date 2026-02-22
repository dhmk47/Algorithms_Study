package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
public class TheIslandNationOfIreland_DFS_8_13 {
	static int n;
	static int[][] map;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) {
		TheIslandNationOfIreland_DFS_8_13 prc = new TheIslandNationOfIreland_DFS_8_13();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 1) {
						map[i][j] = 0;
						answer++;
						prc.dfs(i, j);
					}
				}
			}
			
			bw.write(String.valueOf(answer));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int y, int x) {
		for(int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(isValidIndex(ny, nx) && map[ny][nx] == 1) {
				map[ny][nx] = 0;
				dfs(ny, nx);
			}
		}
	}
	
	private boolean isValidIndex(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
}