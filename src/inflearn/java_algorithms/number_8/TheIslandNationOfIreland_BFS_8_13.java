package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
class Node_8_13 {
	int y, x;
	
	Node_8_13(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class TheIslandNationOfIreland_BFS_8_13 {
	static int n;
	static int[][] map;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) {
		TheIslandNationOfIreland_BFS_8_13 prc = new TheIslandNationOfIreland_BFS_8_13();
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
						prc.bfs(i, j);
					}
				}
			}
			
			bw.write(String.valueOf(answer));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void bfs(int y, int x) {
		Queue<Node_8_13> q = new LinkedList<>();
		q.offer(new Node_8_13(y, x));
		
		while(!q.isEmpty()) {
			Node_8_13 currentNode = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int ny = currentNode.y + dy[i];
				int nx = currentNode.x + dx[i];
				
				if(isValidIndex(ny, nx) && map[ny][nx] == 1) {
					map[ny][nx] = 0;
					q.offer(new Node_8_13(ny, nx));
				}
			}
		}
	}
	
	private boolean isValidIndex(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
}