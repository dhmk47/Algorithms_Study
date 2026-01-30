package inflearn.java_algorithms.number_6;
import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
	int x = 0;
	int y = 0;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.x == o.x) {
			return this.y - o.y;
		}else {
			return this.x - o.x;
		}
	}
}
public class CoordinateSort_6_7 {
	public static void main(String[] args) {
		CoordinateSort_6_7 prc = new CoordinateSort_6_7();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][2];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int[] result : prc.solution(n, arr)) {
				bw.write(result[0] + " " + result[1] + "\n");
			}
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			int n = Integer.parseInt(br.readLine());
//			List<Point> list = new ArrayList<>();
//			
//			for(int i = 0; i < n; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
//			}
//			
//			Collections.sort(list);
//			for(Point point : list) {
//				bw.write(point.x + " " + point.y + "\n");
//			}
//			bw.flush();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	private int[][] solution(int n, int[][] arr) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
				if(arr[j][0] > arr[j + 1][0]) {
					int[] temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
				}else if(arr[j][0] == arr[j + 1][0]) {
					if(arr[j][1] > arr[j + 1][1]) {
						int[] temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
		}
		
		return arr;
	}
}