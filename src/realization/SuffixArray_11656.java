package realization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;

public class SuffixArray_11656 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		ArrayList<String> strArray = new ArrayList<>();
		sb.append(br.readLine());
		int size = sb.length();
		
		for(int i = 0; i < size; i++) {
			strArray.add(sb.toString());
			sb.delete(0, 1);
		}
		
		Collections.sort(strArray);
//		strArray.sort(Comparator.naturalOrder());
		
		for(String str : strArray) {
			bw.write(str);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}