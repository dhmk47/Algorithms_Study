package dynamic_progamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Add123_5_15990 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 3;
			dp[4] = 3;
			for(int j = 1; j < n + 1; j++) {
				
			}
			
		}
	}
}