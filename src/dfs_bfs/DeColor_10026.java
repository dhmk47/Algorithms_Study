package dfs_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class DeColor_10026 {
	static int N;
	static int count;
	static boolean[][] visit;
	static String[][] graph;
					//  상, 하,좌, 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int dfs(int x, int y, int k) {
		// 방문했다면 리턴
		if(visit[x][y] == true) return 0;
		// 방문처리
		visit[x][y] = true;
		String check = graph[x][y]; // 현재 무슨 색인지 검사 하기 위한 변수
		System.out.println(check);
		count++;
		System.out.println(count);
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 범위를 벗어나면 continue
			if(nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1)continue;
			if(k == 0) { // 정상일때
				if(!graph[nx][ny].equals(check)) continue;
                //현재 색깔과 다음 색깔이 같을때
				dfs(nx, ny, k);
			}
			if(k == 1) { // 적록색약일때
				if(!(graph[nx][ny].equals(check) || check.endsWith("R") && graph[nx][ny].equals("G") || check.equals("G") && graph[nx][ny].equals("R")))continue;
				// 현재 색깔과 그 다음 색깔이 같거나
				// 현재 적색이고 다음 색깔이 녹색이거나
				// 현재 색깔이 녹색이고 다음이 적색일때
                dfs(nx, ny, k);
			}
		}
		System.out.println("함수탈출");
		return count;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new String[N][N];
		visit = new boolean[N][N];
		ArrayList<Integer> result = new ArrayList<Integer>();
		String select = "";
		int value = 0;
		for(int i = 0; i < N; i++) {
			select = br.readLine();
			for(int j = 0; j < N; j++) {
				graph[i][j] = String.valueOf(select.charAt(j));
			}
		}
		for(int k = 0; k < 2; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visit[i][j] != true) {
						value = (dfs(i, j, k));
						if(value != 0) {
							result.add(value);
							count = 0;
						}
						
					}
				}
			}
			System.out.println(result.size());
			result.clear();
			for(int u = 0; u < N; u++) { // 방문처리 모두 다시 false로 초기화
				for(int y = 0; y < N; y++) {
					visit[u][y] = false;
				}
			}
			
		}
	}
}