package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Number_Less_than_X_10871 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
			String [] arNum = br.readLine().split(" ");
			for(int i = 0; i < A; i++) {
			if(Integer.parseInt(arNum[i]) < X) {
				bw.write(arNum[i] + " ");
			}
		}
		bw.close();
	}
}