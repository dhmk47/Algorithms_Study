package stack_queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus_1158 {
	public static void main(String[] agrs)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
//		LinkedList<Integer> list = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i < N + 1; i++) {
			q.offer(i);
		}

		
		bw.write("<");
		while(q.size() > 1) {
			for(int i = 0; i < K - 1; i++) { // K번째에 접근하기전까지는 큐에 다시 offer
				if(!q.isEmpty()) {
					q.offer(q.poll());
				}
			}
			bw.write(q.poll() + ", "); // K번째에 접근했다면 poll
		}
		bw.write(q.poll() + ">");
		bw.flush();
		bw.close();
	}
}
