package codingTest;

import java.util.Scanner;

public class Atm_11399 {
	public static void main(String[] args) {
		int [] n;
		int [] sum;
		int result = 0;
		int index = 0;
		Scanner sc = new Scanner(System.in);
		int person = sc.nextInt();
		n = new int[person];
		sum = new int[person];
		
		for(int i = 0; i < person; i++) {
			n[i] = sc.nextInt();
		}
		
		for(int i = 0; i < person; i++) {
			int min = 9999;
			for(int j = i; j < person; j++) {
				if(min > n[j]) {
					min = n[j];
					index = j;
				}
			}
			int temp = n[i];
			n[i] = n[index];
			n[index] = temp;
		}
		
		for(int i = 0; i < person; i++) {
			if(i > 0) {
				sum[i] = sum[i - 1] + n[i];
			}else{
				sum[i] = n[i];
			}
		}
		for(int i = 0; i < sum.length; i++) {
			result += sum[i];
		}
		System.out.println(result);
	}
}
