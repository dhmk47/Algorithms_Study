package greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class Library {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int value = 0;
		int result = 0;
		int max = 0;
		ArrayList<Integer> booksP = new ArrayList<>();
		ArrayList<Integer> booksM = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			value = Integer.parseInt(st.nextToken());
			if(value > 0) {
				booksP.add(value);
			}else booksM.add(value *-1);
		}
		Collections.sort(booksP, Collections.reverseOrder());
		Collections.sort(booksM, Collections.reverseOrder());
		
        // 마지막으로 갈 최대의 값은 곱하기를 하지 않기때문에 미리 저장해줍니다.
		if(booksP.isEmpty()) max = booksM.get(0);
		else if(booksM.isEmpty()) max = booksP.get(0);
		else max = Math.max(booksP.get(0), booksM.get(0));
		
		while(!booksP.isEmpty()) {
			result += booksP.get(0) * 2;
			for(int i = 0; i < M; i++) {
				if(booksP.isEmpty()) break;
				
				booksP.remove(0);
			}
		}
		
		while(!booksM.isEmpty()) {
			result += booksM.get(0) * 2;
			for(int i = 0; i < M; i++) {
				if(booksM.isEmpty()) break;
				
				booksM.remove(0);
			}
		}
		
		result -= max; // 제일 큰 값은 마지막으로 갈 것이고 다시 돌아올 필요 없기때문에 -합니다
		
		System.out.println(result);
	}
}