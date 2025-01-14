package codingTest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.Scanner;
import java.util.StringTokenizer;
public class Ant_3048 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
//		int A = 0;
//		int B = 0;
//		String A_Group = "";
//		String B_Group = "";
//		int temp = 0;
//		char cTemp = ' ';
//		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
//		st = new StringTokenizer(AB);
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
//		A = sc.nextInt();
//		B = sc.nextInt();
		
		String A_Group = br.readLine();
		String B_Group = br.readLine();
//		A_Group = sc.next();
//		B_Group = sc.next();
		int count = Integer.parseInt(br.readLine());
//		int count = sc.nextInt();
		int [] ar = new int[A + B];
		char [] chr = new char[A +B];
		for(int i = 0; i < A_Group.length(); i++) {
			chr[i] = A_Group.charAt(A - i - 1);
			ar[i] = 0;
		}
		for(int j = 0; j < B_Group.length(); j++) {
			chr[j + A_Group.length()] = B_Group.charAt(j);
			ar[j + A_Group.length()] = 1;
		}
		
		while(count > 0) {
			count--;
			for(int i = 0; i < chr.length - 1; i++) {
				if(ar[i] == 0 && ar[i+1] == 1) {
					int temp = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = temp;
					char cTemp = chr[i];
					chr[i] = chr[i + 1];
					chr[i + 1] = cTemp;
					i++;
				}
			}
		}
//		for(int i = 0; i < ar.length; i++) {
//			System.out.print(chr[i]);
//		}
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]);
		}
		System.out.println();
		bw.write(chr);
		bw.flush();
		bw.close();
	}
}