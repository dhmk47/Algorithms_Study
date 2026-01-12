package inflearn.java_algorithms;
import java.io.*;
import java.util.StringTokenizer;

public class WordInSentence_1_3 {

	public static void main(String[] args) {
		WordInSentence_1_3 prc = new WordInSentence_1_3();
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
		StringTokenizer st = new StringTokenizer(str);
		String result = "";
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			if(result.length() < token.length()) {
				result = token;
			}
		}
		
		return result;
	}
}