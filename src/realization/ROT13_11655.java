package realization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class ROT13_11655 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word = br.readLine();
		for(int i = 0; i < word.length(); i++) {
			char rot13 = word.charAt(i);
			if(rot13 > 96 && rot13 < 123) {		// 소문자
				rot13 += 13;
				if(rot13 > 122) {				// 범위를 벗어나면 a의 아스키코드 부터
					rot13 -= 123 - 97;
				}
			}else if(rot13 > 64 && rot13 < 91) {// 대문자
				rot13 += 13;
				if(rot13 > 90) {				// 범위를 벗어나면 A의 아스키코드 부터
					rot13 -= 91 - 65;
				}
			}
			bw.write((char)rot13);
		}
		bw.flush();
		bw.close();
	}
}