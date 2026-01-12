package inflearn.java_algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class FindChar_1_1 {

	public static void main(String[] args) {
		FindChar_1_1 prc = new FindChar_1_1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write(prc.solution(br.readLine(), br.readLine()) + "");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int solution(String string, String target) {
		int answer = 0;
		
		for(int i = 0; i < string.length(); i++) {
			if(target.toLowerCase().equals(String.valueOf(string.charAt(i)).toLowerCase())) {
				answer++;
			}
		}
		
		return answer;
	}
}