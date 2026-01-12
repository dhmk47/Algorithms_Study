package inflearn.java_algorithms;

import java.io.*;
public class CaseConversion_1_2 {
	public static void main(String[] args) {
		CaseConversion_1_2 prc = new CaseConversion_1_2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write(prc.solution(br.readLine()));
			bw.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private String solution(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(char c : str.toCharArray()) {
			if(c >= 97) {
				sb.append(Character.toUpperCase(c));
			}else {
				sb.append(Character.toLowerCase(c));
			}
		}
		
		return sb.toString();
	}
}