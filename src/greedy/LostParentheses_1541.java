package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class LostParentheses_1541 {

	public static void main(String[] args) {
		LostParentheses_1541 prc = new LostParentheses_1541();
		prc.run();
	}
	
	private void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String input = br.readLine();
			
			StringBuffer number = new StringBuffer();
			int plusNumberSum = 0;
			int result = 0;
			
			boolean plusAdd = false;
			boolean hasMinus = false;
			boolean firstIsMinus = true;
			for(int i = 0; i < input.length(); i++) {
				
				char c = input.charAt(i);
				if(c >= '0' && c <= '9') {
					number.append(input.charAt(i));
					
				}else {
					if(c == '+') {
						plusNumberSum += Integer.parseInt(number.toString());
						plusAdd = true;
						firstIsMinus = false;
					}else if(plusAdd) {
						plusNumberSum += Integer.parseInt(number.toString());
						plusAdd = false;
						firstIsMinus = false;
					}else {
						hasMinus = true;
						if(firstIsMinus) {
							result = Integer.parseInt(number.toString());
						}else {
							plusNumberSum -= Integer.parseInt(number.toString());
						}
					}
					number = new StringBuffer();
				}
			}
			
			if(plusAdd) {
				plusNumberSum += Integer.parseInt(number.toString());
			}else {
				plusNumberSum -= Integer.parseInt(number.toString());
			}
			
			System.out.println("plusNumberSum: " + plusNumberSum);
			
			result = hasMinus ? result -= plusNumberSum : plusNumberSum;
			System.out.println("result: " + result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}