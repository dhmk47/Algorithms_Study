package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sugar_2839 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int subCount = 0;
		int result = 0;
		int sugar = Integer.parseInt(br.readLine());
		int sugar1 = sugar;
		int sugar2 = sugar;
		int sugar3 = sugar;

		count1 = sugar1 / 5;
		sugar1 %= 5;
		count1 += sugar1 / 3;
		sugar1 %= 3;
		
		count2 = sugar2 / 3;
		sugar2 %= 3;
		while(true) {
			sugar3 -= 5;
//			System.out.println("sugar3 중간 점검 : " + sugar3);
			subCount++;
//			System.out.println("subCount 중간 점검 : " +subCount);
			if(sugar3 % 3 == 0 && sugar3 > 0) {
				count3 = sugar3 / 3;
				count3 += subCount;
				sugar3 %= 3;
				break;
			}
			if(sugar3 < 0) {
				count3 += subCount;
				break;
			}
		}
//		sugar3 -= 5;
//		count3 = sugar3 / 3;
//		count3 += 1;
//		sugar3 %= 3;
		
		if(count1 > count2 && sugar2 == 0) {
			result = count2;
		}
		if(count1 < count2 && sugar1 == 0){
			result = count1;
		}
		if(result == 0 && sugar3 == 0) {
			result = count3;
		}

//		if(count1 < count2) {
//			result = count1;
//		}
//		else if(count1 > count2) {
//			result = count2;
//		}
		System.out.println("sugar1 :" + sugar1);
		System.out.println("sugar2 :" + sugar2);
		System.out.println("sugar3 :" + sugar3);
		System.out.println("count1 :" + count1);
		System.out.println("count2 :" + count2);
		System.out.println("count3 : " + count3);
		System.out.println("result :" + result);
		if(sugar1 != 0 && sugar2 == 0)result = count2;
		if(sugar1 == 0 && sugar2 != 0)result = count1;
		if(sugar1 != 0 && sugar2 != 0 && sugar3 != 0)result = -1;
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}
