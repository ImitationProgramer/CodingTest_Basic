package Graph.GraphShow;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1325_EfficientlyHacking {
	static int N, M;
	static boolean visited[];
	static int answer[];
	static ArrayList<Integer> A[];
	public static void main(String[] args) throws IOException {
		/*
		 * N(노드 개수) M(에지 개수) answer(정답 배열) A(그래프 데이터 저장 인접 리스트) visited(방문 유무 저장 배열)
		 * for(N의 개수만큼 반복하기){
		 * 	A 인접 리스트의 각 ArrayList 초기화하기
		 * }
		 * for(M의 개수만큼 반복하기){
		 * 	visited 배열 초기화하기
		 * 	BFS(i) 실행하기	// 모든 노드로 BFS 실행하기
		 * }
		 * for(N의 개수만큼 반복하기){
		 * 	answer 배열에서 가장 큰 수 찾기 -> maxVal
		 * }
		 * for(N의 개수만큼 반복하기){
		 * 	answer 배열에서 maxVal와 같은 값을 가진 index를 정답으로 출력하기
		 * }
		 * // BFS 구현하기
		 * BFS{
		 * 	큐 자료구조에 출발 노드 더하기(add 연산)
		 * 	visited 배열에 현재 노드 방문 기록하기
		 * 	while(큐가 빌 때까지){
		 *		큐에서 노드 데이터를 가져오기(poll연산)
		 * 		현재 노드의 연결 노드 중 방문하지 않은 노드로
		 * 		큐에 데이터 삽입(add 연산)하고 visited 배열에 방문 기록하기,
		 * 		신규 노드 인덱스의 정답 배열 값을 증가시키기
		 * 	}
		 *}
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N+1];
		answer = new int[N+1];
		for(int i = 1; i<=N; i++)
			A[i]= new ArrayList<>();
		for(int i =0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A[S].add(E);
		}
		for(int i=1;i<=N;i++){	// 모든 노드로 BFS 실행하기
			visited = new boolean[N+1];
			BFS(i);
		}
		int maxVal = 0;
		for(int i =1;i<=N;i++){
			maxVal = Math.max(maxVal,answer[i]);
		}
		for(int i=1;i<=N;i++){
			if(answer[i]==maxVal)	// answer 배열에서 maxVal와 같은 값을 지닌 index가 정답
				System.out.print(i+" ");
		}
	}
	public static void BFS(int index){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		visited[index] = true;
		while(!queue.isEmpty()){
			int now_Node = queue.poll();
			for(int i : A[now_Node]){
				if(!visited[i]){
					visited[i]=true;
					answer[i]++;	// 신규 노드 인덱스의 정답 배열 값을 증가시킴
					queue.add(i);
				}
			}
		}
	}

}
