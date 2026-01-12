package inflearn.java_algorithms;

import java.io.*;

public class ReverseWord_1_4 {

	public static void main(String[] args) {
		ReverseWord_1_4 prc = new ReverseWord_1_4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < count; i++) {
				bw.write(prc.solution(br.readLine()));
			}
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(String str) {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			result.append(str.charAt(str.length() - 1 - i));
		}
		
		return result.append("\n").toString();
	}
}