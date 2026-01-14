package inflearn.java_algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Password_1_12 {
	public static void main(String[] args) {
		Password_1_12 prc = new Password_1_12();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write(prc.solution(Integer.parseInt(br.readLine()), br.readLine()));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(int count, String str) {
		StringBuilder answer = new StringBuilder();
		StringBuilder binary = new StringBuilder();
		
		for(char c : str.toCharArray()) {
			if(c == '#') {
				binary.append("1");
			}else {
				binary.append("0");
			}
			
			if(binary.length() == 7) {
				// Integer.parseInt(binary.toString(), 2) // 2진수 -> 10진수
				answer.append((char)Integer.parseInt(binary.toString(), 2));
				binary = new StringBuilder();
			}
		}
		
		return answer.toString();
	}
}