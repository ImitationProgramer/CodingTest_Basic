package Search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2178_FindMaze {
	// 상하좌우를 탐색하기 위한 배열 선언하기
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int[][] A;
	static int N, M;

	public static void main(String[] args) throws IOException {
		/*
		 * dx, dy(상하좌우를 탐색하기 위한 define값 정의 변수) A(데이터 저장 2차원 행렬) N(row), M(column)
		 * visited(방문 기록 저장 배열) for(N의 개수만큼 반복하기){ for(M의 개수만큼 반복하기){ A 배열에 데이터 저장하기 } }
		 * 
		 * BFS(0,0) 실행하기 A[N-1][M-1] 값 출력하기 BFS{ // BFS 구현하기 큐 자료구조에 시작 노드 삽입하기(add 연산)
		 * visited 배열에 현재 노드 방문 기록하기 while(큐가 비어 있을 때까지){ 큐에서 노드 데이터를 가져오기(poll 연산)
		 * for(상하좌우 탐색){ if(유효한 좌표){ if(이동할 수 있는 칸이면서 방문하지 않은 노드){ visited 배열에 방문 기록하기 A
		 * 배열에 depth를 현재 노드의 depth + 1로 업데이트하기 큐에 데이터 삽입하기(add 연산) } } } } }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}
		BFS(0, 0);
		System.out.println(A[N - 1][M - 1]);
	}

	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if (x >= 0 && y >= 0 && x < N && y < M) { // 좌표 유효성 검사하기, 배열을 넘어가면 안됨
					if (A[x][y] != 0 && !visited[x][y]) { // 갈 수 있는 칸 && 방문 검사하기
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1; // 깊이 업데이트 하기
						queue.add(new int[] { x, y });
					}
				}
			}
		}
	}

}
