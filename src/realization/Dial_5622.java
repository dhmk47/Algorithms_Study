package realization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Dial_5622 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] dialArray = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		int sum = 0;
		
		String dial = br.readLine();
		
		for(int i = 0; i < dial.length(); i++) {
			char dialChar = dial.charAt(i);
			
			for(int j = 0; j < dialArray.length; j++) {
				if(dialArray[j].indexOf(dialChar) != -1) {
					sum += j + 3;
					break;
				}
			}
		}
		
		bw.write(sum + "");
		bw.flush();
	}

}