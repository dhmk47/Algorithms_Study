package inflearn.java_algorithms.number_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AppointmentOfAnInterimLeader_2_11 {
	public static void main(String[] args) {
		AppointmentOfAnInterimLeader_2_11 prc = new AppointmentOfAnInterimLeader_2_11();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][5];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 5; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bw.write(String.valueOf(prc.solution(n, arr)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private int solution(int n, int[][] arr) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			int meetStudent = 0;				// 1햑년부터 5학년까지 총 몇 명의 학생과 같은 반이였는지
			int[] checkArray = new int[n];		// 자신과 몇 번 학생이 같은 반이였는지 확인하는 배열
			
			for(int j = 0; j < 5; j++) {		// 1번 학생부터 1학년부터 5학년까지 몇 번 학생과 같은 반이였는지 확인 
				int classNumber = arr[i][j];
				for(int k = 0; k < n; k++) {
					if(i == k) {				// 동일한 학생은 건너뛰기
						continue;
					}
					
					if(classNumber == arr[k][j] && checkArray[k] == 0) {		// 같은 반이고 한번도 만난 적이 없는 학생일 때 체크
						checkArray[k] = 1;
					}
				}
			}
			
			for(int checkNumber : checkArray) {
				if(checkNumber == 1) {
					meetStudent++;
				}
			}
			
			if(max < meetStudent) {
				answer = i + 1;
				max = meetStudent;
			}
		}
		
		return answer;
	}
}