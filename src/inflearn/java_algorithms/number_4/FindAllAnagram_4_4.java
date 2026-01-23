package inflearn.java_algorithms.number_4;
import java.io.*;
import java.util.HashMap;

public class FindAllAnagram_4_4 {
	public static void main(String[] args) {
		FindAllAnagram_4_4 prc = new FindAllAnagram_4_4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(String.valueOf(prc.solution(br.readLine(), br.readLine())));
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private int solution(String str, String targetStr) {
		int answer = 0;
		
		HashMap<Character, Integer> answerMap = new HashMap<>();
		for(char c : targetStr.toCharArray()) {
			answerMap.put(c, answerMap.getOrDefault(c, 0) + 1);
		}
		
		
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < targetStr.length() - 1; i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}
		
		int lt = 0;
		for(int rt = targetStr.length() - 1; rt < str.length(); rt++) {				// 처음에 무조건 answer++
			answer++;
			map.put(str.charAt(rt), map.getOrDefault(str.charAt(rt), 0) + 1);
			
			for(Character c : map.keySet()) {										// 정답이 담긴 map과 수량비교
				if(map.getOrDefault(c, 0) != answerMap.getOrDefault(c, 0)) {
					answer--;
					break;
				}
			}
			
			map.put(str.charAt(lt), map.get(str.charAt(lt)) - 1);					// lt의 값 1을 빼고 0이라면 삭제
			if(map.get(str.charAt(lt)) == 0) {
				map.remove(str.charAt(lt));
			}
			lt++;
		}
		
		return answer;
	}
}