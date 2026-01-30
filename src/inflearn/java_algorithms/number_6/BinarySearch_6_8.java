package inflearn.java_algorithms.number_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BinarySearch_6_8 {
	public static void main(String[] args) {
		BinarySearch_6_8 prc = new BinarySearch_6_8();
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
		int lt = 0;
		int rt = arr.length - 1;
		
		for(int i = 0; i < n - 1; i++) {
			int index = i;
			for(int j = i + 1; j < n; j++) {
				if(arr[j] < arr[index]) {
					index = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			
			if(arr[mid] == m) {
				return mid + 1;
			}
			if(arr[mid] > m) {
				rt = mid - 1;
			}else {
				lt = mid + 1;
			}
		}
		
		return answer;
	}
}