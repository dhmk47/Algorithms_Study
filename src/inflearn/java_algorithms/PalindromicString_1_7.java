package inflearn.java_algorithms;
import java.io.*;

public class PalindromicString_1_7 {

	public static void main(String[] args) {
		PalindromicString_1_7 prc = new PalindromicString_1_7();
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
		char[] charArray = str.toCharArray();
		int lt = 0;
		int rt = str.length() - 1;
		
		while(lt < rt) {
			char temp = charArray[lt];
			charArray[lt] = charArray[rt];
			charArray[rt] = temp;
			
			lt++;
			rt--;
		}
		
		return str.toLowerCase().equals(String.valueOf(charArray).toLowerCase()) ? "YES" : "NO";
	}
}