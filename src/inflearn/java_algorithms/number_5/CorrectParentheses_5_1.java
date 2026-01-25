package inflearn.java_algorithms.number_5;
import java.io.*;
import java.util.*;
public class CorrectParentheses_5_1 {
	public static void main(String[] args) {
		CorrectParentheses_5_1 prc = new CorrectParentheses_5_1();
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
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : str.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			}else {
				if(stack.isEmpty()) {
					return "NO";
				}
				
				stack.pop();
			}
		}
		
		return stack.isEmpty() ? "YES" : "NO";
	}
}