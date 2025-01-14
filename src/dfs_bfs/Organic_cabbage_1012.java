package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Organic_cabbage_1012 {
						//    상,하,좌,우
	static int[] dx = { -1, 1, 0, 0};
	static int[] dy = { 0, 0, -1, 1};
	static int [][][] graph;
	static int[][] length; // 3차원배열 면의 각각의 행 열을 담을 변수
	static int sum;
	static int dfs(int n, int x, int y, int count) {
		if(graph[n][x][y] == 0) return 0;
		else {
			graph[n][x][y] = 0;
			sum++; // 1이라면 sum 증가
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx > length[count][1] - 1 || ny < 0 || ny > length[count][0] - 1) continue;
				dfs(n, nx, ny, count);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		length = new int[T][2];
		int count = 0;					// 함수내에서 범위를 벗어나지않기위해 각 3차원배열 면마다의 행,열을 구분하기 위해 사용
		ArrayList<Integer> result = new ArrayList<>();
		
		graph = new int[T][][]; // 먼저 면할당
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k < 2; k++) {
				length[i][k] = Integer.parseInt(st.nextToken()); // 가로길이, 세로길이 순으로 대입
			}
			int K = Integer.parseInt(st.nextToken()); // 배추 갯수
			graph[i] = new int[length[i][1]][length[i][0]]; // 면에 접근해서 각 면마다 행과 열을 새롭게 할당
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()); // 열
				int x = Integer.parseInt(st.nextToken()); // 행
				graph[i][x][y] = 1;
			}
		}
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < graph[i].length; j++) {
				for(int k = 0; k < graph[i][j].length; k++) {
						sum = (dfs(i, j, k, count)); 			// 면, 행, 열, 3차원배열 면을 담당하는 변수 전달
						if(sum != 0) result.add(sum);		// 함수내에서 1을 만나 sum++ 이 되어서 0이 아니라면 ArrayList에 add
						sum = 0;									// 중복으로 add 하지 않기 위해 0으로 초기화
					}
				}
			System.out.println(result.size());				// ArrayList에 add 된 갯수만큼 출력
			result.clear();											// 다음 면으로 들어가면 처음부터 해야하기에 ArrayList Clear를 진행
			count++; // 3차원배열 면을 담당하는 변수 1 증가
		}
		
	}
}
