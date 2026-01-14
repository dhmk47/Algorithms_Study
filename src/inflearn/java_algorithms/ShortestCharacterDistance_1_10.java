package inflearn.java_algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ShortestCharacterDistance_1_10 {

	public static void main(String[] args) {
		ShortestCharacterDistance_1_10 prc = new ShortestCharacterDistance_1_10();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			
//			bw.write(prc.solution(st.nextToken(), st.nextToken()));
			
			for(int number : prc.solution_2(st.nextToken(), st.nextToken())) {
				bw.write(number + " ");
			}
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(String str, String target) {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			if(result.length() > 0) {
				result.append(" ");
			}
			
			if(String.valueOf(str.charAt(i)).equals(target)) {				// 찾는 문자와 같으면 바로 0
				result.append("0");
			}else {
				String frontStr = str.substring(0, i);						// 현재 문자를 기준으로 앞 뒤 자름
				String backStr = str.substring(i + 1);
				
				int frontStrIndex = frontStr.lastIndexOf(target);
				int backStrIndex = backStr.indexOf(target);
				
				if(frontStrIndex == -1) {												// 못 찾았을 때 계산하지 않기 위함
					frontStrIndex = Integer.MAX_VALUE;
				}else {
					frontStrIndex = frontStr.length() - frontStr.lastIndexOf(target);	// 뒤에서부터 탐색 후 길이 - 인덱스 번호로 현재 문자와 떨어진 거리를 계산
				}
				
				
				if(backStrIndex == -1) {												// 못 찾았을 때 계산하지 않기 위함
					backStrIndex = Integer.MAX_VALUE;
				}else {
					backStrIndex = backStr.indexOf(target) + 1;							// 인덱스는 0부터 시작해서 + 1
				}
				
				
				result.append(frontStrIndex > backStrIndex ? backStrIndex : frontStrIndex);
			}
		}
		
		return result.toString();
	}
	
	private int[] solution_2(String str, String target) {
		int[] answer = new int[str.length()];
		
		int p = 1000;
		for(int i = 0; i < str.length(); i++) {
			if(String.valueOf(str.charAt(i)).equals(target)) {
				p = 0;
				answer[i] = p;
			}else {
				p++;
				answer[i] = p;
			}
		}
		p = 1000;
		for(int i = str.length() - 1; i >= 0; i--) {
			if(String.valueOf(str.charAt(i)).equals(target)) {
				p = 0;
			}else {
				p++;
				answer[i] = Math.min(answer[i], p);
			}
		}
		
		return answer;
	}
}
