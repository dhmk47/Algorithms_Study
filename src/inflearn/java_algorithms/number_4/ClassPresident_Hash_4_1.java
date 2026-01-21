package inflearn.java_algorithms.number_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;

public class ClassPresident_Hash_4_1 {
	public static void main(String[] args) {
		ClassPresident_Hash_4_1 prc = new ClassPresident_Hash_4_1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			char[] arr = new char[n];
			
			String str = br.readLine();
			
			for(int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}
			
			bw.write(prc.solution(n, arr));
			bw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private String solution(int n, char[] arr) {
		String answer = "";
		int max = 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : arr) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}else {
				map.put(c, 1);
			}
		}
		
		Iterator<Character> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			char c = iterator.next();
			
			int count = map.get(c);
			
			if(count > max) {
				answer = String.valueOf(c);
				max = count;
			}
		}
		
		return answer;
	}
}