package inflearn.java_algorithms.number_3;
import java.io.*;
import java.util.*;
public class LargestSales_3_3 {
	public static void main(String args[]) {
		LargestSales_3_3 prc = new LargestSales_3_3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			bw.write(String.valueOf(prc.solution_2(n, k, arr)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, int k, int[] arr) {
		int answer = 0;
		int temp = 0;
		
		for(int i = k - 1; i < n; i++) {
			temp = 0;
			for(int j = 0; j < k; j++) {
				temp += arr[i - j];
			}
			
			answer = Math.max(answer, temp);
		}
		
		return answer;
	}
	
	private int solution_2(int n, int k, int[] arr) {
		int answer = 0;
		int temp = 0;
		
		for(int i = 0; i < k; i++) {
			answer += arr[i];
		}
		
		temp = answer;
		for(int i = k; i < n; i++) {
			temp += arr[i];
			temp -= arr[i - k];
			
			answer = Math.max(answer, temp);
		}
		
		return answer;
	}
}