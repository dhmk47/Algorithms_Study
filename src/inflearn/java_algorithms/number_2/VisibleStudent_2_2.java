package inflearn.java_algorithms.number_2;
import java.io.*;
public class VisibleStudent_2_2 {
	
	public static void main(String[] args) {
		VisibleStudent_2_2 prc = new VisibleStudent_2_2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			int[] heightArray = new int[count];
			int index = 0;
			
			for(String height : br.readLine().split(" ")) {
				heightArray[index++] = Integer.parseInt(height);
			}
			
			bw.write(prc.solution(heightArray) + "");
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int[] heightArray) {
		int answer = 0;
		
		int maxHeight = Integer.MIN_VALUE;
		
		for(int height : heightArray) {
			if(maxHeight < height) {
				answer++;
				
				maxHeight = height;
			}
		}
		
		return answer;
	}
}