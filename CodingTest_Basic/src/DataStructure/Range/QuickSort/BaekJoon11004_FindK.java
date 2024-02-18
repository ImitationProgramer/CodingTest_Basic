package DataStructure.Range.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11004_FindK {

	public static void main(String[] args) throws IOException {
		/*
		 * N(숫자의 개수) K(K번째 수) A(숫자 데이터 저장 배열) for(N만큼 반복하기){ A 배열 저장하기 } 퀵 소트 실행하기 K번째
		 * 데이터 출력하기
		 * 
		 * [별도의 함수 구현 부분] 퀵 소트 함수(시작, 종료, K) { 피벗 구하기 함수(시작, 종료) if(피벗 == K) 종료 else
		 * if(K < 피벗) 퀵 소트 수행하기(시작, 피벗 - 1, K) else 퀵 소트 수행하기(피벗 + 1, 종료, K) } 피벗 구하기
		 * 함수(시작, 종료) { 데이터가 2개인 경우는 바로 비교하여 정렬 M(중앙값) 중앙값을 시작 위치와 swap pivot(피벗)을 시작 위치
		 * 값 A[S]로 저장 i(시작점), j(종료점) while(i <= j) { 피벗보다 큰 수가 나올 때까지 i++ 피벗보다 작은 수가 나올
		 * 때까지 j-- 찾은 i와 j 데이터를 swap } 피벗 데이터를 나눠진 두 그룹의 경계 index에 저장하기 경계 index 리턴
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(A, 0, N - 1, K - 1);
	}

	public static void quickSort(int[] A, int S, int E, int K) {
		if (S < E) {
			int pivot = partition(A, S, E);
			if (pivot == K) // K번째 수가 pivot이면 더이상 구할 필요 없음
				return;
			else if (K < pivot) // K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행하기
				quickSort(A, S, pivot - 1, K);
			else // K가 pivot보다 크면 오른쪽 그룹만 정렬 수행하기
				quickSort(A, pivot + 1, E, K);
		}
	}

	public static int partition(int[] A, int S, int E) {
		if (S + 1 == E) {
			if (A[S] > A[E])
				swap(A, S, E);
			return E;
		}
		int M = (S + E) / 2;
		swap(A, S, M); // 중앙값을 1번째 요소로 이동하기
		int pivot = A[S];
		int i = S + 1, j = E;
		return 0;
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
