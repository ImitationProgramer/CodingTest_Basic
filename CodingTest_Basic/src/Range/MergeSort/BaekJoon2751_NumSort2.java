package Range.MergeSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon2751_NumSort2 {
	public static int[] A, tmp;
	public static long result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * N(정렬할 수 개수) A(정렬할 배열 선언하기) tmp(정렬할 때 잠시 사용할 임시 배열 선언하기) for(N의 개수만큼) { A 배열에
		 * 데이터 저장하기 } 병합 정렬 함수 수행하기 결괏값 출력하기 //병합 정렬 수행하기 병합 정렬(s, e){ s(시작점), e(종료점),
		 * m(중간점) // 재귀 함수 형태로 구현하기 병합 정렬(s, m) 병합 정렬(m+1, e) for(s ~ e) { tmp 배열 저장하기 }
		 * // 두 그룹을 병합하는 로직 index1 -> 앞쪽 그룹 시작점 index2 -> 뒤쪽 그룹 시작점 while(index1 <= 중간점
		 * && index2 <= 종료점) 양쪽 그룹의 index가 가리키는 값을 비교한 후 더 작은 수를 선택해 배열에 저장하고, 선택된 데이터의
		 * index 값을 오른족으로 한칸 이동하기 반복문의 끝난 후 남아 있는 데이터 정리하기 }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		tmp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		merget_sort(1, N); // 병합 정렬 수행하기
		for (int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void merget_sort(int s, int e) {
		if (e - s < 1) {
			return;
		}
		int m = s + (e - s) / 2;
		// 재귀 함수 형태로 구현
		merget_sort(s, m);
		merget_sort(m + 1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		while (index1 <= m && index2 <= e) { // 두 그룹을 병합하는 로직
			// 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
			// 선택된 데이터의 index 값을 오른쪽으로 한칸 이동하기
			if (tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while (index1 <= m) { // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while (index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}

}
