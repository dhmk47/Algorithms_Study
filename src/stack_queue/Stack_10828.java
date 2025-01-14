package stack_queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10828 {
	public static void main(String[] args)throws IOException {
		Stack<Integer> s = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String[] result = br.readLine().split(" ");
			if(result[0].equals("push"))
				s.push(Integer.parseInt(result[1]));
			
			else if(result[0].equals("top"))
				if(s.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(s.peek());
				}
			
			else if(result[0].equals("size"))
				System.out.println(s.size());
			
			else if(result[0].equals("empty")) {
				if(s.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
			}
			
			else if(result[0].equals("pop")) {
				if(s.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(s.pop());
				}
			}
		}
	}
}
