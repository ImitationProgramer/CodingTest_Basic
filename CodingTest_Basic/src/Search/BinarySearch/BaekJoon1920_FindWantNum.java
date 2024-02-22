package Search.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1920_FindWantNum {
	// 데이터 개수
	// 찾아야 할 숫자 개수
	public static void main(String[] args) {
		/*
		 * N(정렬할 수 개수) M(탐색할 숫자의 개수) A(정렬할 배열 선언하기) for(N의 개수만큼 반복하기) { A 배열 저장하기 } A 배열
		 * 정렬하기 for(M의 개수만큼 반복하기) { target(찾아야 하는 수) // 이진 탐색 시작 start(시작 인덱스), end(종료
		 * 인덱스) while(시작 인덱스 <= 종료 인덱스){ midi(중간 인덱스) if(중앙값 > target){ 종료 인덱스 = 중간 인덱스
		 * - 1 } else if(중앙값 < target){ 시작 인덱스 = 중간 인덱스 + 1 } else{ 찾았으므로 반복문 종료하기 } }
		 * if(찾았음) 1 출력 else 0 출력 }
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			boolean find = false;
			int target = sc.nextInt();
			// 이진 탐색 시작
			int start = 0;
			int end = A.length - 1;
			while (start <= end) {
				int midi = (start + end) / 2;
				int midV = A[midi];
				if (midV > target) {
					end = midi - 1;
				} else if (midV < target) {
					start = midi + 1;
				} else {
					find = true;
					break;
				}
			}
			if (find) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}
