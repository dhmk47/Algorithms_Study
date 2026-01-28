package inflearn.java_algorithms.number_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class LeastRecentlyUsed_Cache_6_4 {
	public static void main(String[] args) {
		LeastRecentlyUsed_Cache_6_4 prc = new LeastRecentlyUsed_Cache_6_4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int number : prc.solution(s, n, arr)) {
				bw.write(String.valueOf(number) + " ");
			}
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int[] solution(int s, int n, int[] arr) {
		int[] answer = new int[s];
		Queue<Integer> q = new LinkedList<>();
		
		for(int number : arr) {
			if(q.contains(number)) {
				Queue<Integer> temp = new LinkedList<>();
				
				for(int tempNumber : q) {
					if(tempNumber != number) {
						temp.offer(tempNumber);
					}
				}
				q = temp;
			}
			q.offer(number);
			if(q.size() > s) {
				q.poll();
			}
		}
		for(int i = 0; i < s; i++) {
			answer[s - i - 1] = q.poll();
		}
		return answer;
	}
}