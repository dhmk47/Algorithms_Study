package inflearn.java_algorithms.number_8;
import java.io.*;
import java.util.*;
public class GettingCombination_8_9 {
	static int n, m;
	static int[] checkArray, sequenceArr;
	static BufferedWriter bw; 
	public static void main(String[] args) {
		GettingCombination_8_9 prc = new GettingCombination_8_9();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
//			checkArray = new int[n + 1];
			sequenceArr = new int[m];
			prc.dfs(0, 1);
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int index, int start) throws Exception {
		if(index == m) {
			for(int num : sequenceArr) {
				bw.write(num + " ");
			}
			bw.write("\n");
		}else {
			for(int i = start; i <= n; i++) {
//				if(checkArray[i] == 0) {
//					checkArray[i] = 1;
					sequenceArr[index] = i;
					dfs(index + 1, i + 1);
//					checkArray[i] = 0;
//				}
			}
		}
	}
}