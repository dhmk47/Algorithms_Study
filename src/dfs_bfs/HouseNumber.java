package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class HouseNumber {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> account = new ArrayList<Integer>();
	//                       상  하  좌  우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int N;
	static boolean[][] visit;
	static int count, result;
	
	static boolean dfs(int y, int x) {
		// 이미 방문했다면 즉시 종료
		if(visit[y][x] == true) {
			return false;
		}
		// 방문처리
		visit[y][x] = true;
		// 0은 필요없으니 0이라면 즉시 종료
		if(graph.get(y).get(x) == 0) {
			return false;
		}
		else {
			count++;
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				// 범위를 벗어났다면 함수를 부르지않음
				if(ny < 0 || ny > N - 1|| nx < 0 || nx > N - 1) continue;
				dfs(ny, nx);
			}
			return true;
		}
	}
	
	static void input()throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N][N];
		// 2차원 ArrayList 할당
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < N; i++) {
			// 2차원 ArrayList 할당
			String number = br.readLine();
			for(int j = 0; j < N; j++) {
				// 입력받은 문자열을 각각의 2차원 ArrayList에 대입
				graph.get(j).add(number.charAt(j) - '0');
			}
		}
	}
	
	static void dfs() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(dfs(i, j)) {
					// 0을 만나 모든 재귀함수 탈출시 result++ 과 count를 add 후 count 0으로 초기화
					result++;
					account.add(count);
					count = 0;
				}
			}
		}
	}
	
	static void show() {
		// 정렬
		Collections.sort(account);
		System.out.println(result);
		for(int i = 0; i < account.size(); i++) {
			System.out.println(account.get(i));
		}
	}
	
	public static void main(String[] args)throws IOException {
		// 정보 입력
		input();
		// dfs 실행
		dfs();
		// 출력 결과
		show();
		
	}
}
