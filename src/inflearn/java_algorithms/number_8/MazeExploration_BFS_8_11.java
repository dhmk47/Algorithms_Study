package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
class Node_8_11 {
	int y, x, count;
	
	Node_8_11(int y, int x, int count) {
		this.y = y;
		this.x = x;
		this.count = count;
	}
}
public class MazeExploration_BFS_8_11 {
	static int[][] map = new int[7][7];
	static int[][] dis = new int[7][7];
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visit = new boolean[7][7];
	static int answer = -1;
	
	public static void main(String[] args) {
		MazeExploration_BFS_8_11 prc = new MazeExploration_BFS_8_11();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			for(int i = 0; i < 7; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 7; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			prc.bfs();
//			bw.write(String.valueOf(answer));
			prc.bfs_2();
			bw.write(String.valueOf(dis[6][6] == 0 ? -1 : dis[6][6]));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void bfs() {
		Queue<Node_8_11> q = new LinkedList<>();
		q.offer(new Node_8_11(0, 0, 0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Node_8_11 node = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isValidIndex(ny, nx) && !visit[ny][nx] && map[ny][nx] == 0) {
					
					if(ny == 6 && nx == 6) {
						answer = node.count + 1;
						q.clear();
						break;
					}
					visit[ny][nx] = true;
					q.offer(new Node_8_11(ny, nx, node.count + 1));
				}
			}
		}
	}
	private void bfs_2() {
		Queue<Node_8_11> q = new LinkedList<>();
		q.offer(new Node_8_11(0, 0, 0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Node_8_11 node = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isValidIndex(ny, nx) && !visit[ny][nx] && map[ny][nx] == 0) {
					
					if(ny == 6 && nx == 6) {
						dis[ny][nx] = dis[node.y][node.x] + 1;
						q.clear();
						break;
					}
					visit[ny][nx] = true;
					q.offer(new Node_8_11(ny, nx, node.count + 1));
					dis[ny][nx] = dis[node.y][node.x] + 1;
				}
			}
		}
	}
	
	private boolean isValidIndex(int y, int x) {
		return y >= 0 && y < 7 && x >= 0 && x < 7;
	}
}
