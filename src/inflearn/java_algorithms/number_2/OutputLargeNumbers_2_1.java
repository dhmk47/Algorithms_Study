package inflearn.java_algorithms.number_2;
import java.io.*;
public class OutputLargeNumbers_2_1 {
	
	public static void main(String[] args) {
		OutputLargeNumbers_2_1 prc = new OutputLargeNumbers_2_1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			int[] numberArray = new int[count];
			int index = 0;
			
			for(String number : br.readLine().split(" ")) {
				numberArray[index++] = Integer.parseInt(number);
			}
			
			bw.write(prc.solution(numberArray));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(int[] numberArray) {
		StringBuilder answer = new StringBuilder();
		
		int preValue = Integer.MIN_VALUE;
		
		for(int number : numberArray) {
			if(preValue < number) {
				answer.append(number + " ");
			}
			preValue = number;
		}
		
		return answer.toString();
	}

}