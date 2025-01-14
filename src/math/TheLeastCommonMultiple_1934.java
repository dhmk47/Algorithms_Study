package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
public class TheLeastCommonMultiple_1934 {
	
	public static int gcd(int a, int b) {
        while(b!=0) {
            int r = a % b;

            a = b;
            b = r;
            System.out.println(a);
            System.out.println(b);
        }
        return a;
    }
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
//		int T = Integer.parseInt(br.readLine());
//		for(int i = 0; i < T; i++) {
//			st = new StringTokenizer(br.readLine());
//			int A = Integer.parseInt(st.nextToken());
//			int B = Integer.parseInt(st.nextToken());
//			int index = 0;
//			while(true) {
//				index++;
//				int result = A * index;
//				if(result % B == 0) {
//					bw.write(result + "\n");
//					break;
//				}
//			}
//		}
//		bw.flush();
//		bw.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int d = gcd(a,b);
            System.out.println("나와서" + a + b);
            sb.append(a * b/d).append('\n');
        }
        System.out.println(sb);
	}
}