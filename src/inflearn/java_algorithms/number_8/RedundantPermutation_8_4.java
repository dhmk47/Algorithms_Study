package inflearn.java_algorithms.number_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RedundantPermutation_8_4 {
	static int n, m;
	static List<Integer> answer = new ArrayList<>();
	public static void main(String[] args) {
		RedundantPermutation_8_4 prc = new RedundantPermutation_8_4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[] arr = new int[m];
			
			prc.dfs(0, arr);
			
			for(int num : answer) {
				bw.write(String.valueOf(num) + " ");
			}
			bw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int index, int[] arr) {
		if(index == m) {
			for(int num : arr) answer.add(num);
		}else {
			for(int i = 1; i <= n; i++) {
				arr[index] = i;
				dfs(index + 1, arr);
			}
		}
	}
}