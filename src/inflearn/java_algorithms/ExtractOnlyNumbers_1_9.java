package inflearn.java_algorithms;
import java.io.*;
public class ExtractOnlyNumbers_1_9 {

	public static void main(String[] args) {
		ExtractOnlyNumbers_1_9 prc = new ExtractOnlyNumbers_1_9();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(prc.solution(br.readLine()));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(String str) {
		StringBuilder result = new StringBuilder();
		
		int count = 1;
		for(int i = 0; i < str.length(); i++) {
			if(i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {		// i의 다음과 비교 후 같으면 count 누적 (i + 1이 str.lengh()보다 크면 끝지점이기 때문에 count 누적할 필요없이 else로 보내서 입력)
				count++;
			}else {																	// 다르면 i의 문자 입력 후 count가 1보다 많으면 count도 입력
				result.append(str.charAt(i));
				if(count > 1) {
					result.append(count);
				}
				count = 1;
			}
		}
		return result.toString();
	}
}