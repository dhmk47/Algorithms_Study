package realization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class AlphabetCount {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] count = new int[26];
		String S = br.readLine();
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < S.length(); j++) {
				if(S.charAt(j) == (i + 'a')) {
					count[i]++;
				}
			}
			bw.write(count[i] + " ");
		}
		bw.flush();
		bw.close();
	}
}