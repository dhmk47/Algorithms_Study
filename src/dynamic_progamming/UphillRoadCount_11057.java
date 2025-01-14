package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UphillRoadCount_11057 {
	public static void main(String[] args) throws IOException{
		/*
		 * 	N이 1일경우
		 * 	0 1 2 3 4 5 6 7 8 9
		 * 
		 * 	N이 2일경우
		 * 	00 01 02 03 04 05 06 07 08 09
			11 12 13 14 15 16 17 18 19
			22 23 24 25 26 27 28 29
			33 34 35 36 37 38 39
			44 45 46 47 48 49
			55 56 57 58 59
			66 67 68 69
			77 78 79
			88 89
			99
			
			0에 0부터 9까지 더하고
			1에 1부터 9까지
			2에 2부터 9까지
			...
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i < N + 1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][j] += dp[i - 1][k] % 10007;
				}
			}
		}
		
		long result = 0;
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		bw.write(result % 10007 + "");
		bw.flush();
		bw.close();
	}
}