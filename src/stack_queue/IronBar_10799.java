package stack_queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class IronBar_10799 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String bar = br.readLine(); // 문자열
		bar += " ";			// 38번줄에서 배열범위초과 오류를 방지하기 위해 마지막에 공백
		int count = 0;
		int sizeCount = 0;
		boolean check = false;
		for(int i = 0; i < bar.length(); i++) {
			if(bar.charAt(i) == ')' && check) {		// )이고 check가 true라면
				stack.pop();			// pop하고 check는 다시 false
				check = false;
				if(!stack.isEmpty()) {	// 스택에 요소가 있다면 사이즈만큼 더하기
					sizeCount += stack.size();
				}
			}
			else if(bar.charAt(i) == ')' && check == false) {	// ) 인데 false 일 경우
				stack.pop();		// 그냥 pop만
			}
					
			else {		// 모든 조건이 거짓이라면 스택에 추가
				stack.add(bar.charAt(i));
				if(bar.charAt(i) == '(')		// (라면 chekc는 true
					check = true;
					
				}
			
			if(bar.charAt(i) == '(' && bar.charAt(i + 1) == '(')		// 현재 (이고 다음도 (라면
				count++;		// count++
			
		}
		bw.write("" + (count + sizeCount));
		bw.flush();
		bw.close();
	}
}