package codingTest;

import java.util.Scanner;

public class Alarm_2884 {
	public static void main(String[] args) {
		int hour = 0;
		int minute = 0;
		int early = 45;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		hour = sc.nextInt();
		minute = sc.nextInt();
		
		// 45를 빼서 음수가 된다면 실행
		if(minute - early < 0) {
			result = early - minute;
			minute = 60;
			minute -= result;
			hour--;
		}else {
			minute -= early;
		}
		if(hour < 0) {
			hour = 23;
		}
		
		System.out.println(hour +" "+ minute);
	}
}
