package inflearn.java_algorithms.number_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TypesOfSales_4_3 {
	public static void main(String[] args) {
		TypesOfSales_4_3 prc = new TypesOfSales_4_3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(prc.solution(n, k, arr));
			bw.flush(); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String solution(int n, int k, int[] arr) {
		StringBuilder answer = new StringBuilder();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		answer.append(map.size() + " ");
		for(int i = k; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			
			
			int count = map.getOrDefault(arr[i - k], 0);
			if(count == 1) {									// 삭제 대상이 1이라면 지금까지 한번밖에 들어오지 않았기 때문에 그대로 삭제
				map.remove(arr[i - k]);
			}else {												// 삭제 대상이 1보다 많으면 지금까지 중첩 되면서 쌓였기 때문에 중첩된 것을 하나 줄이는 것으로 삭제 했다고 가정하고 진행 
				map.put(arr[i - k], count - 1);
			}
			answer.append(map.size() + " ");
		}
		
		return answer.toString().trim();
	}
}