package inflearn.java_algorithms.number_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class RemoveParentheses_5_2 {
	public static void main(String[] args) {
		RemoveParentheses_5_2 prc = new RemoveParentheses_5_2();
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
		StringBuilder answer = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : str.toCharArray()) {
			if(c == ')') {
				while(true) {
					if(stack.pop() == '(') {
						break;
					}
				}
			}else {
				stack.push(c);
			}
		}
		
		for(Object c : stack.toArray()) {
			answer.append((char) c);
		}
		
//		for(int i = 0; i < stack.size(); i++) {
//			answer.append(stack.get(i));
//		}
//		for(char c : stack) {
//			answer.append(c);
//		}
		
		return answer.toString();
	}
}