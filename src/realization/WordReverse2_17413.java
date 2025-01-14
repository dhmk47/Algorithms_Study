package realization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
/*
 * 풀이:
 * <> 안에는 문자가 뒤집지 않고 공백포함 그대로 출력
 * <라면 스택에 넣지않고 > 를 만날때까지 그대로 출력
 * 스택에 문자가 있고 <를 만났다면 우선 스택을 먼저 비우고 다시 진행
 */

public class WordReverse2_17413 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> s = new Stack<>();
		boolean flag = false;
		String S = br.readLine(); // 초기 문자열
		S += " ";						// 공백을 기준으로 출력하기때문에 공백 추가
		
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) != ' ') {			// 공백이 아니라면
				if(S.charAt(i) == '<') {	// < 문자를 만났다면 flag는 참
					flag = true;
					if(!s.isEmpty()) {		// 만약 <를 만났고 스택에 문자가 있다면
						while(!s.isEmpty()) {	// 문자 출력
							bw.write(s.pop());
						}
					}
				}
				if(flag == false) {			// flag가 거짓이면 스택에 문자추가
					s.add(S.charAt(i));
				}
				else if (flag) {					// flag가 참일시 문자 그대로 출력
					if(S.charAt(i) == '>') {	// 만약 >를 만났다면 flag는 다시 거짓으로
						flag = false;
					}
					bw.write(S.charAt(i));
				}
			}
			else if(S.charAt(i) == ' ') {		// 공백을 만났고 스택에 문자가 있다면 출력
				while(!s.isEmpty()) {
					bw.write(s.pop());
				}
				bw.write(" ");			// 그 후 공백 출력
			}
		}
		bw.flush();
		bw.close();
	}
}
