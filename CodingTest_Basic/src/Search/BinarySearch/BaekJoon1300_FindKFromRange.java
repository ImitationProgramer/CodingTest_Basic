package Search.BinarySearch;

import java.util.Scanner;

public class BaekJoon1300_FindKFromRange {

	public static void main(String[] args) {
		/*
		 * N(배열의 크기) K(구하고자 하는 index) start(시작 인덱스 = 1) end(종료 인덱스 = K) while(시작 인덱스 <=
		 * 종료 인덱스){ // 이진 탐색 수행하기 middle(중간 인덱스) cnt(중앙값보다 작은 수) // 중앙값보다 작은 수는 몇 개인지
		 * 계산하기 for(N의 개수만큼 반복하기){ cnt에 중앙 인덱스를 i로 나눈 값과 N중 작은 값을 더함 } if(cnt < K: 현재
		 * 중앙값보다 작은 수의 개수가 K보다 작음) 시작 인덱스 = 중앙 인덱스 + 1 else(현재 중앙값보다 작은 수의 개수가 K보다 크거나
		 * 같음) 종료 인덱스 = 중앙 인덱스 - 1 정답 변수에 중앙값 저장 } 정답 출력
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long start = 1, end = K;
		long ans = 0;
		// 이진 탐색 수행하기
		while (start <= end) {
			long middle = (start + end) / 2;
			long cnt = 0;
			// 중앙값보다 작은 수는 몇 개인지 계산하기
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(middle / i, N); // 작은 수를 카운트하는 핵심 로직
			}
			if (cnt < K) {
				start = middle + 1;
			} else {
				ans = middle; // 현재 단계의 중앙값을 정답 변수에 저장하기
				end = middle - 1;
			}
		}
		System.out.println(ans);

	}

}
