package inflearn.java_algorithms.number_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class InsertionSort_6_3 {
	public static void main(String[] args) {
		InsertionSort_6_3 prc = new InsertionSort_6_3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int number : prc.solution(n, arr)) {
				bw.write(String.valueOf(number) + " ");
			}
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int[] solution(int n, int[] arr) {
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i - j] < arr[i - j - 1]) {
					int temp = arr[i - j];
					arr[i - j] = arr[i - j - 1];
					arr[i - j - 1] = temp;
				}
			}
		}
		return arr;
	}
}