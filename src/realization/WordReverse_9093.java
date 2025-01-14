package realization;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class WordReverse_9093 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> s = new Stack<>();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			str += " "; // 공백기준으로 출력하기때문에 마지막에 공백 추가
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == ' ') { // 공백이라면
					while(!s.isEmpty()) { // 스택에 요소가 있다면
						bw.write(s.pop()); // 출력
					}
					bw.write(" "); // 그 후 공백 출력
				}else {
					s.add(str.charAt(j)); // 공백이 아니라면 스택에 추가
				}
			}
			bw.write("\n");;
			bw.flush();
		}
		bw.close();
	}
}