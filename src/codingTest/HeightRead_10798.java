package codingTest;

import java.util.Scanner;

public class HeightRead_10798 {
	// 세로읽기
	public static void main(String[] args) {
		String [][] n = new String[5][1];
		Scanner sc = new Scanner(System.in);
		int rLength = n.length;
		int cLength = n[0].length;
		
		for(int i = 0; i < rLength; i++) {
			for(int j = 0; j < cLength; j++) {
				n[i][j] = sc.nextLine();
			}
		}
		
		String [] arList = new String[1];
		String str = "";
		String result = "";
		int index = 0;
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				arList = n[j]; // 2차원배열에 한번 접근해서 1차원배열에 대입
				str = arList[0].toString(); // 1차원배열을 문자열로 변환
				if (str.length() <= index) continue; //  // 그 문자열이 index보다 작거나 같다면 다음 반복으로
//				if(str.charAt(index) == ' ') continue; // 공백포함
				result += str.charAt(index); // 문자열의 index번째 문자를 result에 누적대입
//				System.out.println(result);
			}
			index++; // 문자열의 인덱스번호를 담당하는 변수
//			index = 0;
		}
		System.out.println(result);
	}
}
