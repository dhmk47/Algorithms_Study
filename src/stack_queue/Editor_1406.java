package stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Editor_1406 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> s = new Stack<>();		// 기존 스택
		Stack<Character> s2 = new Stack<>();		// 옮겨담을 스택
		String str = br.readLine();						// 초기 문자열
		for(int i = 0; i < str.length(); i++) {
			s.add(str.charAt(i));
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			String edit = br.readLine();
			if(edit.charAt(0) == 'P') {			// P라면 문자 추가
				s.add(edit.charAt(2));
			}
			else if(edit.charAt(0) == 'L' && !s.isEmpty()) {		// L이라면 잠시 s2에 옮기기
				s2.add(s.pop());
			}
			else if(edit.charAt(0) == 'D' && !s2.isEmpty()) {	// D라면 옮겼던 문자 다시 추가
				s.add(s2.pop());
			}
			else if(edit.charAt(0) == 'B' && !s.isEmpty()) { // B라면 제거
				s.pop();
			}
		}
		while(!s2.isEmpty()) {		// 옮겼던 문자 다시 초기스택으로 옮기기
			s.add(s2.pop());
		}
		for(char c : s) {
			bw.write("" + c);
		}
		bw.flush();
		bw.close();
	}
}