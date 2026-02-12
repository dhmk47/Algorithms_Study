package inflearn.java_algorithms.number_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GettingPermutations_8_6 {
	static int n, m;
	static boolean[] visit;
	static int[] answer;
	static BufferedWriter bw;
	public static void main(String[] args) {
		GettingPermutations_8_6 prc = new GettingPermutations_8_6();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = new int[m];
			visit = new boolean[n];
			prc.dfs(0, arr);
			
			bw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int index, int[] arr) throws Exception {
		if(index == m) {
			for(int num : answer) bw.write(num + " ");
			bw.write("\n");
		}else {
			for(int i = 0; i < n; i++) {
				if(!visit[i]) {
					answer[index] = arr[i];
					
					visit[i] = true;
					dfs(index + 1, arr);
					visit[i] = false;
				}
			}
		}
	}
}