package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

public class RoomNumber_1475 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ArrayList<Integer> ar6 = new ArrayList<Integer>();
		int count = 0;
		int max = 0;
		int ar6Count = 0;
//		int result = 0;
		String number = br.readLine(); // 내가 필요한 번호
		for(int i = 0; i < number.length(); i++) {
			if(number.charAt(i) == '6' || number.charAt(i) =='9') // 6, 9는 다른 배열에 저장
				ar6.add(number.charAt(i) - '0');
			else
				ar.add(number.charAt(i) - '0'); // String을 ArrayList타입으로 변형
		}
		Collections.sort(ar);
		
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < ar.size(); j++) {
				if(ar.get(j) == i) count++; // 현재 배열이 i와 같다면 count++
			}
			if(max < count) max = count; // count가 많다면 max에 대입
			count = 0; // 다시 0으로 초기화
		}
		
		if(ar6.size() % 2 == 0 ) // 크기가 4라면 나누기2
			ar6Count = ar6.size() / 2;
		else // 그게 아니면 나눈값에서 1을 더함 예) 5개라면 총 3번을 돌아야 하므로 나눈값에서 1을 더함
			ar6Count = (ar6.size() / 2) + 1;
		
//		if(max > ar6Count)
//			result = max;
//		else
//			result = ar6Count;
			
		System.out.println(Math.max(max, ar6Count));
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int[] arr1 = new int[9];
//		int  arr2 = 0;
//		String str = br.readLine();
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) - '0' == 6 || str.charAt(i) - '0' == 9) {
//				arr2++;
//			} else {
//				arr1[(int) str.charAt(i) - '0']++;
//			}
//		}
//		Arrays.sort(arr1);
//		if (arr2 % 2 == 0)
//			System.out.println(Math.max(arr2 / 2, arr1[8]));
//		else
//			System.out.println(Math.max(arr2 / 2 + 1, arr1[8]));
		
	}
}
