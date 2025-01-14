package dfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Shepherd_3187 {
	String[][] map = null;
	boolean[][] visit = null;
	
	int wolfCount = 0;
	int sheepCount = 0;
	
	int aliveWolfCount = 0;
	int aliveSheepCount = 0;
	
	public static void main(String[] args) {
		Shepherd_3187 prc = new Shepherd_3187();
		prc.run();
		
	}
	
	private void run() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			initMap();
			
			String startPoint = "";
			while(true) {
				startPoint = getStartPoint();
				
//				System.out.println(startPoint);
				if(startPoint.isEmpty()) {
					break;
				}
				
				int moveX = Integer.parseInt(startPoint.split(",")[0]); 
				int moveY = Integer.parseInt(startPoint.split(",")[1]); 
				
				dfs(moveX, moveY);
				
				if(wolfCount >= sheepCount) {
					aliveWolfCount += wolfCount;
				}else if(sheepCount > wolfCount){
					aliveSheepCount += sheepCount;
				}
				
				wolfCount = 0;
				sheepCount = 0;
				
			}
			
			bw.write(aliveSheepCount + " " + aliveWolfCount);
			bw.flush();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getStartPoint() {
		String startPoint = "";
		
		for(int i = 0; i < visit.length; i++) {
			for(int j = 0; j < visit[i].length; j++) {
				if(!visit[i][j]) {
					startPoint = i + "," + j;
					break;
				}
			}
			
			if(!startPoint.isEmpty()) {
				break;
			}
		}
		
		return startPoint;
	}
	
	private void dfs(int moveX, int moveY) {
		if(outOfIndex(moveX, moveY)) {
			return;
		}
		
		if(!visit[moveX][moveY]) {
			visit[moveX][moveY] = true;
			
			String value = map[moveX][moveY];
			
			if(value.equals("#")) { 	  // wall
				return;
			}else if(value.equals("v")) { // wolf
				wolfCount++;
			}else if(value.equals("k")) { // sheep
				sheepCount++;
			}
			
			dfs(moveX, moveY + 1);
			dfs(moveX, moveY - 1);
			dfs(moveX - 1, moveY);
			dfs(moveX + 1, moveY);
		}
	}
	
	private boolean outOfIndex(int moveX, int moveY) {
		return moveX >= map.length || moveY >= map[0].length ||
				moveX < 0 || moveY < 0;
	}
	
	private void initMap() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int xSize = Integer.parseInt(st.nextToken());
		int ySize = Integer.parseInt(st.nextToken());
		
		map = new String[xSize][ySize];
		visit = new boolean[xSize][ySize];
		
		for(int i = 0; i < map.length; i++) {
			String input = br.readLine();
			for(int j = 0; j < input.length(); j++) {
//					map[i][j] = st.nextToken();
				map[i][j] = String.valueOf(input.charAt(j));
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