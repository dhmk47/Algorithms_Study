package inflearn.java_algorithms.number_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RecursiveFunction_7_1 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) {
		RecursiveFunction_7_1 prc = new RecursiveFunction_7_1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			prc.recursive(Integer.parseInt(br.readLine()));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void recursive(int n) throws Exception {
		if(n == 0) {
			return;
		}else {
			recursive(n - 1);
			bw.write(String.valueOf(n) + " ");
		}
	}
}