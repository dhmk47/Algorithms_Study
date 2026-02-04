package inflearn.java_algorithms.number_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FabonacciRecursive_7_4 {
	private static int[] fibo;
	public static void main(String[] args) {
		FabonacciRecursive_7_4 prc = new FabonacciRecursive_7_4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int n = Integer.parseInt(br.readLine());
			
//			for(int i = 0; i < n; i++) {
//				bw.write(String.valueOf(prc.recursive(i + 1)) + " ");
//			}
//			
//			
//			fibo = new int[n + 1];
//			prc.recursive_2(n);
//			for(int i = 0; i < n; i++) {
//				bw.write(String.valueOf(fibo[i + 1]) + " ");
//			}
			
			fibo = new int[n + 1];
			prc.recursive_3(n);
			for(int i = 0; i < n; i++) {
				bw.write(String.valueOf(fibo[i + 1]) + " ");
			}
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int recursive(int n) throws Exception {
		if(n == 1 || n == 2) {
			return 1;
		}
		return  recursive(n - 2) + recursive(n - 1);
	}
	
	private int recursive_2(int n) throws Exception {
		if(n == 1 || n == 2) {
			return fibo[n] = 1;
		}
		return fibo[n] = recursive_2(n - 2) + recursive_2(n - 1);
	}
	
	private int recursive_3(int n) throws Exception {
		if(fibo[n] > 0) {
			return fibo[n];
		}
		if(n == 1 || n == 2) {
			return fibo[n] = 1;
		}
		return fibo[n] = recursive_3(n - 2) + recursive_3(n - 1);
	}
}