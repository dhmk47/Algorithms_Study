package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
public class Tomato_BFS_8_12 {
	static int answer = -1;
	static int[][] map;
	public static void main(String[] args) {
		Tomato_BFS_8_12 prc = new Tomato_BFS_8_12();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			prc.bfs();
			bw.write(String.valueOf(answer));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		
	}
}