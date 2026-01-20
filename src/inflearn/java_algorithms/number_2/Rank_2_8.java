package inflearn.java_algorithms.number_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Rank_2_8 {
	public static void main(String[] args) {
		Rank_2_8 prc = new Rank_2_8();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			int[] numberArray = new int[count];
			int index = 0;
			
			for(String number : br.readLine().split(" ")) {
				numberArray[index++] = Integer.parseInt(number);
			}
			
			bw.write(prc.solution(count, numberArray));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(int count, int[] numberArray) {
		StringBuilder answer = new StringBuilder();
		
		for(int i = 0; i < count; i++) {
			int rank = 1;
			
			for(int j = 0; j < count; j++) {
				if(i == j) {
					continue;
				}else if(numberArray[i] < numberArray[j]) {
					rank++;
				}
				
			}
			
			if(answer.length() > 0) {
				answer.append(" ");
			}
			answer.append(rank);
		}
		return answer.toString();
	}
}