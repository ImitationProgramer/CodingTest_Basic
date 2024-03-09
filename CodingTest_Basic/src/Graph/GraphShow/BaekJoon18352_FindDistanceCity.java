package Graph.GraphShow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon18352_FindDistanceCity {
	// 도시 개수, 도로 개수, 거리 정보, 출발 도시 번호
	static int visited[];
	static ArrayList<Integer>[] A;
	static int N, M, K, X;
	static List<Integer> answer;

	public static void main(String[] args) {
		/*
		 * N(노드 개수) M(에지 개수) K(목표 거리) X(시작점) answer(정답 리스트) A(그래프 데이터 저장 인접 리스트)
		 * visited(방문 거리 저장 배열) for(N의 개수만큼 반복하기){ A 인접 리스트의 각 ArrayList 초기화하기 } for(M의
		 * 개수만큼 반복하기){ A 인접 리스트에 그래프 데이터 저장하기 } visited 배열 초기화하기 BFS(X) 실행하기 for(N의 개수만큼
		 * 반복하기){ 방문 거리가 K인 노드의 숫자를 정답 배열에 저장하기 } 정답 배열 오름차순 정렬해 출력하기
		 * 
		 * BFS{ // BFS 구현하기 큐 자료구조에 출발 노드 더하기(add연산) visited 배열에 현재 노드 방문 기록하기 while(큐가
		 * 빌 때까지){ 큐에서 노드 데이터를 가져오기(poll 연산) 가져온 노드 출력하기 현재 노드의 연결 노드 중 방문하지 않은 노드로 큐에
		 * 데이터 삽입(add 연산)하고 visited 배열에 방문 거리 기록하기 -> 이전 노드의 방문 노드 거리 + 1 } }
		 */
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 노드의 수
		M = sc.nextInt(); // 에지의 수
		K = sc.nextInt(); // 목표 거리
		X = sc.nextInt(); // 시작점
		A = new ArrayList[N + 1];
		answer = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
		}
		visited = new int[N + 1]; // 방문 배열 초기화하기
		for (int i = 0; i <= N; i++) {
			visited[i] = -1;
		}
		BFS(X);
		for (int i = 0; i <= N; i++) {
			if (visited[i] == K) {
				answer.add(i);
			}
		}
		if (answer.isEmpty()) {
			System.out.println("-1");
		} else {
			Collections.sort(answer);
			for (int temp : answer) {
				System.out.println(temp);
			}
		}
	}

	// BFS 구현하기
	private static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node]++;
		while (!queue.isEmpty()) {
			int now_Node = queue.poll();
			for (int i : A[now_Node]) {
				if (visited[i] == -1) {
					visited[i] = visited[now_Node] + 1;
					queue.add(i);
				}
			}
		}
	}

}
