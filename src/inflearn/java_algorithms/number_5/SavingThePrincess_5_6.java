package inflearn.java_algorithms.number_5;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class SavingThePrincess_5_6 {
	public static void main(String[] args) {
		SavingThePrincess_5_6 prc = new SavingThePrincess_5_6();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(prc.solution(n, k)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, int k) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < n; i++) {
			queue.offer(i + 1);
		}
		
		int index = 0;
		while(queue.size() > 1) {
			int number = queue.poll();
			
			if(++index % k != 0) {
				queue.add(number);
			}
		}
		
		return queue.peek();
	}
}