package dynamic_progamming;
import java.io.*;
import java.util.StringTokenizer;

/*
 * 
8
1 50
3 30
2 50
4 30
1 30
3 30
3 50
2 100
 * 
 * */


public class Resignation_14501 {
	public static void main(String[] args) {
		Resignation_14501 prc = new Resignation_14501();
		
		try {
			prc.run();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int remainDay = Integer.parseInt(br.readLine()) + 1;
		
		int[] schedule = new int[remainDay];
		int[] reward = new int[remainDay];
		int[] result = new int[remainDay];
		
		setScheduleAndReward(remainDay, schedule, reward, br);
		
		for(int i = 1; i < remainDay; i++) {
			int targetIndex = i;
			
			int targetSchedule = schedule[i] + targetIndex - 1;
			int targetReward = reward[i];
			
			for(int j = targetIndex; j < remainDay; j++) {
//				if(j == remainDay) {
//					break;
//				}
				System.out.println("j: " + j);
				System.out.println("targetSchedule: " + targetSchedule);
				
				
//				if(j < targetIndex - 1 + targetSchedule) {
				if(j < targetSchedule) {
					if(result[j] < targetReward) {
						result[j] = result[j - 1];
					}
//						targetIndex++;
					continue;
				}
				
				if(result[j] < targetReward) {
					result[j] = targetReward + result[j - 1];
					System.out.println("reward!");
				}
//				System.out.println(j);
//				System.out.println(targetIndex);
//				System.out.println(targetSchedule);
//				System.out.println(targetIndex - 1 + targetSchedule);
				if( (j + 1) >= remainDay) {
					break;
				}
//					targetIndex++;
				
//				targetIndex += j;
//				if(j >= remainDay) {
//					break;
//				}
				targetSchedule = schedule[j] + j;
				targetReward = reward[j];
				
//				System.out.println("targetIndex: " + targetIndex);
//				System.out.println("j: " + j);
//				System.out.println("targetReward: " + targetReward);
			}
			
			for(int test : result) {
				System.out.print(test + " ");
			}

			System.out.println();
//			break;
		}
		
		int answer = result[remainDay - 1];
		
		bw.write(String.valueOf(answer) + "\n");
		bw.flush();
//		bw.close();
	}
	
	private void setScheduleAndReward(int remainDay, int[] schedule, int[] reward, BufferedReader br) throws Exception{
		StringTokenizer st = null;
		
		for(int i = 1 ; i < remainDay; i++) {
			st = new StringTokenizer(br.readLine());
			
			schedule[i] = Integer.parseInt(st.nextToken());
			reward[i] = Integer.parseInt(st.nextToken());
		}
	}
}