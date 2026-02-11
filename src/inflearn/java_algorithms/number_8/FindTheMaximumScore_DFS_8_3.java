package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
public class FindTheMaximumScore_DFS_8_3 {
	static int n, m, answer;
	public static void main(String[] args) {
		FindTheMaximumScore_DFS_8_3 prc = new FindTheMaximumScore_DFS_8_3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			prc.dfs(0, 0, 0, arr);
			
			bw.write(String.valueOf(answer));
			bw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int index, int scoreSum, int timeSum, int[][] arr) {
		if(timeSum > m) {
			return;
		}
		if(index >= n) {
			answer = Math.max(scoreSum, answer);
		}else {
			dfs(index + 1, scoreSum + arr[index][0], timeSum + arr[index][1], arr);
			dfs(index + 1, scoreSum, timeSum, arr);
		}
	}
}