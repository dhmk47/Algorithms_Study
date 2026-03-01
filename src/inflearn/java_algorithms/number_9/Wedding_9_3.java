package inflearn.java_algorithms.number_9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Plan_9_3 {
	int startTime;
	char status;
	
	Plan_9_3(int startTime, char status) {
		this.startTime = startTime;
		this.status = status;
	}
}
public class Wedding_9_3 {
	public static void main(String[] args) {
		Wedding_9_3 prc = new Wedding_9_3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try { 
			int n = Integer.parseInt(br.readLine());
			List<Plan_9_3> planList = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int startTime = Integer.parseInt(st.nextToken());
				int endTime = Integer.parseInt(st.nextToken());
				
				planList.add(new Plan_9_3(startTime, 's'));
				planList.add(new Plan_9_3(endTime, 'e'));
			}
			
			bw.write(String.valueOf(prc.solution(planList)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(List<Plan_9_3> planList) {
		int answer = Integer.MIN_VALUE;
		int count = 0;
		
		planList.sort(Comparator.comparingInt((Plan_9_3 plan) -> plan.startTime)
												.thenComparing((Plan_9_3 plan) -> plan.status));
		
		for(Plan_9_3 plan : planList) {
			if(plan.status == 'e') {
				count--;
			}else if(plan.status == 's') {
				count++;
			}
			
			answer = Math.max(answer, count);
		}
		
		return answer;
	}
}