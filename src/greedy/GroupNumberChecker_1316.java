package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GroupNumberChecker_1316 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Character> arr = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		char tmp = ' ';
		int count = 0;
		char arrTmp = ' ';
		boolean check = false;
		for(int i = 0; i < N; i++) {
			String word = br.readLine(); // i 번째 단어 입력
			tmp = ' '; // 새롭게 초기화
			for(int j = 0; j < word.length(); j++) {
				if(word.charAt(j) == tmp) continue; // j번째 인덱스의 문자가 같다면 continue
				else {
					tmp = word.charAt(j); // 아니라면 새로 대입 후
					arr.add(word.charAt(j)); // ArrayList에 추가
				}
			}
			
			arrTmp = ' '; // 새롭게 초기화
			check = false;
			for(int k = 0; k < arr.size(); k++) {
				for(int o = k; o < arr.size(); o++) {
					if(arrTmp == arr.get(o)) { // 같다면 중복 단어가 있다는 뜻
						count++;
						check = true; // 중복이라면 더 이상 확인 할 필요 X
						break;
					}
					else arrTmp = arr.get(k); // 그게 아니면 새롭게 대입
				}
				if(check) break;
			}
			arr.clear(); // ArrayList clear
		}
		System.out.println(N - count);
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int cnt=0;
//		char temp='\0';
//		int [] arrInt = new int [26];
//		int n=Integer.parseInt(br.readLine());
//		for (int i=0;i<n;i++) {
//			char [] arr= br.readLine().toCharArray();
//			for (int j=0;j<arrInt.length;j++) {
//				arrInt[j]=0;
//			}
//			for (int j=0;j<arr.length;j++) {
//				if (arrInt[arr[j]-'a']>=1 && arr[j]!=temp) {
//					cnt++;
//					break;
//				}
//				arrInt[arr[j]-'a']++;
//				temp=arr[j];
//			}
//		}
//		System.out.print(n-cnt);
	}
}
