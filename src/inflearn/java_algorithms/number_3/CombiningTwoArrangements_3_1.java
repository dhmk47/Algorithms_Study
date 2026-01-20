package inflearn.java_algorithms.number_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CombiningTwoArrangements_3_1 {
	public static void main(String[] args) {
		CombiningTwoArrangements_3_1 prc = new CombiningTwoArrangements_3_1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] firstArray = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < n; i++) {
				firstArray[i] = Integer.parseInt(st.nextToken());
			}
			
			int m = Integer.parseInt(br.readLine());
			int[] secondArray = new int[m];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < m; i++) {
				secondArray[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(prc.solution(n, m, firstArray, secondArray));
			bw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(int n, int m, int[] firstArray, int[] secondArray) {
		StringBuilder answer = new StringBuilder();
		int p1 = 0;
		int p2 = 0;
		
		while(p1 < n && p2 < m) {
			if(firstArray[p1] < secondArray[p2]) {
				answer.append(firstArray[p1++] + " ");
			}else {
				answer.append(secondArray[p2++] + " ");
			}
		}
		
		while(p1 < n) {
			answer.append(firstArray[p1++] + " ");
		}
		while(p2 < m) {
			answer.append(secondArray[p2++] + " ");
		}
		
		return answer.toString().trim();
	}
}