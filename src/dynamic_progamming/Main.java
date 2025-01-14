package dynamic_progamming;
import java.io.*;
import java.util.StringTokenizer;
public class Main{
	
	static void add(int num1, int num2) {
		System.out.println(num1 + num2);
	}
	
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < T; i++) {
        	st = new StringTokenizer(br.readLine());
        	add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
}