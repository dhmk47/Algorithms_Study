package inflearn.java_algorithms.number_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ValidPalindrome_1_8 {
	
	public static void main(String[] args) {
		ValidPalindrome_1_8 prc = new ValidPalindrome_1_8();
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
		char[] charArray = str.toLowerCase().toCharArray();
		int lt = 0;
		int rt = str.length() - 1;
		boolean valid = true;
		
		while(lt < rt) {
			if(!validChar(charArray[lt])) {			// 알파벳이 아니라면 다음 문자로 다시 비교 
				lt++;
			}else if(!validChar(charArray[rt])) {	// 알파벳이 아니라면 다음 문자로 다시 비교 
				rt--;
			}else {									// 둘 다 알파벳이라면 비교
//				System.out.println(charArray[lt] + " - " + charArray[rt]);
				if(charArray[lt] != charArray[rt]) {
					valid = false;
					break;
				}
				lt++;
				rt--;
			}
		}
		
		return valid ? "YES" : "NO";
	}
	
	private boolean validChar(char c) {
		return Character.isAlphabetic(c);
	}
}