package dfs;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class OneSheepAndTwoSheep_11123 {
	private boolean[][] visit;
	private String[][] map;
	private int sheepHerdCount;
	private int[] dx = {1, 0, -1, 0};
	private int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		OneSheepAndTwoSheep_11123 prc = new OneSheepAndTwoSheep_11123();
		prc.run();
	}
	
	private void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int testCase = Integer.parseInt(br.readLine());
			for(int i = 0; i < testCase; i++) {
				sheepHerdCount = 0;
				initMap(br);
				
				for(int x = 0; x < map.length; x++) {
					for(int y = 0; y < map[x].length; y++) {
						// dfs 메서드 들어가기 전에 방문체크와 양인지 체크를 먼저 해도 좋을 듯
						if(dfs(x, y)) {
							sheepHerdCount++;
						}
					}
				}
				
				bw.write(String.valueOf(sheepHerdCount) + "\n");
			}
			bw.flush();
			bw.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean dfs(int x, int y) {
		boolean isSheep = false;
		
		if(isOutOfIndex(x, y) || visit[x][y] || map[x][y].equals(".")) {
			return isSheep;
		}
		
		visit[x][y] = true;
		
		if(map[x][y].equals("#")) {
			isSheep = true;
		}
		
		for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny);
        }
		
//		dfs(x, y + 1);
//		dfs(x, y - 1);
//		dfs(x - 1, y);
//		dfs(x + 1, y);
		
		return isSheep;
	}
	
	private boolean isOutOfIndex(int x, int y) {
		return x < 0 || x >= map.length
				|| y < 0 || y >= map[x].length;
	}
	
	private void initMap(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		map = new String[x][y];
		visit = new boolean[x][y];
		
		for(int i = 0; i < x; i++) {
			String input = br.readLine();
			for(int j = 0; j < y; j++) {
				map[i][j] = String.valueOf(input.charAt(j));
			}
		}
	}
}