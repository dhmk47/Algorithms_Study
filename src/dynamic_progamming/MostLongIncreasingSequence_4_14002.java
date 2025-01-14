package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class MostLongIncreasingSequence_4_14002 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		int result = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dp[0] = 1;
		for(int i = 1; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i + 1; j++) {
				if(A[i] > A[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
			}
			result = Math.max(result, dp[i]);
			}
		}
		// 7
		// 9 12 4 38 5 19 21
		// 7
		// 9 12 4 5 11 38 21
		int max = result;
		Stack<Integer> s = new Stack<Integer>();
		for(int i = N - 1; i >= 0; i--) {
			if(max == dp[i]) {		// 최대길이를 찾은경우
				s.push(A[i]);		// push하고
				max--;				// max를 1 감소
			}
		}
		
		
		bw.write(result + "\n");
		while(!s.isEmpty()) {
			bw.write(s.pop() + " ");
		}
		bw.flush();
		bw.close();
	}
}