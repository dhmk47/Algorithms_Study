package simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class RobotVacuum_14503 {
						// 북, 동, 남, 서
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
	static int M;
	static int direction;
	static int[][] graph;
	static boolean[][] clean;
	static int count;
	static int start(int x, int y, int see) {
		
		if(graph[x][y] == 0) {
			count++;
			graph[x][y] = 2;
		}
		if(graph[x][y] == 1) return 0;
		
		if(clean[x][y] && clean[x - 1][y] && clean[x + 1][y] && clean[x][y + 1] && clean[x][y - 1]) {
			int back = (see + 2) % 4;
			
			if(graph[x][y] == 1) {
				return 0;
			}
			else {
				start(x, y, see);
			}
		}
		
		if(clean[x][y] == true) return 0;
		
		clean[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			direction = (see + 3) % 4;
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			if(!(nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)) {
				start(nx, ny, see);
			}
			else {
				see = (direction + 3) % 4;
			}
		}
		
		return count;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		clean = new boolean[N][M];
		graph = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int see = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(start(x, y, see));
	}
}
