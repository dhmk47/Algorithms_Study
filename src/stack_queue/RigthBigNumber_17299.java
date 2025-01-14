package stack_queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class RigthBigNumber_17299 {
	/*
	 * 풀이
	 * 스택에 0 ~ N 까지의 인덱스를 넣으면서 스택에 요소가 있고 while문의 조건이 맞다면 while 실행
	 * while문의 조건 -> 스택에 요소가 있고 count[0 ~ N] 의 정수를 크기 비교
	 * while문으로 들어간다면 stack의 요소를 pop 하면서 현재 값을 대입
	 * pop을 못한 인덱스가 남았다면 그 인덱스들은 모두 -1
	 * 
	 */
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] ar = new int[N];		// 정수를 담는 변수
		int[] count = new int[1000001];	// 몇 개인지 알기 위한 변수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			count[num]++;		// 해당 인덱스 ++
			ar[i] = num;
		}
		for(int i = 0; i < N; i++) {
			// count를 비교해서 현재 count가 크다면 스택에서 인덱스 꺼내서 정수 대입
			while(!stack.isEmpty() && count[ar[stack.peek()]] < count[ar[i]]) {
				ar[stack.pop()] = ar[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			ar[stack.pop()] = -1;
		}
		for(int i : ar) {
			bw.write("" + i + " ");
		}
		bw.flush();
		bw.close();
	}
}