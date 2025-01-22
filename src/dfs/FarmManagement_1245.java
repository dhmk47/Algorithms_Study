package dfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FarmManagement_1245 {
	private int[][] map;
	private boolean[][] visit;
	
	// 8����
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
	 * (1,2) -> ���̰� 3�ε� ������ ���� ���̿� �� 8������ �˻��ؾ� ������ (1,1)�� (0,1)���� �ѹ� �ٳ�ͼ� ���� �� �� -> ���� ���� ��� �������� ���� ������ ��尡 �ִٸ� 8���� üũ�� �ٽ� ���� �� ��
	 * �ش� ��尡 ����츮���� ���� üũ�� �ϰ� ����츮��� ����츮 ��带 �湮�ϸ鼭 visit = true�� �湮ó��
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
			
			// 8������ �ڽź��� ���� ���ڰ� �ִ°�� �ش� ���� ����츮�� �ƴ��� ǥ��. -> false ����
			if(map[nx][ny] > height) {
				result = false;
			}else if(height == map[nx][ny]){
				// ���� ������ ��� �ϳ��� ���츮�̹Ƿ� ���� ����� 8���⵵ Ȯ�� �ʿ�
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