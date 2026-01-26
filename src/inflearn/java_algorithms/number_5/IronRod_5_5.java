package inflearn.java_algorithms.number_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class IronRod_5_5 {
	public static void main(String[] args) {
		IronRod_5_5 prc = new IronRod_5_5();
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
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if(c == '(') {
				if(!stack.isEmpty() ) {
					stack.pop();
					stack.push('0');			// (()) 이 상태일 때 첫번째 레이저를 만나 ()를 pop하게 되면 뒤에 있는 )가 (를 만나 레이저처럼 되는 것을 방지하고 )가 와서 그 전에 (일 때만 스택 사이즈만큼 더해줌
				}
				stack.push(c);
			}else {
				if(stack.pop() == '(') {		// )가 와서 꺼낸게 (라면 레이저이고 스택에 쌓여있는 수량만큼 더해준다.
					answer += stack.size();
				}else {							// 그게 아니라면 레이저가 아닌 레이저의 바로 직전에 있던 (였기 때문에 이건 하나의 쇠막대기 종료를 뜻함
					answer++;
				}
			}
		}
		
		return answer;
	}
}