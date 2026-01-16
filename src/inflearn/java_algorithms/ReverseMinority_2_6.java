package inflearn.java_algorithms;
import java.io.*;
public class ReverseMinority_2_6 {

	public static void main(String[] args) {
		ReverseMinority_2_6 prc = new ReverseMinority_2_6();
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
		
		for(int number : numberArray) {
			int result = 0;
			
			int temp = number;
			while(temp > 0) {
				int t = temp % 10;		// 1의 자리
				result = result * 10 + t;
				temp = temp / 10;
			}
			
			if(isPrime(result)) {
				if(answer.length() > 0) {
					answer.append(" ");
				}
				answer.append(result);
			}
		}
		
		return answer.toString();
	}
	
	private boolean isPrime(int number) {
		// 1은 무조건 소수가 아니다.
		if(number == 1) {
			return false;
		}
		
		// 2부터 number - 1 전까지 약수가 하나라도 있으면 그건 소수가 아니다. 
		for(int i = 2; i < number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}