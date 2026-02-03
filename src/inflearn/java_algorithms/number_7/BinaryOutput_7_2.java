package inflearn.java_algorithms.number_7;
import java.io.*;
public class BinaryOutput_7_2 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		BinaryOutput_7_2 prc = new BinaryOutput_7_2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			prc.recursive(Integer.parseInt(br.readLine()));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void recursive(int n) throws Exception {
		if(n == 0) {
			return;
		}
		recursive(n / 2);
		bw.write(String.valueOf(n % 2));
	}
}