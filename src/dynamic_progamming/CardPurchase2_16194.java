package dynamic_progamming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CardPurchase2_16194 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) {
			card[i] = Integer.parseInt(st.nextToken());		// 카드 가격 입력
		}
		
		
		for(int i = 1; i < N + 1; i++) {
			dp[i] = card[i];		// min을 사용하기 때문에 초기의 값을 계속해서 초기화
			for(int j = 1; j < i + 1; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + card[j]);		// 초기화 된 값과 계산된 값중 작은 값을 대입
			}
		}
		
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
	}
}