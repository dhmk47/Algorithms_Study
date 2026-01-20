package inflearn.java_algorithms.number_1;

import java.io.*;
public class RemoveDuplicateCharacters_1_6 {

	public static void main(String[] args) {
		RemoveDuplicateCharacters_1_6 prc = new RemoveDuplicateCharacters_1_6();
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
		String result = "";
		
		for(char c : str.toCharArray()) {
			if(!result.contains(String.valueOf(c))) {
				result += c;
			}
		}
		
		return result;
	}
}