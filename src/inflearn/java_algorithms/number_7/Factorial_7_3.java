package inflearn.java_algorithms.number_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Factorial_7_3 {
	
	public static void main(String[] args) {
		Factorial_7_3 prc = new Factorial_7_3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write(String.valueOf(prc.recursive(Integer.parseInt(br.readLine()))));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int recursive(int n) throws Exception {
		if(n == 1) {
			return 1;
		}
		return n * recursive(n - 1);
	}
}