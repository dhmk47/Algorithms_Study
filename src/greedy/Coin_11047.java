package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin_11047 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		int value = 0;
		for(int i = 0; i < N; i++) {
			coin[(N - 1) - i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			if(coin[i] > K) continue; // 현재 금액보다 크다면 continue
			value += K / coin[i]; // 나눈값이 결과가 되기때문에 value에 누적대입
			K = K % coin[i]; // 나눈값의 나머지를 K에 대입
			if(K == 0) break;
		}
		System.out.println(value);
	}
}
