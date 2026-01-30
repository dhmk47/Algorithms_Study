package inflearn.java_algorithms.number_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class MusicVideo_DecisionAlgorithm_6_9 {
	public static void main(String[] args) {
		MusicVideo_DecisionAlgorithm_6_9 prc = new MusicVideo_DecisionAlgorithm_6_9();
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
		int ltSum = arr[0];
		int rtSum = arr[n - 1];
		int lt = 0;
		int rt = n - 1;
		
		sum = IntStream.of(arr).sum();
		
		Arrays.sort(arr);
		
		while(lt <= rt) {
			int max = Math.max(ltSum, rtSum);
			if(sum - ltSum - rtSum < max) {
				answer = max;
				break;
			}else if(ltSum + arr[lt + 1] < rtSum + arr[rt - 1]){
				lt++;
				ltSum += arr[lt];
			}else {
				rt--;
				rtSum += arr[rt];
			}
		}
		
		
		return answer;
	}
}