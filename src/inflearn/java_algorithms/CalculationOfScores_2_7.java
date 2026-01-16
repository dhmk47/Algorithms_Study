package inflearn.java_algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CalculationOfScores_2_7 {
	public static void main(String[] args) {
		CalculationOfScores_2_7 prc = new CalculationOfScores_2_7();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			int[] numberArray = new int[count + 1];
			int index = 1;
			
			for(String number : br.readLine().split(" ")) {
				numberArray[index++] = Integer.parseInt(number);
			}
			
			bw.write(prc.solution(count, numberArray) + "");
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int count, int[] numberArray) {
		int answer = 0;
		int[] scoreArray = new int[count + 1];
		
		for(int i = 1; i < numberArray.length; i++) {
			if(numberArray[i] == 1) {
				scoreArray[i] = scoreArray[i - 1] + 1;
				answer += scoreArray[i];
			}else {
				scoreArray[i] = 0;
			}
		}
		
		return answer;
	}
}