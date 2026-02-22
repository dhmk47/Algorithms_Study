package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;

class Node_8_12 {
	int y, x;
	
	Node_8_12(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class Tomato_BFS_8_12 {
	static int answer = Integer.MIN_VALUE;
	static int n, m;
	static int[][] map, dis;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visit;
	static Queue<Node_8_12> q = new LinkedList<>();
	public static void main(String[] args) {
		Tomato_BFS_8_12 prc = new Tomato_BFS_8_12();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			dis = new int[n][m];
			visit = new boolean[n][m];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					int number = Integer.parseInt(st.nextToken());
					if(number == 1) {									// BFS를 활용할 때 출발점이 여러개일경우라면 미리 큐에 넣어놓는다
						q.offer(new Node_8_12(i, j));
					}
					map[i][j] = number;
				}
			}
			
			prc.bfs();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(!visit[i][j] && map[i][j] == 0) {
						answer = -1;

						bw.write(String.valueOf(answer));
						bw.flush();
						return;
					}else {
						answer = Math.max(answer, dis[i][j]);
						
					}
				}
			}
			
			bw.write(String.valueOf(answer));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void bfs() {
		while(!q.isEmpty()) {
			Node_8_12 currentNode = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = currentNode.y + dy[i];
				int nx = currentNode.x + dx[i];
				
				if(isValidIndex(ny, nx) && map[ny][nx] == 0 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					dis[ny][nx] = dis[currentNode.y][currentNode.x] + 1;
					q.offer(new Node_8_12(ny, nx));
				}
			}
		}
	}
	
	private boolean isValidIndex(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
}