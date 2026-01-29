package inflearn.java_algorithms.number_6;
import java.io.*;
import java.util.*;
public class CheckDuplicate_6_5 {
	public static void main(String[] args) {
		CheckDuplicate_6_5 prc = new CheckDuplicate_6_5();
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
		String answer = "U";

		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] == arr[j + 1]) {
					return "D";
				}else {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		return answer;
	}
}