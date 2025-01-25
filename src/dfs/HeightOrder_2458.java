package dfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HeightOrder_2458 {
	private int[][] parentNodes; // 나보다 키가 큰 노드
	private int[][] childNodes;	 // 나보다 키가 작은 노드
	private boolean[] visit;
	
	private int studentCount;
	
	public static void main(String[] args) {
		HeightOrder_2458 prc = new HeightOrder_2458();
		prc.run();
	}
	
	private void run() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int answer = 0;
			initNodes();
			
			for(int i = 1; i < studentCount + 1; i++) {
				visit = new boolean[studentCount + 1];
				
				int totalVisitCount = checkNodes(i, 0, true) + checkNodes(i, 0, false);
				
				if(totalVisitCount == (studentCount - 1)) { // 나 자신 제외
					answer++;
				}
			}
			
			bw.write(answer + "");
			bw.flush();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int checkNodes(int num, int visitCount, boolean checkParent) {
		
		// 나보다 키가 큰 노드 순회
		if(checkParent) {
			visit[num] = true;
			for(int i = 1; i < parentNodes[num].length; i++) {
				if(parentNodes[num][i] > 0 && !visit[i]) {
					visitCount++;
					
					int nextNum = i;
					
					visitCount = checkNodes(nextNum, visitCount, checkParent);
				}
			}
			
		} else {
			// 나보다 작은 노드를 순회
			visit[num] = true;
			for(int i = 1; i < childNodes[num].length; i++) {
				if(childNodes[num][i] > 0 && !visit[i]) {
					visitCount++;
					
					int nextNum = i;
					visitCount = checkNodes(nextNum, visitCount, checkParent);
				}
			}
		}
		
		return visitCount;
	}
	
	private void initNodes() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		studentCount = Integer.parseInt(st.nextToken());
		int compareCount = Integer.parseInt(st.nextToken());
		
		parentNodes = new int[studentCount + 1][studentCount + 1];
		childNodes = new int[studentCount + 1][studentCount + 1];
		visit = new boolean[studentCount + 1];
		
		for(int i = 0; i < compareCount; i++) {
			st = new StringTokenizer(br.readLine());
			
			int small = Integer.parseInt(st.nextToken());
			int big = Integer.parseInt(st.nextToken());
			
			// 큰 사람이 있다면 해당 노드 1 / 없다면 0
			// 1 보다 큰 사람 이 3 이라면 [1][3] -> 1
			parentNodes[small][big] = 1;
			childNodes[big][small] = 1;
			
		}
		
	}
}