package inflearn.java_algorithms.number_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 소수 구하기 (에라토스테네스 체)
public class Minority_2_5 {
	public static void main(String[] args) {
		Minority_2_5 prc = new Minority_2_5();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(prc.solution(Integer.parseInt(br.readLine())) + "");
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int count) {
		int answer = 0;
		int[] numberArray = new int[count + 1];			// 처음엔 전부 0

		for(int i = 2; i < count; i++) {				// 1은 소수가 아니기 때문에 2부터 시작
			if(numberArray[i] == 0) {					// 0이면 소수
				answer++;
			}
			
			for(int j = i; j <= count; j = j + i) {		// 나 자신의 배수는 전부 1로 처리
				numberArray[j] = 1;
			}
		}
		
		return answer;
	}
}