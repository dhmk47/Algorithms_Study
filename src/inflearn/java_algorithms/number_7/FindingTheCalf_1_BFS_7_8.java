package inflearn.java_algorithms.number_7;
import java.io.*;
import java.util.*;

public class FindingTheCalf_1_BFS_7_8 {
	int[] dy = {-1, 1, 5};
	int[] visit = new int[10001];
	
	public static void main(String[] args) {
		FindingTheCalf_1_BFS_7_8 prc = new FindingTheCalf_1_BFS_7_8();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(prc.bfs(s, e)));
//			bw.write(String.valueOf(prc.bfs_2(s, e)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private int bfs(int s, int e) {
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
					return count;
				}
				
				for(int j = 0; j < dy.length; j++) {	// 현재 위치로부터 갈 수 있는 지점 전체 삽입 (방문 안 한 곳만)
					int nx = pos + dy[j];
					
					if(nx == e) {						// 다음 방문할 곳이 송아지 위치인가?
						return count + 1;
					}
					if(nx > 0 && nx <= 10000 && visit[nx] == 0) {
						visit[nx] = 1;
						q.offer(nx);
					}
				}
				
			}
			count++;
		}
		
		return 0;
	}
	
	private int bfs_2(int s, int e) {
		Queue<Integer> q = new LinkedList<>();
		int[] dis = new int[10001];
		q.offer(s);
		
		dis[s] = 0;
		while(!q.isEmpty()) {
			int pos = q.poll();						// 현재 위치 꺼냄
			if(pos == e) {							// 송아지 위치인가?
				return dis[pos];
			}
			
			for(int j = 0; j < dy.length; j++) {	// 현재 위치로부터 갈 수 있는 지점 전체 삽입 (방문 안 한 곳만)
				int nx = pos + dy[j];
				
				if(nx == e) {						// 다음 방문할 곳이 송아지 위치인가?
					return dis[pos] + 1;
				}
				if(nx > 0 && nx <= 10000 && visit[nx] == 0) {
					visit[nx] = 1;
					dis[nx] = dis[pos] + 1;
					q.offer(nx);
				}
			}
				
		}
		
		return 0;
	}
}