package inflearn.java_algorithms.number_5;
import java.io.*;
import java.util.Stack;
public class Postfix_5_4 {
	public static void main(String[] args) {
		Postfix_5_4 prc = new Postfix_5_4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(String.valueOf(prc.solution(br.readLine())));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(String str) {
		Stack<Integer> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if(c >= '0' && c <= '9') {
				stack.push(c - '0');
			}else {
				int a = stack.pop();
				int b = stack.pop();
				
				if(c == '+') {
					stack.push(b + a);
				}else if(c == '-') {
					stack.push(b - a);
				}else if(c == '*') {
					stack.push(b * a);
				}else {
					stack.push(b / a);
				}
			}
		}
		return stack.pop();
	}
}