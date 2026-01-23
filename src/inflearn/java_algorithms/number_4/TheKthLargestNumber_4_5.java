package inflearn.java_algorithms.number_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TheKthLargestNumber_4_5 {
	public static void main(String[] args) {
		TheKthLargestNumber_4_5 prc = new TheKthLargestNumber_4_5();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			Integer[] arr = new Integer[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			bw.write(String.valueOf(prc.solution(n, k, arr)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private int solution(int n, int k, Integer[] arr) {
		int answer = -1;
		
		TreeSet<Integer> tSet = new TreeSet<Integer>(Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int o = j + 1; o < n; o++) {
					tSet.add(arr[i] + arr[j] + arr[o]);
				}
			}
		}
		
		int count = 0;
		for(int number : tSet) {
			count++;
			
			if(count == k) {
				return number;
			}
		}
		
		return answer;
	}
}