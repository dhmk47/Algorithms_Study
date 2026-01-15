package inflearn.java_algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RockPaperScissors_2_3 {
	int[][] winMap = {	{0, 0}
	  				  , {1, 3}
					  , {2, 1}
					  , {3, 2}
					  };
	public static void main(String[] args) {
		RockPaperScissors_2_3 prc = new RockPaperScissors_2_3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			int[] userA = new int[count];
			int[] userB = new int[count];
			
			String[] tempArray = br.readLine().split(" ");
			for(int i = 0; i < count; i++) {
				userA[i] = Integer.parseInt(tempArray[i]);
			}
			
			tempArray = br.readLine().split(" ");
			for(int i = 0; i < count; i++) {
				userB[i] = Integer.parseInt(tempArray[i]);
			}
			
			bw.write(prc.solution(count, userA, userB));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(int count, int[] userA, int[] userB) {
		StringBuilder answer = new StringBuilder();
		
		for(int i = 0; i < count; i++) {
			if(answer.length() > 0) {
				answer.append("\n");
			}
			
			if(userA[i] == userB[i]) {
				answer.append("D");
			}else if(winMap[userA[i]][1] ==  userB[i]) {
				answer.append("A");
			}else {
				answer.append("B");
			}
		}
		
		return answer.toString();
	}
}