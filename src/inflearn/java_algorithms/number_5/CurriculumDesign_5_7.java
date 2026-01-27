package inflearn.java_algorithms.number_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class CurriculumDesign_5_7 {
	public static void main(String[] args) {
		CurriculumDesign_5_7 prc = new CurriculumDesign_5_7();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(prc.solution(br.readLine(), br.readLine()));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(String mustSubject, String curriculum) {
		Queue<Character> queue = new LinkedList<>();
		
		for(char c : mustSubject.toCharArray()) {
			queue.offer(c);
		}
		
		for(char c : curriculum.toCharArray()) {
			if(queue.isEmpty()) {
				return "YES";
			}
			
			if(queue.peek() == c) {
				queue.poll();
			}
		}
		
		return queue.isEmpty() ? "YES" : "NO";
	}
	
	private String solution_2(String mustSubject, String curriculum) {
		Queue<Character> queue = new LinkedList<>();
		
		for(char c : mustSubject.toCharArray()) {
			queue.offer(c);
		}
		
		for(char c : curriculum.toCharArray()) {
			if(queue.contains(c)) {
				if(queue.poll() != c) {				// 필수과묵에 있는데 맨 앞에 없으면 순서가 틀렸다
					return "NO";
				}
			}
		}
		
		return queue.isEmpty() ? "YES" : "NO";
	}
}