package codingTest;

import java.util.Scanner;

//윷놀이

public class Yut_2490 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [][] n = new String[3][1];
		String [] o = new String[1];
		String f = "";
		int index = 0;
		int cnt = 0;
		char score = ' ';
		
		for(int i = 0; i < n.length; i++) {
			for(int j = 0; j < n[0].length; j++) {
				n[i][j] = sc.nextLine();
			}
		}
		for(int i = 0; i < n.length; i++) {
			o = n[i];
			f = o[0].toString().replaceAll(" " , "");
			index = 0;
			cnt = 0;
			for(int j = 0; j < 4; j++) {
				if(f.charAt(index) == '0') {
					cnt++;
				}
				index++;
				switch(cnt) {
				case 1:
					score = 'A';
					break;
				case 2:
					score = 'B';
					break;
				case 3:
					score = 'C';
					break;
				case 4:
					score = 'D';
					break;
				default :
					score = 'E';
				}
			}
			System.out.println(score);
		}
	}
}
