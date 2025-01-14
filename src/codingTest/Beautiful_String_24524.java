package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Beautiful_String_24524 {
static boolean result;
	
	static boolean checkIndex(int size, int[] check) {
		for(int i = 0; i < size - 1; i++) {
			if(check[i] < check[i + 1]) {
				result = true;
			}else {
				result = false;
			}
		}
		return result;
	}
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args)throws IOException {
		ArrayList<Character> s = new ArrayList<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();
		for(int i = 0; i < S.length(); i++) {
			s.add(S.charAt(i));
		}
		String beautiful = br.readLine();
		int count = 0;
		int index = 0;
		int[] check = new int[beautiful.length()];
		while(s.size() != 0) {
//			int result = 0;
			for(int i = 0; i < beautiful.length(); i++) {
				index =  s.indexOf(beautiful.charAt(i));
				if(index == -1) break;
				if(i > 0) {
					if(check[i - 1] < index) {
						check[i] = s.indexOf(beautiful.charAt(i));
					}
					else {
						s.remove(index);
						check[i - 1] -= 1;
						i--;
						}
				}
				else {
					check[i] = index;
				}
			}
			if(index == -1) break;
			if(checkIndex(check.length, check)) {
				for(int i = 0; i < beautiful.length(); i++) {
					s.remove(check[(beautiful.length() - 1)- i]);
				}
				count++;
				
			}
		}
		bw.write(count+"");
		bw.flush();
		bw.close();
	}
}
