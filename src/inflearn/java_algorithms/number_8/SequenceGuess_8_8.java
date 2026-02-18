package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
public class SequenceGuess_8_8 {
	static int n, f;
	static int[][] memoizationArray;
	static int[] combiArray;
	static int[] sequenceArray;
	static int[] checkArray;
	static BufferedWriter bw;
	static boolean flag;
	public static void main(String[] args) {
		SequenceGuess_8_8 prc = new SequenceGuess_8_8();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());
			memoizationArray = new int[n + 1][n + 1];
			checkArray = new int[n + 1];
			combiArray = new int[n];
			sequenceArray = new int[n];

			for(int i = 0; i < n; i++) {
				combiArray[i] = prc.makeCombiArray(n - 1, i);
			}
			
			prc.dfs(0, 0);
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int index, int sum) throws Exception {
		if(flag) {
			return;
		}
		if(index == n) {
			if(sum == f) {
				for(int num : sequenceArray) {
					bw.write(num + " ");
				}
				flag = true;
				return;
			}
		}else {
			for(int i = 1; i <= n; i++) {
				if(checkArray[i] == 0) {
					checkArray[i] = 1;
					sequenceArray[index] = i;
					dfs(index + 1, sum + (sequenceArray[index] * combiArray[index]));
					checkArray[i] = 0;
				}
			}
		}
	}
	
	private int makeCombiArray(int n, int r) {
		if(memoizationArray[n][r] > 0) {
			return memoizationArray[n][r];
		}else {
			if(r == 0 || n == r) {
				return 1;
			}
			return memoizationArray[n][r] = makeCombiArray(n - 1, r - 1) + makeCombiArray(n - 1, r);
		}
	}
}