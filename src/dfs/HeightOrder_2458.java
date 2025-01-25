package dfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HeightOrder_2458 {
	private int[][] parentNodes; // ������ Ű�� ū ���
	private int[][] childNodes;	 // ������ Ű�� ���� ���
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
				
				if(totalVisitCount == (studentCount - 1)) { // �� �ڽ� ����
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
		
		// ������ Ű�� ū ��� ��ȸ
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
			// ������ ���� ��带 ��ȸ
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
			
			// ū ����� �ִٸ� �ش� ��� 1 / ���ٸ� 0
			// 1 ���� ū ��� �� 3 �̶�� [1][3] -> 1
			parentNodes[small][big] = 1;
			childNodes[big][small] = 1;
			
		}
		
	}
}