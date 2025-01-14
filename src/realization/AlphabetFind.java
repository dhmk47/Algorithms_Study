package realization;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class AlphabetFind {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		int[] alp = new int[26];

		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < input.length(); j++) {
				if('a' + i == input.charAt(j)) {
					alp[i] = j;
					break;
				}else {
					alp[i] = -1;
				}
			}
			bw.write(alp[i] + " ");
		}
		bw.flush();
		bw.close();
	}
}