package inflearn.java_algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringCompression_1_11 {
	public static void main(String[] args) {
		StringCompression_1_11 prc = new StringCompression_1_11();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write(prc.solution(br.readLine()));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(String str) {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			int count = 1;
			
			for(int j = 0; j < result.length(); j++) {
				if(result.charAt(result.length() - 1 - j) == str.charAt(i)) {
					count++;
				}else {
					break;
				}
			}
			
			if(count == 1) {
				result.append(str.charAt(i));
			}else {
				result.append(count);
			}
			
		}
		
		return result.toString();
	}
}