package inflearn.java_algorithms.number_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BubbleSort_6_2 {
	public static void main(String[] args) {
		BubbleSort_6_2 prc = new BubbleSort_6_2();
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
			int temp = arr[i];
			int j = 0;
			for(j = i - 1; j >= 0; j--) {
				if(arr[j] > temp) {
					arr[j + 1] = arr[j];
				}else {
					break;
				}
			}
			arr[j + 1] = temp;
		}
		return arr;
	}
}