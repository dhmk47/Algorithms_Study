package dynamic_progamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Add123_9095 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[10000];
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			for(int j = 4; j < N + 1; j++) {
				dp[j] = (dp[j - 3] + dp[j - 2]) + dp[j - 1];
			}
			System.out.println(dp[N]);
		}
	}
}
