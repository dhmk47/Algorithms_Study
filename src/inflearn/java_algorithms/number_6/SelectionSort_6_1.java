package inflearn.java_algorithms.number_6;
import java.io.*;
import java.util.StringTokenizer;
public class SelectionSort_6_1 {
	public static void main(String[] args) {
		SelectionSort_6_1 prc = new SelectionSort_6_1();
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
		for(int i = 0; i < n; i++) {
			int index = i;
			
			for(int j = i + 1; j < n; j++) {
				if(arr[j] < arr[index]) {				// 제일 작은거 찾기
					index = j;
				}
			}
			
			if(arr[i] > arr[index]) {					// 찾은게 arr[i]보다 작으면 교촤
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
		
		return arr;
	}
	
	private int[] solution_2(int n, int[] arr) {
		for(int i = 0; i < n - 1; i++) {
			int index = i;
			
			for(int j = i + 1; j < n; j++) {
				if(arr[j] < arr[index]) {				// 제일 작은거 찾기
					index = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		return arr;
	}
}