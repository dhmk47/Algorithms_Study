package realization;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class StringInfo_10820 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = "";
		
			while((S = br.readLine()) != null) {
				int[] search = new int[4];
				for(int j = 0; j < S.length(); j++) {
					char c = S.charAt(j);
					// 소문자
					if(c > 96)
						search[0]++;
					// 대문자
					else if(c > 64)
						search[1]++;
					// 숫자
					else if(c > 47)
						search[2]++;
					// 공백
					else
						search[3]++;
				}
				for(int j : search) {
					bw.write(j + " ");
				}
				bw.write("\n");
				bw.flush();
			}
//		bw.close();
	}
}