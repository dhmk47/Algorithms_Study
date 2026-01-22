package inflearn.java_algorithms.number_4;
import java.io.*;
import java.util.HashMap;

public class Anagram_Hash_4_2 {
	public static void main(String[] args) {
		Anagram_Hash_4_2 prc = new Anagram_Hash_4_2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(prc.solution(br.readLine(), br.readLine()));
			bw.flush(); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(String firstStr, String secondStr) {
		String answer = "YES";
		
		HashMap<Character, Integer> firstStrMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> secondStrMap = new HashMap<Character, Integer>();
		
		for(char c : firstStr.toCharArray()) {
			firstStrMap.put(c, firstStrMap.getOrDefault(c, 0) + 1);
		}
		for(char c : secondStr.toCharArray()) {
			secondStrMap.put(c, secondStrMap.getOrDefault(c, 0) + 1);
		}
		
		if(firstStrMap.size() != secondStrMap.size()) {
			return "NO";
		}
		
		for(char c : firstStrMap.keySet()) {
			if(firstStrMap.getOrDefault(c, -1) != secondStrMap.getOrDefault(c, -1)) {
				answer = "NO";
				break;
			}
		}
		
		return answer;
	}
}
