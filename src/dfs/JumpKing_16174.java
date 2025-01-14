package dfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JumpKing_16174 {
	int nodeSize = 0;
	int[][] map = null;
	boolean[][] visit = null;
	boolean pass = false;
	
	public static void main(String[] args) {
		JumpKing_16174 prc = new JumpKing_16174();
		prc.run();
	}
	
	private void run() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String result = "Hing";
		try {
			initMap();
			
			int jumpValue = map[0][0];
			
			dfs(0, 0 + jumpValue);
			dfs(0 + jumpValue, 0);
			
			if(pass) {
				result = "HaruHaru";
			}
			
			bw.write(result);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int moveX, int moveY) {
		if(outOfIndex(moveX, moveY) || pass) {
			return;
		}
		
		if(!visit[moveX][moveY]) {
			visit[moveX][moveY] = true;
			
			int jumpValue = map[moveX][moveY];
			
			pass = jumpValue == -1 ? true : false;
			
			if(pass) {
				return;
			}
			dfs(moveX, moveY + jumpValue);
			dfs(moveX + jumpValue, moveY);
		}
	
	}
	
	private boolean outOfIndex(int moveX, int moveY) {
		return moveX >= nodeSize || moveY >= nodeSize;
	}
	
	private void initMap() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nodeSize = Integer.parseInt(br.readLine());
		
		map = new int[nodeSize][nodeSize];
		visit = new boolean[nodeSize][nodeSize];
		
		for(int i = 0; i < nodeSize; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < nodeSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
//	private void printLog() {
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}
}