package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
public class SubsetWithTheSameSum_DFS_8_1 {
	static String answer = "NO";
	static int total = 0;
	static  boolean flag = false;
	public static void main(String[] args) {
		SubsetWithTheSameSum_DFS_8_1 prc = new SubsetWithTheSameSum_DFS_8_1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			total = IntStream.of(arr).sum();
			
			prc.dfs(0, 0, arr);
			bw.write(answer);
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void dfs(int index, int sum, int[] arr) {
		if(flag) {
			return;
		}
		if(sum > total / 2) {
			return;
		}
		if(index == arr.length) {
			if(total - sum == sum) {
				answer = "YES";
				flag = true;
			}
		}else {
			dfs(index + 1, sum + arr[index], arr);
			dfs(index + 1, sum, arr);
		}
	}
};