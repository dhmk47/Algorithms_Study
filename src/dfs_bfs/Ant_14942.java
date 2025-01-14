package dfs_bfs;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ant_14942 {
	static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int[] antEnergy = null;
//	static int[][] depthArray = null;
	static boolean[] visit = null;
	static int answer = 0;
	static int myEnergy = 0;
	static boolean isFirstFlag = false;
	static boolean finishFlag = false;
	static Map<String, Integer> map = new HashMap<>();
	
	static public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int roomAmount = Integer.parseInt(br.readLine());
		antEnergy = new int[roomAmount];
//		depthArray = new int[roomAmount][];
		visit = new boolean[roomAmount];
		
		for(int i = 0; i < roomAmount + 1; i++) {
			if(i != roomAmount) {
				antEnergy[i] = Integer.parseInt(br.readLine());
				
			}
			
			graph.add(new ArrayList<>());
		}
		
		
		for(int i = 0; i < roomAmount - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int depth = Integer.parseInt(st.nextToken());
			
			graph.get(a - 1).add(b - 1);
			graph.get(b - 1).add(a - 1);

			map.put((b - 1) + " " + (a - 1), depth);
			map.put((a - 1) + " " + (b - 1), depth);
			
//			depthArray[a - 1] = new int[b];
//			depthArray[b - 1] = new int[a];
//			depthArray[a - 1][b - 1] = depth;
//			System.out.println(depthArray[a - 1][b - 1]);
//			depthArray[b - 1][a - 1] = depth;
		}
		
//		for(int i = 0; i < depthArray.length; i++) {
//			for(int j = 0; j < depthArray[i].length; j++) {
//				System.out.print(depthArray[i][j]);
//			}
//			System.out.println();
//		}
		
		
		for(int i = 0; i < roomAmount; i++) {
			if(i != 0) {
				answer = i + 1;
				myEnergy = antEnergy[i];
				isFirstFlag = true;
//				System.out.println("=====================================");
				finishFlag = false;
				dfs(i, graph.get(i).get(0), i);
			}else {
				answer = 1;
			}
			bw.write(answer + ((i + 1 == roomAmount) ? "" : "\n"));
			bw.flush();
		}
		
		bw.close();
	}
	
	static void dfs(int start, int next, int preCaveNumber) {
//		System.out.println("start: " + start);
//		System.out.println("next: " + next);
//		System.out.println("preCaveNumber: " + preCaveNumber);
		
		int energyCost = map.get(preCaveNumber + " " + next);
		
		
//		int energyCost = depthArray[preCaveNumber][next];
//		System.out.println("소비 후 에너지: " + (myEnergy - energyCost));
		if(myEnergy - energyCost < 0) {
			answer = preCaveNumber + 1;
			finishFlag = true;
			return;
		}
//		visit[start] = true;
		
		for(int i = 0; i < graph.get(next).size() && !finishFlag && answer != 1; i++) {
			if(isFirstFlag) {
				myEnergy = antEnergy[start];
			}
			int nextCaveNumber = graph.get(next).get(i);
//			System.out.println("nextCaveNumber: " + nextCaveNumber);
			if(!visit[nextCaveNumber]) {
				visit[nextCaveNumber] = true;
				answer = Math.min(answer, next + 1);
//				System.out.println("중간 점검: " + answer);
				myEnergy -= energyCost;
				isFirstFlag = false;
				dfs(start, nextCaveNumber, next);
				visit[nextCaveNumber] = false;
//				visit[start] = false;
				
			}
		}
	}
}