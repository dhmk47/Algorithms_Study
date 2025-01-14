package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Meeting_Room_1931 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int index = 0;
		int [][] arNum = new int[N][2];
		int [] temp = new int[2];
		int count = 1;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arNum[i][0] = Integer.parseInt(st.nextToken());
			arNum[i][1] = Integer.parseInt(st.nextToken()); 
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				if(arNum[i][0] == arNum[j + 1][0]) {
					if(arNum[i][1] > arNum[j + 1][1]) {
						temp[0] = arNum[i][0];
						temp[1] = arNum[i][1];
						arNum[i][0] = arNum[j + 1][0];
						arNum[i][1] = arNum[j + 1][1];
					}
				}
			}
		}
		
		for(int i = 0; i < 1; i++) {
			for(int j = 0; j < N - 1; j++) {
				if(arNum[index][1] <= arNum[j + 1][0]) {
//					if(arNum[j + 1][0] == arNum[j + 1][1]) count--;
					count++;
					if(arNum[j +1][0] > arNum[j + 1][1])count--;
					System.out.println("회의시간 : " + arNum[index][0] +" "+ arNum[index][1] +" "+ arNum[j + 1][0] +" "+ arNum[j + 1][1]);
					if(!(arNum[j +1][0] > arNum[j + 1][1]))index = j + 1;
					
//					if(index == 0)index ++;
				}
			}
		}
//		System.out.println(count);
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
}
