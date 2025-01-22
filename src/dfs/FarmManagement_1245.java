package dfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FarmManagement_1245 {
	private int[][] map;
	private boolean[][] visit;
	
	// 8방향
	private int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	private int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) {
		FarmManagement_1245 prc = new FarmManagement_1245();
		prc.run();
	}
	
	/*
8 7
4 3 2 2 1 0 1
3 3 3 2 1 0 1
2 2 2 2 1 0 0
2 1 1 1 1 0 0
1 1 6 6 0 1 0
0 0 0 1 1 1 0
0 1 2 2 5 1 0
0 1 1 1 2 1 0
	 * 
	 * (1,2) -> 높이가 3인데 인접한 같은 높이에 들어가 8방향을 검사해야 하지만 (1,1)은 (0,1)에서 한번 다녀와서 들어가지 못 함 -> 진행 중인 노드 기준으로 같은 높이의 노드가 있다면 8방향 체크를 다시 들어가야 할 듯
	 * 해당 노드가 산봉우리인지 먼저 체크를 하고 산봉우리라면 산봉우리 노드를 방문하면서 visit = true로 방문처리
	 * 
	 * 
	 * */
	
	private void run() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			initMap();
			int totalCount = 0;
			
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					if(!visit[i][j] && dfs(i, j)) {
						totalCount++;
					}
				}
			}
			
			bw.write(String.valueOf(totalCount));
			bw.flush();
			bw.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean dfs(int x, int y) {
		boolean result = true;

		int height = map[x][y];
		visit[x][y] = true;
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isOutOfIndex(nx, ny)) {
				continue;
			}
			
			// 8방향중 자신보다 높은 숫자가 있는경우 해당 노드는 산봉우리가 아님을 표시. -> false 리턴
			if(map[nx][ny] > height) {
				result = false;
			}else if(height == map[nx][ny]){
				// 같은 높이일 경우 하나의 봉우리이므로 다음 노드의 8방향도 확인 필요
				if(!visit[nx][ny]) {
					result = dfs(nx, ny);
				}
			}
		}
		
		return result;
	}
	
	private boolean isOutOfIndex(int x, int y) {
		return x < 0 || x >= map.length
				|| y < 0 || y >= map[x].length;
	}
	
	private void initMap() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		map = new int[x][y];
		visit = new boolean[x][y];
		
		for(int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}