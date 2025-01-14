package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Sticker_9465 {
	public static void main(String[] args) throws IOException{
		/*
		 * dp를 해당 칸이라고 생각하자
		 * 예를 들어 dp[0][3] 라면 0번째 줄의 3번째 '해당' 칸이라고 생각하자 <- 중요!
		 * 그래서 그 해당칸에서의 최대값을 저장해 놓는다고 생각해야 dp문제를 풀때 복잡하지 않다
		 * 
		 * 그렇다면 0번째줄의 3번째 칸에서의 최대값은 01, 11, 03 의 값과
		 * 11, 03 의 값중 큰 값이 03 칸에 대입 될 것이다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());	// 갯수
			
			long[][] cost = new long[2][n + 1];
			long[][] dp = new long[2][n + 1];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for(int j = 1; j < n + 1; j++) {
				cost[0][j] = Long.parseLong(st1.nextToken());		// 가격 대입
				cost[1][j] = Long.parseLong(st2.nextToken());
			}
		
			dp[0][1] = cost[0][1];
			dp[1][1] = cost[1][1];
			
			
			for(int j = 2; j < n + 1; j++) {
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + cost[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + cost[1][j];
			}
			bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
			bw.flush();
			
		}
	}
}