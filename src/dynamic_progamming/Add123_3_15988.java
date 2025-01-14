package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Add123_3_15988 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			long[] dp = new long[n + 2];
			dp[0] = 1;
			dp[1] = 2;
			dp[2] = 4;
			// 4라고 가정하면 3인 경우의 모든 수에 1씩 더하면 되고
			// 2의 경우의 모든 수에 2씩 더하면 되고
			// 1의 경우의 모든 수에 3씩 더하면 됩니다.
			// 예)1의 경우의 수: 1 -> 1 3
			// 예)2의 경우의 수: 2 -> 2 2 / 1 1 -> 1 1 2
			// 예)3의 경우의 수: 1 1 1 -> 1 1 1 1 / 1 2 -> 1 2 1 / 2 1 -> 2 1 1 / 3 -> 3 1
			for(int j = 3; j < n; j++) {
				dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
			}
			bw.write(dp[n - 1] + "\n");
//			dp[0][0] = 1;
//			dp[0][1] = 0;
//			dp[0][2] = 0;
//			dp[1][0] = 1;
//			dp[1][1] = 1;
//			dp[1][2] = 0;
//			dp[2][0] = 2;
//			dp[2][1] = 1;
//			dp[2][2] = 1;
//			for(int j = 3; j < n; j++) {
//				dp[j][0] = dp[j - 1][0] + dp[j - 1][1] + dp[j - 1][2];
//				dp[j][1] = dp[j - 2][0] + dp[j - 2][1] + dp[j - 2][2];
//				dp[j][2] = dp[j - 3][0] + dp[j - 3][1] + dp[j - 3][2];
//			}
//			bw.write(dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2] + "\n");
			bw.flush();
		}
	}
}