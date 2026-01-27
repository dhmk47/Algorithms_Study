package inflearn.java_algorithms.number_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Person {
	int id;
	int priority;
	
	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
}

public class EmergencyRoom_5_8 {
	public static void main(String[] args) {
		EmergencyRoom_5_8 prc = new EmergencyRoom_5_8();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(String.valueOf(prc.solution(n, m, arr)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, int m, int[] arr) {
		int answer = 0;
		Queue<Person> queue = new LinkedList<>();
		
		for(int i = 0; i < arr.length; i++) {
			queue.offer(new Person(i, arr[i]));
		}
		
		while(!queue.isEmpty()) {
			Person temp = queue.poll();
			
			for(Person q : queue) {
				if(temp.priority < q.priority) {
					queue.offer(temp);
					temp = null;
					break;
				}
			}
			
			if(temp != null) {
				answer++;
				if(temp.id == m) {
					break;
//					return answer;
				}
			}
		}
		
		return answer;
	}
}