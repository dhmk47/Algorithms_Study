package dfs;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Cheese_2638 {
	private int[][] nodes;
	private boolean[][] visit;
	private int[] dx = {-1, 0, 1, 0};
	private int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Cheese_2638 prc = new Cheese_2638();
		prc.run();
	}
	
	/*
	
	노드 크기를 순회하면서 가장자리 먼저 dfs로 탐색 후 2방향 이상이 0인것은 노드의 값을 0으로 변경 모든 노드 돌았다면 카운트 +1
	ㄴ 이때 2방향 중 0이 있다면 해당 노드를 탐색한다 -> 탐색해서 x축과 y축이 인덱스 0번으로 닿지 못한다면 갇혀있는 공기로 치즈를 0으로 바꾸지 않는다 (가장자리에는 치즈가 존재할 수 없다)
	
	
	*/
	private void run() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int answer = 0;
			initNodes();
			
			for(int i = 0; i < nodes.length; i++) {
				for(int j = 0; j < nodes[i].length; j++) {
					visit = new boolean[visit.length][visit[i].length];
					
					if(!visit[i][j] && nodes[i][j] != 0 && checkNode(i, j)) {
						answer++;
					}
				}
			}
			
			bw.write(String.valueOf(answer));
			bw.flush();
			bw.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkNode(int x, int y) {
		boolean result = false;
		int airCount = 0;
		
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isOutOfIndex(nx, ny)) {
				// 다음방향이 공기라면 갇혀있는 공기인지 확인이 필요합니다.
				if(nodes[nx][ny] == 0) {
					if(checkAir(nx, ny, new boolean[visit.length][visit[nx].length])) {
						airCount++;
					}
				}else {
					// 계속 탐색하면서 2방향이 공기라면 1 -> 0으로 바꾸는 작업입니다.
					if(!visit[nx][ny]) {
						checkNode(nx, ny);
					}
				}
			}
		}
		
		if(airCount > 1) {
			nodes[x][y] = 0;
			result = true;
		}
		
		
		return result;
	}
	
	private boolean checkAir(int x, int y, boolean[][] visit) {
		boolean result = false;

		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위 초과하면 가장자리 까지 왔다고 판단 -> 갇혀있는 공기가 아닙니다.
			// 가장가자리는 치즈가 존재할 수 없다는 제한이 존재
			if(isOutOfIndex(nx, ny)) {
				return true;
			}else {
				if(!visit[nx][ny]) {
					result = checkAir(nx, ny, visit);
					
					if(result) {
						break;
					}
				}
			}
		}
		
		return result;
	}
	
	
	private boolean isOutOfIndex(int x, int y) {
		return x < 0 || x >= nodes.length
				|| y < 0 || y >= nodes[x].length;
	}
	
	private void initNodes() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		nodes = new int[x][y];
		visit = new boolean[x][y];
		
		for(int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < y; j++) {
				nodes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}