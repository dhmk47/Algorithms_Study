package inflearn.java_algorithms.number_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class MusicVideo_DecisionAlgorithm_6_9 {
	public static void main(String[] args) {
		MusicVideo_DecisionAlgorithm_6_9 prc = new MusicVideo_DecisionAlgorithm_6_9();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(String.valueOf(prc.solution(n, m, arr)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, int m, int[] arr) {
		int answer = 0;
		int loopSize = IntStream.of(arr).sum();
		
		int[] map = new int[loopSize];
		for(int i = 0; i < loopSize; i++) {
			map[i] = i + 1;
		}
		
		int lt = 0;
		int rt = map.length - 1;
		int min = Integer.MAX_VALUE;
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			
			int sum = 0;
			int size = map[mid];
			int count = 0;
			
			for(int num : arr) {
				if(count > m) {
					lt = mid + 1;
					break;
				}
				
				if(sum + num <= size) {
					sum += num;
				}else {
					sum = num;
					count++;
				}
			}
			
			if(sum > 0) {
				count++;
			}
			
			if(count <= m) {
				rt = mid - 1;
				
				if(min > size) {
					min = size;
				}
			}else {
				lt = mid + 1;
			}
		}
		
		answer = min;
		
		return answer;
	}
}