package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Travel_9372 {
	static int count;
	static boolean[] check;
	
	static void dfs(int x, int y) {
		count++;
		check[x] = true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < T; i++) {
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			st = new StringTokenizer(br.readLine());
			int country = Integer.parseInt(st.nextToken());
			int airplain = Integer.parseInt(st.nextToken());
			
			check = new boolean[country + 1];

			for(int j = 0; j < airplain + 1; j++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for(int j = 1; j < airplain + 1; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph.get(j).add(a);
				graph.get(j).add(b);
			}
			
			for(int j = 1; j < airplain + 1; j++) {
				for(int k = 0; k < graph.get(j).size(); k++) {
					if(!check[k]) {
						dfs(graph.get(j).get(k), 0);
					}
				}
			}
			
			bw.write(count + "");
			bw.flush();
		}
		
		bw.close();
		
	}

}