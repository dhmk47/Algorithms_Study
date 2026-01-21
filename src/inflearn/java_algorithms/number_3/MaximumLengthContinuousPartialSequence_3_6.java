package inflearn.java_algorithms.number_3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MaximumLengthContinuousPartialSequence_3_6 {
	
	public static void main(String[] args) {
		MaximumLengthContinuousPartialSequence_3_6 prc = new MaximumLengthContinuousPartialSequence_3_6();
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
			
			bw.write(String.valueOf(prc.solution(n, k, arr)));
			bw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private int solution(int n, int k, int[] arr) {
		int answer = 0;
		int count = 0;
		
		int lt = 0;
		int rt = 0;
		while(lt < n && rt < n) {
			if(arr[rt++] == 0) {
				if(count == k) {
					answer = Math.max(answer, (rt - 1) - lt);
					
					while(count == k) {
						if(arr[lt++] == 0) {
							count--;
						}
					}
				}
				
				count++;
			}
		}
		
		return answer;
	}
	
	private int solution_2(int n, int k, int[] arr) {
		int answer = 0;
		int count = 0;
		
		int lt = 0;
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt] == 0) {
				count++;
			}
			while(count > k) {
				if(arr[lt] == 0) {
					count--;
				}
				lt++;
			}
			
			answer = Math.max(answer, rt - lt + 1);
		}
		return answer;
	}
}