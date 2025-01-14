package stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_10845 {
	public static void main(String[] agrs) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new LinkedList<>();
		int num = 0;
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String[] command = br.readLine().split(" ");
			if(command[0].equals("push")) {
				q.offer(Integer.parseInt(command[1]));
				num = Integer.parseInt(command[1]);		// 마지막 문자를 출력하기 위한 변수
			}
			else if(command[0].equals("pop")) {
				if(!q.isEmpty()) {
					bw.write("" + q.poll() + "\n");
				}else {
					bw.write("-1" + "\n");
				}
			}
			else if(command[0].equals("size")) {
				bw.write("" + q.size() + "\n");
			}
			else if(command[0].equals("empty")) {
				if(!q.isEmpty()) {
					bw.write("0" + "\n");
				}else {
					bw.write("1" + "\n");
				}
			}
			else if(command[0].equals("front")) {
				if(!q.isEmpty()) {
					bw.write("" + q.peek() + "\n");
				}else {
					bw.write("-1" + "\n");
				}
			}
			else {
				if(!q.isEmpty()) {
					bw.write("" + num + "\n");
				}else {
					bw.write("-1" + "\n");
				}
			}
			bw.flush();
		}
		bw.close();
	}
}
