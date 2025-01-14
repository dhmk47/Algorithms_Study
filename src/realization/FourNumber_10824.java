package realization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class FourNumber_10824 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String num1 = st.nextToken() + st.nextToken();
		String num3 = st.nextToken() + st.nextToken();
		long result1 = Long.parseLong(num1);
		long result2 = Long.parseLong(num3);
		
		bw.write(result1 + result2 + "");
		bw.flush();
		bw.close();
	}
}