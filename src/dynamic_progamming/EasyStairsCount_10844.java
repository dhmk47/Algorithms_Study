package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EasyStairsCount_10844 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long result = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;	//1자리 수의 i번째 수가 계단이 되는 경우는 한가지 밖에 없으므로 초기화
		}
		
		for(int i = 2; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				if(j == 0) {		//끝 자리가 0일때는 앞에 올 수 있는 수가 1밖에 없다
					dp[i][j] = dp[i - 1][j + 1] % 1000000000;
				}
				else if(j != dp[i].length - 1) {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}else {				//끝 자리가 9 일때는 앞에 올 수 있는 수가 8밖에 없다
					dp[i][j] = dp[i - 1][j - 1] % 1000000000;
				}
			}
		}
		for(int i = 0; i < dp[N].length; i++) {
			result += dp[N][i];
		}
		bw.write(result % 1000000000 + "");
		bw.flush();
		bw.close();
	}
}