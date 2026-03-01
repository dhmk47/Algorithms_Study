package inflearn.java_algorithms.number_9;
import java.io.*;
import java.util.*;

class Player {
	int height, weight;
	
	Player(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
}
public class KoreanWrestlingPlayer_9_1 {
	static int n;
	public static void main(String[] args) {
		KoreanWrestlingPlayer_9_1 prc = new KoreanWrestlingPlayer_9_1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			n = Integer.parseInt(br.readLine());
			List<Player> playerList = new ArrayList<>();

			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int height = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				
				playerList.add(new Player(height, weight));
			}
			
			bw.write(String.valueOf(prc.solution(n, playerList)));
			bw.flush();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, List<Player> playerList) {
		int answer = 0;
		playerList.sort(Comparator.comparingInt((Player player) -> player.height).reversed());
		
		int maxWeight = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			if(playerList.get(i).weight > maxWeight) {
				answer++;
				maxWeight = playerList.get(i).weight;
			}
		}
		
		return answer;
	}
}