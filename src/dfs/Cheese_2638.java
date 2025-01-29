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
	
	��� ũ�⸦ ��ȸ�ϸ鼭 �����ڸ� ���� dfs�� Ž�� �� 2���� �̻��� 0�ΰ��� ����� ���� 0���� ���� ��� ��� ���Ҵٸ� ī��Ʈ +1
	�� �̶� 2���� �� 0�� �ִٸ� �ش� ��带 Ž���Ѵ� -> Ž���ؼ� x��� y���� �ε��� 0������ ���� ���Ѵٸ� �����ִ� ����� ġ� 0���� �ٲ��� �ʴ´� (�����ڸ����� ġ� ������ �� ����)
	
	
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
				// ���������� ������ �����ִ� �������� Ȯ���� �ʿ��մϴ�.
				if(nodes[nx][ny] == 0) {
					if(checkAir(nx, ny, new boolean[visit.length][visit[nx].length])) {
						airCount++;
					}
				}else {
					// ��� Ž���ϸ鼭 2������ ������ 1 -> 0���� �ٲٴ� �۾��Դϴ�.
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
			
			// ���� �ʰ��ϸ� �����ڸ� ���� �Դٰ� �Ǵ� -> �����ִ� ���Ⱑ �ƴմϴ�.
			// ���尡�ڸ��� ġ� ������ �� ���ٴ� ������ ����
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