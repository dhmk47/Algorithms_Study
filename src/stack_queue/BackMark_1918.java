package stack_queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BackMark_1918 {
    public static void main(String[] args) {
    	BackMark_1918 prc = new BackMark_1918();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            bw.write(prc.solution(br.readLine()));
            bw.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private String solution(String str) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int mustPush = 0;
        for(char c : str.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                answer.append(c);
            }else {
                if(c == '+' || c == '-') {
                    while(!stack.isEmpty() && mustPush == 0) {
                        answer.append(stack.pop());
                    }
                    stack.push(c);
                }else if(c == '*' || c == '/') {
                    while(!stack.isEmpty() && mustPush == 0 && stack.peek() != '+' && stack.peek() != '-') {
                        answer.append(stack.pop());
                    }
                    stack.push(c);
                }else if(c == '(') {
                    mustPush++;
                    stack.push(c);
                }else if(c == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        answer.append(stack.pop());
                    }
                    stack.pop();
                    mustPush--;
                }
            }
        }
        while(!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.toString();
    }
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		Stack<Character> stack = new Stack<>();
//		String str = br.readLine();
//		str += " ";
//		StringBuilder sb = new StringBuilder();
//		boolean firstFlag = false;
//		boolean secondFlag = false;
//		
//		for(int i = 0; i < str.length() - 1; i++) {
//			char ch = str.charAt(i);
//			if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
//				stack.push(ch);
//			}
//			else {
//				if(!firstFlag) {
//					firstFlag = true;
//					sb.append(ch);
//				}
//				else if(ch == '(') {
//					sb.append(ch);
//					secondFlag = true;
//					firstFlag = false;
//				}
//				else if(ch == ')') {
//					sb.append(ch);
//					secondFlag = false;
//					firstFlag = true;
//					sb.append(stack.pop());
//					String result = sb.toString().replaceAll("[()]", "");
//					sb.delete(0, sb.length());
//					bw.write(result);
//				}
//				else if(secondFlag) {
//					sb.append(ch);
//				}
//				else if(firstFlag && str.charAt(i + 1) == '*' || str.charAt(i + 1) == '/') {
//					sb.append(ch);
//				}
//				else if(firstFlag && str.charAt(i + 1) == '+' || str.charAt(i + 1) == '-' || str.charAt(i + 1) == ' ') {
//					sb.append(ch);
//					firstFlag = false;
//					while(!stack.isEmpty()) {
//						sb.append(stack.pop());
//					}
//					String result = sb.toString().replaceAll("[()]", "");
//					sb.delete(0, sb.length());
//					bw.write(result);
//				}
//			}
//		}
//		
//		while(!stack.isEmpty()) {		// �ㅽ���� �⑥������ 寃쎌�� ��遺� 異���
//			while(!stack.isEmpty()) {
//				sb.append(stack.pop());
//			}
//			String result = sb.toString();
//			result = result.replaceAll("[()]", "");
//			bw.write(result);
//		}
//		bw.flush();
//		bw.close();
//		// A+B+C*D+E+(H+G)*L
//		
//		// AB+CD*+EHG+L*++
//	}
}