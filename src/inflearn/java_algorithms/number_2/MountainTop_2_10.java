package inflearn.java_algorithms.number_2;
import java.io.*;
import java.util.StringTokenizer;
public class MountainTop_2_10 {
	public static void main(String[] args) {
		MountainTop_2_10 prc = new MountainTop_2_10();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			int[][] arr = new int[count + 2][count + 2];
			
			for(int i = 1; i < arr.length - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j < arr[i].length - 1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bw.write(String.valueOf(prc.solution(count, arr)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private int solution(int count, int[][] arr) {
		int answer = 0;
		
		for(int i = 1; i < arr.length - 1; i++) {
			for(int j = 1; j < arr[i].length - 1; j++) {
				if(
						arr[i][j] > arr[i - 1][j]
				 	 && arr[i][j] > arr[i + 1][j]
					 && arr[i][j] > arr[i][j - 1]
					 && arr[i][j] > arr[i][j + 1]
				) {
					answer++;
				}
			}
		}
		
		return answer;
	}

}