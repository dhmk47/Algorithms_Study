package inflearn.java_algorithms.number_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GetSubSet_7_6 {
	private static int n ;
	private static int[] ch;
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		GetSubSet_7_6 prc = new GetSubSet_7_6();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(br.readLine());
			ch = new int[n + 1];
			prc.dfs(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int l) throws Exception {
		if(l == n + 1) {
			String temp = "";
			for(int i = 1; i <= n; i++) {
				if(ch[i] == 1) {
					temp += i + " ";
				}
			}

			if(temp.length() > 0) {
				bw.write(temp + "\n");
				bw.flush();
			}
		}else {
			ch[l] = 1;
			dfs(l + 1);
			
			ch[l] = 0;
			dfs(l + 1);
		}
	}
}