package inflearn.java_algorithms.number_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BadookgiRiding_DFS_8_2 {
	static int c;
	static int answer;
	
	public static void main(String[] args) {
		BadookgiRiding_DFS_8_2 prc = new BadookgiRiding_DFS_8_2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			prc.dfs(0, 0, arr);
			
			bw.write(String.valueOf(answer));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void dfs(int index, int sum, int[] arr) {
		if(sum > c) return;
		if(answer == c) return;
		if(index == arr.length) {
			answer = Math.max(answer, sum);
		}else {
			dfs(index + 1, sum + arr[index], arr);
			dfs(index + 1, sum, arr);
		}
	}
}