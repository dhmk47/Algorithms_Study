package inflearn.java_algorithms.number_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FibonacciSequence_2_4 {
	public static void main(String[] args) {
		FibonacciSequence_2_4 prc = new FibonacciSequence_2_4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(prc.solution(Integer.parseInt(br.readLine())));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(int count) {
		StringBuilder answer = new StringBuilder();
		int[] numberArray = new int[count];
		numberArray[0] = 1;
		numberArray[1] = 1;
		
		for(int i = 2; i < count; i++) {
			numberArray[i] = numberArray[i - 1] + numberArray[i - 2];
		}
		
		for(int i = 0; i < count; i++) {
			if(answer.length() > 0) {
				answer.append(" ");
			}
			answer.append(numberArray[i]);
		}
		return answer.toString();
	}
}