package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
public class MazeExploration_DFS_8_10 {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map = new int[7][7];
	static boolean[][] visit = new boolean[7][7];
	static int answer = 0;
	public static void main(String[] args) {
		MazeExploration_DFS_8_10 prc = new MazeExploration_DFS_8_10();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			prc.makeMap();
			prc.dfs(0, 0);
			
			bw.write(String.valueOf(answer));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int y, int x) {
		visit[y][x] = true;
		if(y == 6 && x == 6) {
			answer++;
		}else {
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(isValidIndex(ny, nx) && !visit[ny][nx] && map[ny][nx] == 0) {
					dfs(ny, nx);
					visit[ny][nx] = false;
				}
			}
		}
	}
	
	private boolean isValidIndex(int y, int x) {
		return y >= 0 && y < 7 && x >= 0 && x < 7;
	}
	
	private void makeMap() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 7; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 7; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}