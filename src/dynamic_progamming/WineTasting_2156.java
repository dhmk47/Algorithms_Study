package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WineTasting_2156 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = wine[0];
		dp[1] = wine[1];
		
		for(int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i]));
		}
		
		
		bw.write(dp[n] + "");
		bw.flush();
		bw.close();
	}
}
