package inflearn.java_algorithms.number_3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class SumOfConsecutiveNaturalNumbers_3_5 {
	public static void main(String[] args) {
		SumOfConsecutiveNaturalNumbers_3_5 prc = new SumOfConsecutiveNaturalNumbers_3_5();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(prc.solution(n)));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int solution(int n) {
		int[] arr = new int[n / 2 + 1];			// 입력 받은 n의 절반값 + 1까지만 더했을 때 n이 될 수 있다. 15 / 2  + 1 = 8 -> (7 + 8 = 15), (7 + 8 + 9 = 24), (8 + 9 = 17)
		int answer = 0;
		int lt = 0;
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		for(int rt = 0; rt < arr.length; rt++) {
			sum += arr[rt];

			while(sum > n) {
				sum -= arr[lt++];
			}
			
			if(sum == n) {
				answer++;
			}
		}
		
		return answer;
	}
	
	// n을 연속된 숫자를 빼고 연속된 숫자의 개수로 나눴을 때 나머지가 0이면 그건 연속된 숫자를 만들 수 있다 (수학)
	// n = 15
	// 연속된 숫자 = 1, 2, 3
	// 15 - 6 = 9
	// 9 / 3(연속된 숫자 개수) 의 나머지는 0이고 나눴을 때의 몫을 연속된 숫자에 더해주고 sum을 해보면 n이 된다
	// 따라서 1(+3) + 2(+3) + 3(+3) = 4 + 5 + 6 = 15
	private int solution_2(int n) {
		int answer = 0;
		int cnt = 1;
		
		n--;
		while(n > 0) {
			cnt++;
			n = n - cnt;
			if(n % cnt == 0) {
				answer++;
			}
		}
		
		return answer;
	}
}