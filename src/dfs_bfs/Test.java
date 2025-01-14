package dfs_bfs;
import java.util.Scanner;

public class Test {
	static int T; // 테스트 개수
	static int M; // 배추밭 가로
	static int N; // 배추밭 세로
	static int K; // 배추 위치

	static int[][] map; // 배추밭
	static boolean[][] visited; // 방문 여부
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		while (T-- > 0) {

			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();

			map = new int[M][N];
			visited = new boolean[M][N];

			while (K-- > 0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}

			int result = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && visited[i][j] == false) {
						dfs(i, j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
		sc.close();

	}

	// 깊이 우선 탐색
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (map[nx][ny] == 1 && visited[nx][ny] == false) {
					dfs(nx, ny);
				}
			}
		}
	}

}