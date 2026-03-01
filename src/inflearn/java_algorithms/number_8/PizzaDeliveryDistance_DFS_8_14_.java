package inflearn.java_algorithms.number_8;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node_8_14 {
	int y, x;
	
	Node_8_14(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class PizzaDeliveryDistance_DFS_8_14_ {
	static int n,m;
	static List<Node_8_14> allHouseNodeList;
	static List<Node_8_14> allPizzaNodeList;
	static Node_8_14[] alivePizzaHouseArray;
	static int answer = Integer.MAX_VALUE;
	static boolean[][] visit;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) {
		PizzaDeliveryDistance_DFS_8_14_ prc = new PizzaDeliveryDistance_DFS_8_14_();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			alivePizzaHouseArray = new Node_8_14[m];
			allHouseNodeList = new ArrayList<>();
			allPizzaNodeList = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					int number = Integer.parseInt(st.nextToken());
					
					if(number == 1) {
						allHouseNodeList.add(new Node_8_14(i, j));
					}else if(number == 2) {
						allPizzaNodeList.add(new Node_8_14(i, j));
					}
				}
			}
			
			prc.dfs(0, 0);
			
			bw.write(String.valueOf(answer));
			bw.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 조합 생성
	private void dfs(int index, int start) {
		if(index == m) {
//			int minDistance = 0;
//			 생성된 조합으로 탐색
//			for(Node_8_14 houseNode : allHouseNodeList) {
//				minDistance += bfs(houseNode, houseNode.y, houseNode.x);
//			}
			// 생성된 조합으로 최소 피자가게 거리를 구해서 answer와 비교하여 작은값을 저장
//			answer = Math.min(answer, minDistance);
			

			int sum = 0;
			for(Node_8_14 houseNode : allHouseNodeList) {
				int minDistance = Integer.MAX_VALUE;
				for(Node_8_14 pizzaNode : alivePizzaHouseArray) {
					minDistance = Math.min(minDistance, Math.abs(houseNode.y - pizzaNode.y) + Math.abs(houseNode.x - pizzaNode.x));
				}
				sum += minDistance;
			}
			answer = Math.min(answer, sum);
			
		}else {
			for(int i = start; i < allPizzaNodeList.size(); i++) {
				alivePizzaHouseArray[index] = allPizzaNodeList.get(i);
				dfs(index + 1, i + 1);
			}
		}
	}
	
	private int bfs(Node_8_14 houseNode, int startY, int startX) {
		// 각 집마다 방문처리 초기화
		visit = new boolean[n][n];
		
		Queue<Node_8_14> q = new LinkedList<>();
		q.offer(houseNode);
		while(!q.isEmpty()) {
			Node_8_14 currentNode = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = dy[i] + currentNode.y;
				int nx = dx[i] + currentNode.x;
				
				if(isValidIndex(ny, nx) && !visit[ny][nx]) {
					for(Node_8_14 pizzaNode : alivePizzaHouseArray) {
						// 생존한 피자가게 좌표와 다음 이동할 좌표가 같을 때
						if(pizzaNode.y == ny && pizzaNode.x == nx) {
							int distanceY = Math.abs(startY - ny);
							int distanceX = Math.abs(startX - nx);
							
							return distanceY + distanceX;
						}else {
							visit[ny][nx] = true;
							q.offer(new Node_8_14(ny, nx));
						}
					}
				}
			}
		}
		
		return 0;
	}
	
	private boolean isValidIndex(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
}