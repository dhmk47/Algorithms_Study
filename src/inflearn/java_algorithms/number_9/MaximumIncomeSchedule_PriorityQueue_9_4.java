package inflearn.java_algorithms.number_9;
import java.io.*;
import java.util.*;

public class MaximumIncomeSchedule_PriorityQueue_9_4 {
	public static void main(String[] args) {
		MaximumIncomeSchedule_PriorityQueue_9_4 prc = new MaximumIncomeSchedule_PriorityQueue_9_4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int startTime = Integer.parseInt(st.nextToken());
				int endTime = Integer.parseInt(st.nextToken());
				
			}
			
			bw.write(String.valueOf(prc.solution(planList)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(List<Plan_9_3> planList) {
		int answer = 0;
		
		return answer;
	}
}