package inflearn.java_algorithms.number_2;
import java.io.*;
import java.util.StringTokenizer;
public class Mentoring_2_12 {
	public static void main(String[] args) {
		Mentoring_2_12 prc = new Mentoring_2_12();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());		// 학생 수
			int m = Integer.parseInt(st.nextToken());		// 케이스
			int[][] arr = new int[m][n];
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bw.write(String.valueOf(prc.solution(n, m, arr)));
			bw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, int m, int[][] arr) {
		int answer = 0;
		int[][] resultArray = new int[n + 1][n + 1];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int studentNumber = arr[i][j];
				for(int k = 0; k < n; k++) {
					if(j < k && resultArray[studentNumber][arr[i][k]] == 0) {		// 0일 때만 
						resultArray[studentNumber][arr[i][k]] = 1;
					}else if(j > k) {												// 한 번이라도 성적이 낮다면 -1로 넣어줌
						resultArray[studentNumber][arr[i][k]] = -1;
					}
				}
			}
		}
		
		for(int i = 0; i < resultArray.length; i++) {
			for(int j = 0; j < resultArray[i].length; j++) {
				if(resultArray[i][j] == 1) {
					answer++;
				}
			}
		}
		return answer;
	}
}