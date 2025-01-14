package dfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JumpJump_14248 {
	int[] node = null;
	boolean[] visit = null;
	int nodeSize = 0;
	int start = 0;
	
	public static void main(String[] args) {
		JumpJump_14248 prc = new JumpJump_14248();
		prc.run();
	}
	
	private void run() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			initNode();
			
			int jumpValue = node[start];
			visit[start] = true;
			
			dfs(start + jumpValue);
			dfs(start - jumpValue);
			
			int count = 0;
			for(int i = 0; i < visit.length; i++) {
				if(visit[i]) {
					count++;
				}
			}
			
			bw.write(count + "");
			bw.flush();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dfs(int move) {
		if(outOfIndex(move)) {
			return;
		}
		
		if(!visit[move]) {
			visit[move] = true;
			
			int jumpValue = node[move];
			
			dfs(move + jumpValue);
			dfs(move - jumpValue);
		}
	}
	
	private boolean outOfIndex(int move) {
		return move < 0 || move >= nodeSize;
	}
	
	private void initNode() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		nodeSize = Integer.parseInt(br.readLine());
		
		
		node = new int[nodeSize];
		visit = new boolean[nodeSize];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < nodeSize; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		
		start = Integer.parseInt(br.readLine()) - 1;
	}
}