package inflearn.java_algorithms;
import java.io.*;
import java.util.StringTokenizer;
public class MaximumSumOfGridPlates_2_9 {

	public static void main(String[] args) { 
		MaximumSumOfGridPlates_2_9 prc = new MaximumSumOfGridPlates_2_9();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			int[][] arr = new int[count][count];
			for(int i = 0; i < count; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < count; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bw.write(String.valueOf(prc.solution(count, arr)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int count, int[][] arr) {
		int answer = 0;
		
		int maxSum = 0;
		for(int i = 0; i < count; i++) {
			int rowSum = 0;
			int columnSum = 0;
			
			for(int j = 0; j < count; j++) {
				rowSum += arr[i][j];
				columnSum += arr[j][i];
			}
			maxSum = Math.max(columnSum, rowSum);
			answer = Math.max(answer, maxSum);
		}
		
		int diagonalSumFirst = 0;
		int diagonalSumSecond = 0;
		for(int i = 0; i < count; i++) {
			diagonalSumFirst += arr[i][i];
			diagonalSumSecond += arr[i][count - 1 - i];
		}
		maxSum = Math.max(diagonalSumFirst, diagonalSumSecond);
		answer = Math.max(answer, maxSum);
		
		return answer;
	}
}