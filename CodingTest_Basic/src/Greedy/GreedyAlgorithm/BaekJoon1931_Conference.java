package Greedy.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BaekJoon1931_Conference {

	public static void main(String[] args) {
		/*
		 * N(회의 개수) A(회의 정보 저장) A 배열 정렬 수행하기(종료 시간 기준으로 정렬, 종료 시간이 같으면 시작 시간 기준 정렬)
		 * for(회의실의 개수만큼 반복하기){ if(앞 회의의 종료 시간보다 시작 시간이 빠른 회의가 나온 경우){ 현재 회의의 종료 시간으로
		 * 종료시간 업데이트하기 진행할 수 있는 회의 수 1 증가 } } 총 진행 가능 회의 수 출력하기
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] A = new int[N][2];
		for (int i = 0; i < N; i++) {
			A[i][0] = sc.nextInt();
			A[i][1] = sc.nextInt();
		}
		Arrays.sort(A, new Comparator<int[]>() {
			@Override
			public int compare(int[] S, int[] E) {
				if (S[1] == E[1]) { // 종료 시간이 같을 때
					return S[0] - E[0];
				}
				return S[1] - E[1];
			}
		});
		int count = 0;
		int end = -1;
		for (int i = 0; i < N; i++) {
			if (A[i][0] >= end) { // 겹치지 않는 다음 회의가 나온 경우
				end = A[i][1]; // 종료 시간 업데이트하기
				count++;
			}
		}
		System.out.println(count);
	}

}
