package dfs;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Infiltration_13565 {
	private char[][] map;
	private boolean[][] visit;
	private int[] dx = {1, 0, -1, 0};
	private int[] dy = {0, 1, 0, -1};
	private boolean success = false;;
	
	public static void main(String[] args) {
		Infiltration_13565 prc = new Infiltration_13565();
		prc.run();
	}

	private void run() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String result = "NO";
		try {
			initMap();
			
			for(int y = 0; y < map[0].length; y++) {
				if(!isOutOfIndex(0, y) && !visit[0][y] && !success) {
					dfs(0, y);
					if(success) {
						result = "YES";
						break;
					}
				}
			}
			
			bw.write(result);
			bw.flush();
			bw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean dfs(int x, int y) {
		boolean pass = false;
		
		if(isOutOfIndex(x, y) || visit[x][y] || map[x][y] == '1' || success) {
			return pass;
		}
		
		pass = true;
		visit[x][y] = true;
		
		if(x == (map.length - 1)) {
			success = pass;
			return success;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			pass = dfs(nx, ny);
		}
		
		
		return pass;
	}
	
	private boolean isOutOfIndex(int x, int y) {
		return x < 0 || x >= map.length
				|| y < 0 || y >= map[x].length;
	}
	
	private void initMap() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		map = new char[x][y];
		visit = new boolean[x][y];
		
		for(int i = 0; i < x; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}
}