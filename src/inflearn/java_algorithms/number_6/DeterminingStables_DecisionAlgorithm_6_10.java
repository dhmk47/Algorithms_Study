package inflearn.java_algorithms.number_6;
import java.io.*;
import java.util.*;

public class DeterminingStables_DecisionAlgorithm_6_10 {
	public static void main(String[] args) {
		DeterminingStables_DecisionAlgorithm_6_10 prc = new DeterminingStables_DecisionAlgorithm_6_10();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(String.valueOf(prc.solution(n, c, arr)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, int c, int[] arr) {
		int answer = Integer.MIN_VALUE;
		bubbleSort(arr);
		
		int lt = 1;
		int rt = arr[n - 1];
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			
			int count = 1;
			int point = arr[0];
			for(int i = 1; i < n; i++) {
				if(arr[i] - point >= mid) {
					count++;
					point = arr[i];
				}
			}

			System.out.println("count >> " + count);
			System.out.println("mid >> " + mid);
			if(count >= c) {
				lt = mid + 1;
//				answer = mid;
				if(count == c && answer < mid) {
					answer = mid;
				}
			}else {
				rt = mid - 1;
			}
		}
		
		
		return answer;
	}
	
	private void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}