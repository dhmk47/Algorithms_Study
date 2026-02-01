package codingTest;
import java.util.*;
import java.io.*;

public class OX_Quiz_8958 {

    public static void main(String[] args) {
    	OX_Quiz_8958 prc = new OX_Quiz_8958();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());
            List<String> strList = new ArrayList<>();
            
            for(int i = 0; i < n; i++) {
                strList.add(br.readLine());
            }
            for(int num : prc.solution(n, strList)) {
                bw.write(num + "\n");
            }
            bw.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private List<Integer> solution(int n, List<String> strList) {
        List<Integer> answer = new ArrayList<>();

        for(String str : strList) {
            int score = 0;
            int sum = 0;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == 'O') {
                    score++;
                }else {
                    score = 0;
                }
                sum += score;
            }

            answer.add(sum);
        }

        return answer;
    }
}