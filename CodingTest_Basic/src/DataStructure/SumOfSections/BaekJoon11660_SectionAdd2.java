package DataStructure.SumOfSections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11660_SectionAdd2 {

	// 2차원 배열의 크기, 구간 합 질의의 개수
	// 원본 배열 1번째 줄
	// 원본 배열 2번째 줄
	// 원본 배열 3번째 줄
	// 원본 배열 4번째 줄
	// 구간 합(X1,Y1),(X2,Y2) 1번째 질의
	// 구간 합(X1,Y1),(X2,Y2) 2번째 질의
	// 구간 합(X1,Y1),(X2,Y2) 3번째 질의
	public static void main(String[] args) throws IOException {
		// D[X][Y] = 원본 배열의 (0,0) 부터 (X,Y)까지의 사각형 영역 안에 있는 수의 합
		// D[i][j]의 값을 채우는 구간 합 공식
		// D[i][j] = D[i][j-1] + D[i-1][j]-D[i-1][j-1]+A[i][j]
		/*
		 * N(배열 크기) M(질의 수) 저장하기 for(N만큼 반복하기){ for(N만큼 반복하기){ 합 배열 저장하기 D[i][j] =
		 * D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]; } } for(M만큼 반복하기){ 질의 계산 및
		 * 출력하기 결과 = D[x2][y2]-D[x1-1][y2]-D[x2][y1-1]+D[x1-1][y1-1]; }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int D[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 구간 합 구하기
				D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 구간 합 배열로 질의에 답변하기
			int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
			System.out.println(result);
		}
	}

}
