package inflearn.java_algorithms.number_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class CraneClawMachine_Kakao_5_3 {
	public static void main(String[] args) {
		CraneClawMachine_Kakao_5_3 prc = new CraneClawMachine_Kakao_5_3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			int[][] boards = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					boards[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int m = Integer.parseInt(br.readLine());
			int[] moves = new int[m];

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				moves[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(String.valueOf(prc.solution(n, m, boards, moves)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n, int m, int[][] boards, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int move : moves) {
			for(int i = 0; i < n; i++) {
				int doll = boards[i][move - 1];
				if(doll != 0) {
					if(!stack.isEmpty() && stack.peek() == doll) {
						answer += 2;
						stack.pop();
					}else {
						stack.push(doll);
					}
					
					boards[i][move - 1] = 0;
					break;
				}
			}
		}
		
		return answer;
	}
}