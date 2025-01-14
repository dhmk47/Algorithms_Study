package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Treasure {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arNum1 = new int[N]; // 재정렬 가능한 배열 1
		int[] arNum2 = new int[N]; // 재정렬 불가한 배열 2
		boolean[] maxVisit = new boolean[N]; // 한번 접근한 배열의 요소에 다시 들어가지 않기 위한 변수
		boolean[] minVisit = new boolean[N]; // 위와 동일
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arNum1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arNum2[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int min = 0;
		int maxIndex = 0;
		int minIndex = 0;
		
		for(int i = 0; i < N; i++) {
			max = -1;
			min = 101;
			for(int j = 0; j < N; j++) {
				// max보다 배열의 요소가 크고 방문한적 없다면 max에 값 대입, 그 요소의 인덱스 저장
				if(arNum1[j] > max && maxVisit[j] == false) {
					max = arNum1[j];
					maxIndex = j;
				}
				// min보다 배열의 요소가 작고 방문한적 없다면 min에 값 대입, 그 요소의 인덱스 저장
				if(arNum2[j] < min && minVisit[j] == false) {
					min = arNum2[j];
					minIndex = j;
				}
			}
			// 바꾼값은 결국 minIndex에 들어있는 인덱스번호로 배열을 정렬했기에
			// minIndex를 이용해서 방문처리
			maxVisit[minIndex] = true;
			minVisit[minIndex] = true;
			// 배열 정렬
			int tmp = arNum1[maxIndex];
			arNum1[maxIndex] = arNum1[minIndex];
			arNum1[minIndex] = tmp;
		}
		
		for(int i = 0; i < N; i++) {
			result += arNum1[i] * arNum2[i];
		}
		System.out.println(result);
		
	}
}
