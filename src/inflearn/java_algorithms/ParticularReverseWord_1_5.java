package inflearn.java_algorithms;
import java.io.*;

public class ParticularReverseWord_1_5 {

	public static void main(String[] args) {
		ParticularReverseWord_1_5 prc  = new ParticularReverseWord_1_5();
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
			if(!Character.isAlphabetic(charArray[lt])) {
				lt++;
			}else if(!Character.isAlphabetic(charArray[rt])) {
				rt--;
			}else {
				char temp = charArray[lt];
				charArray[lt] = charArray[rt];
				charArray[rt] = temp;
				lt++;
				rt--;
			}
		}
		
		return String.valueOf(charArray);
	}
}