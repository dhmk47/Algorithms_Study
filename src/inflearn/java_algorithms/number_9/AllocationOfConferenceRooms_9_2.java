package inflearn.java_algorithms.number_9;
import java.io.*;
import java.util.*;

class Plan {
	int startTime, endTime;
	
	Plan(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
public class AllocationOfConferenceRooms_9_2 {
	public static void main(String[] args) {
		AllocationOfConferenceRooms_9_2 prc = new AllocationOfConferenceRooms_9_2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try { 
			int n = Integer.parseInt(br.readLine());
			List<Plan> planList = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int startTime = Integer.parseInt(st.nextToken());
				int endTime = Integer.parseInt(st.nextToken());
				
				planList.add(new Plan(startTime, endTime));
			}
			
			bw.write(String.valueOf(prc.solution(n, planList)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, List<Plan> planList) {
		int answer = 0;
		planList.sort(Comparator.comparingInt((Plan plan) -> plan.endTime)
									.thenComparingInt((Plan plan) -> plan.startTime));
		
		int lastTime = Integer.MIN_VALUE;
		for(Plan plan : planList) {
			if(plan.startTime >= lastTime) {
				answer++;
				lastTime = plan.endTime;
			}
		}
		
		return answer;
	}
}