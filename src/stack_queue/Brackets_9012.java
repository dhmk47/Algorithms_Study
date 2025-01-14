package stack_queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Brackets_9012 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<>();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				if(!s.isEmpty()) {				// 비어있지 않다면
					if(str.charAt(j) == '(') {	// 현재 문자와 최상단 스택의 요소와 같다면
						s.add(str.charAt(j));
						// 스택의 최상단 요소의 조건과 문자열의 현재 문자의 조건이 밑과 같다면
					}else if(s.peek() == '(' && str.charAt(j) == ')') {
						s.pop();
					}
				}else { // 비어있다면
					s.add(str.charAt(j));
				}
			}
			if(s.isEmpty()) {					// 비었을때
				System.out.println("YES");
			}else {								// 아닐때
				System.out.println("NO");
			}
			s.clear();
		}
	}
}
