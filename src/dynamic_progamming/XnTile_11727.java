package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class XnTile_11727 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dp = new int[1001];
		int n = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i < n + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}
		bw.write(dp[n] + "");
		bw.flush();
		bw.close();
	}
}