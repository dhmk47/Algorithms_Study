package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PinaryNumber_2193 {
	public static void main(String[] args) throws IOException{
		
		/*
			1

			10
			
			100
			101
			
			1001
			1010
			1000
			
			10010
			10101
			10001
			10000
			10100
			
			5의 이친수를 구하는 방법 ->
			4의 이친수에서 1로 끝나는 경우에서 0을 하나 붙여줍니다.
			ㄴ + 1
			0으로 끝나는 경우에서 1을 붙여줍니다. 그리고 0은 연속해서 와도 되기 때문에 0도 붙여줍니다.
			3의 이친수중에 0으로 끝나는 경우가 총 2개
			1을 붙인 경우 +2
			0을 붙인 경우 +2
			
			총 5개
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[91][2];
		// 이친수의 조건은 1이 연속으로 나오지않고 0으로 시작하지않는 조건
		dp[1][1] = 1;		// 1자리수 에서 0으로 끝나는 경우 : 1
		dp[2][0] = 1;		// 2자리수 에서 0로 끝나는 경우 : 10
		dp[2][1] = 0;		// 2자리수 에서 1로 끝나는 경우 : 없음
		
		for(int i = 3; i < N + 1; i++) {
			dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
			dp[i][1] = dp[i - 1][0];
		}
		
		bw.write(dp[N][0] + dp[N][1] + "");
		bw.flush();
		bw.close();
	}
}