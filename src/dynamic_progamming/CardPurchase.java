package dynamic_progamming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardPurchase {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N + 1];
		int[] d = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < N + 1; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < i + 1; j++) {
				d[i] = Math.max(d[i], d[i - j] + card[j]);
			}
		}
		System.out.println(d[N]);
	}
}
