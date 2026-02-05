package inflearn.java_algorithms.number_7;
import java.io.*;
import java.util.*;

public class FindingTheCalf_1_BFS_7_8 {
	int[] dy = {-1, 1, 5};
	int[] visit = new int[10001];
	
	public static void main(String[] args) {
		FindingTheCalf_1_BFS_7_8 prc = new FindingTheCalf_1_BFS_7_8();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			prc.bfs(s, e);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void bfs(int s, int e) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		
		int count = 0;
		boolean loop = true;
		while(!q.isEmpty() && loop) {
			int pos = 0;
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				pos = q.poll();							// 현재 위치 꺼냄
//				visit[pos] = 1;
				
				if(pos == e) {							// 송아지 위치인가?
					loop = false;
					bw.write(String.valueOf(count));
					break;
				}
				
				for(int j = 0; j < dy.length; j++) {	// 현재 위치로부터 갈 수 있는 지점 전체 삽입 (방문 안 한 곳만)
					int ny = pos + dy[j];
					if(ny > 0 && ny <= 10000 && visit[ny] == 0) {
						visit[ny] = 1;
						q.offer(ny);
					}
				}
				
			}
			count++;
		}

		bw.flush();
	}
}