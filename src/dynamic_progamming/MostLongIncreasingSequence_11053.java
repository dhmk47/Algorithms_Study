package dynamic_progamming;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class MostLongIncreasingSequence_11053 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 수열의 개수
		int[] A = new int[N];					// 수열
		int[] dp = new int[N];
		int result = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		for(int i = 1; i < N; i++) {
			dp[i] = 1;						// 초기값은 1
			for(int j = 0; j < i; j++) {	// 처음부터 비교
				if(A[i] > A[j] && dp[i] <= dp[j]) {	// 값이 크고 i 인덱스의 dp값이 j의 인덱스보다 작을때만 조건 성립 dp가 3인데 dp 1을 만나 2가 되는경우를 방지
					dp[i] = dp[j] + 1;				// j에서 +1
				}
			}
			result = Math.max(result, dp[i]);		// result의 값과 현재dp의 값중 큰 값을 대입
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}
}