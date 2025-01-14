package dfs_bfs;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChoosingNumber_2668 {
	static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static List<Integer> answerList = new ArrayList<>();
	static boolean[] visit = null;
	
	static public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int loop = Integer.parseInt(br.readLine());
		visit = new boolean[loop];
		
		for(int i = 0; i < loop; i++) {
			int number = Integer.parseInt(br.readLine());
			graph.add(new ArrayList<>());
			graph.get(i).add(number - 1);
		}
		
		for(int i = 0; i < graph.size(); i++) {
			dfs(i, graph.get(i).get(0));
				
		}
		
		Collections.sort(answerList);
		
		
		bw.write(answerList.size() + "\n");
		for(int data : answerList) {
			bw.write(data + "\n");
		}
		
		bw.flush();
	}
	
	static public void dfs(int firstIndex, int number) {
		if(visit[number]) {
			return;
		}
		
		// 처음 들어온 인덱스번호와 요소가 같다면 한 번의 싸이클을 돌았다
		if(firstIndex == number) {
			answerList.add(firstIndex + 1);
			return;
		}
		
		int nextNumber = graph.get(number).get(0);

        // 들어갔던 리스트를 계속 반복하지 않기 위해서 방문처리
		visit[number] = true;
		dfs(firstIndex, nextNumber);
        // 모든 방문처리를 초기화함으로써 다음 배열을 돌 수 있게 거짓처리
		visit[number] = false;
	}
}