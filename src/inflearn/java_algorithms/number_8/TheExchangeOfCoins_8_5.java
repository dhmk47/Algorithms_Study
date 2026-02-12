package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
public class TheExchangeOfCoins_8_5 {
	static int n, m, answer = Integer.MAX_VALUE;
	static boolean[] visit;
	static int[] check;
	public static void main(String[] args) {
		TheExchangeOfCoins_8_5 prc = new TheExchangeOfCoins_8_5();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			n = Integer.parseInt(br.readLine());
//			Integer[] arr = new Integer[n];
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			m = Integer.parseInt(br.readLine());
			visit = new boolean[600];
			check = new int[600];
			
//			Arrays.sort(arr, Collections.reverseOrder());
//			prc.dfs(arr);
			prc.bfs(arr);
			
			bw.write(String.valueOf(answer));
			bw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void bfs(int[] arr) {
		Queue<Integer> q = new LinkedList<>();
		for(int nx : arr) {
			visit[nx] = true;
			check[nx] = 1;
			q.offer(nx);
		}
		
		while(!q.isEmpty()) { 
			int currentNumber = q.poll();
			for(int i = 0; i < n; i++) {
				int nx = arr[i];
				
				if(currentNumber + nx == m) {
					answer = check[currentNumber] + 1;
					return;
				}
				if(!visit[currentNumber + nx]) {
					visit[currentNumber + nx] = true;
					check[currentNumber + nx] = check[currentNumber] + 1;
					q.offer(currentNumber + nx);
				}
			}
			
		}
		
	}
	
	private void dfs(int sum, int count, int[] arr) {
		if(sum > m) {
			return;
		}
		if(count >= answer) {
			return;
		}
		if(sum == m) {
			answer = Math.min(answer, count);
		}else {
			for(int i = 0; i < n; i++) {
				dfs(sum + arr[i], count + 1, arr);
			}
		}
	}
}