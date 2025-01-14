package stack_queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightBigNumber_17298 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && num[stack.peek()] < num[i]) {
				num[stack.pop()] = num[i];
			}
			
			stack.push(i);		// 현재 인덱스 스택에 추가
		}
		
		while(!stack.isEmpty()) {
			num[stack.pop()] = -1;
		}
		for(int i : num) {
			bw.write("" + i + " ");
		}
		bw.flush();
		bw.close();
	}
}
