package inflearn.java_algorithms.number_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ContinuousPartialSequence_3_4 {
	public static void main(String args[]) {
		ContinuousPartialSequence_3_4 prc = new ContinuousPartialSequence_3_4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			bw.write(String.valueOf(prc.solution(n, m, arr)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, int m, int[] arr) {
		int answer = 0;
		int sum = 0;
		
		int p1 = 0;
		int p2 = 0;
		for(int i = 0; i < n; i++) {
			sum += arr[p2++];
			
			while(sum > m) {
				sum -= arr[p1++];
			}
			if(sum == m) {
				answer++;
			} 
		}
		return answer;
	}
}