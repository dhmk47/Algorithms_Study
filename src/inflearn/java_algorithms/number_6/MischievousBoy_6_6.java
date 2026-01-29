package inflearn.java_algorithms.number_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MischievousBoy_6_6 {
	public static void main(String[] args) {
		MischievousBoy_6_6 prc = new MischievousBoy_6_6();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(prc.solution(n, arr));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(int n, int[] arr) {
		String answer = "";
		int[] temp = arr.clone();
		
		for(int i = 1; i < n; i++) {
			int number = arr[i];
			int j = 0;
			for(j = i - 1; j >= 0; j--) {
				if(temp[j] > number) {
					temp[j + 1] = temp[j];
				}else {
					break;
				}
			}
			temp[j + 1] = number;
		}
		
		for(int i = 0; i < n; i++) {
			if(arr[i] != temp[i]) {
				answer += i + 1 + " ";
			}
		}
		
		return answer;
	}
}