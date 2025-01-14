package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KinshipCalculation_2644 {
	static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int person1 = 0;
	static int person2 = 0;
	static int answer = -1;
	static boolean[] visit = null;
	
	static public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int totalPerson = Integer.parseInt(br.readLine());
		visit = new boolean[totalPerson + 1];
		
		
		for(int i = 0; i < totalPerson + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		st = new StringTokenizer(br.readLine());
		
		person1 = Integer.parseInt(st.nextToken());
		person2 = Integer.parseInt(st.nextToken());
		
		int loop = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < loop; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		for(int i = 0; i < graph.size(); i++) {
				dfs(person1, 0);
		}
		
		bw.write(answer + "");
		bw.flush();
	}
	
	static public void dfs(int x, int count) {
		
		visit[x] = true;
		
		if(x == person2) {
			answer = count;
			return;
		}
		
		for(int i = 0; i < graph.get(x).size(); i++) {
			int next = graph.get(x).get(i);
			
				if(!visit[next]) {
					// 촌수 증가
					dfs(next, count + 1);
			}
		}
		
	}
}