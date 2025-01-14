package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class XnTile_11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 2];
		
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < n + 1; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
		}
		bw.write(dp[n] + "");
		bw.flush();
		bw.close();
	}
}