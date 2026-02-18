package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
public class NumberOfCombinations_Memoization_8_7 {
	static int[][] check;
	public static void main(String[] args) {
		NumberOfCombinations_Memoization_8_7 prc = new NumberOfCombinations_Memoization_8_7();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n + 1][n + 1];
			check = new int[n + 1][n + 1];
			
			bw.write(String.valueOf(prc.dfs(n, r, arr)));
			bw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int dfs(int n, int r, int[][] arr) {
		if(check[n][r] > 0) {
			return check[n][r];
		}else {
			if(r == 0 || n == r) {
				return 1;
			}
			return check[n][r] = dfs(n - 1, r - 1, arr) + dfs(n - 1, r, arr);
		}
	}
}