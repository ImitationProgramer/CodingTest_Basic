package Search.BinarySearch;

import java.util.Scanner;

public class BaekJoon2343_MakeBlueRay {
	// 레슨 수, 블루레이 개수
	public static void main(String[] args) {
		/*
		 * N(레슨 개수) M(블루레이 개수) A(기타 레슨 데이터 저장 배열) start(이진 탐색 시작 인덱스) end(이진 탐색 종료 인덱스)
		 * for(N의 개수만큼 반복하기) { A 배열 저장하기 시작 인덱스 저장(A 배열 중 최댓값) 종료 인덱스 저장(A 배열의 총합) }
		 * while(시작 인덱스 <= 종료 인덱스){ middle(중간 인덱스) sum(레슨 합) count(현재 사용한 블루레이 개수)
		 * for(N의 개수만큼 반복하기) { 만약 sum + 현재 레슨 시간 > 중간 인덱스이면 count 값을 sum을 0으로 리셋하기 // 현재
		 * 블루레이 저장할 수 없어 새로운 블루레이로 교체한다는 의미 sum에 현재 레슨 시간값 더하기 } sum이 0이 아니면 마지막 블루레이가
		 * 필요하므로 count값 올리기 if(count > M: 중간 인덱스값으로 모든 레슨 저장 불가능) 시작 인덱스 = 중앙 인덱스 + 1
		 * else(중간 인덱스값으로 모든 레슨 저장 가능) 종료 인덱스 = 중앙 인덱스 - 1 } 시작 인덱스 출력하기
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		int start = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			if (start < A[i])
				start = A[i]; // 레슨 최댓값을 시작 인덱스로 저장하기
			end = end + A[i]; // 모든 레슨의 총합을 종료 인덱스로 저장하기
		}
		while (start <= end) {
			int middle = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < N; i++) { // middle값으로 모든 레슨을 저장할 수 있는지 확인
				if (sum + A[i] > middle) {
					count++;
					sum = 0;
				}
				sum = sum + A[i];
			}
			if (sum != 0) // 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요하므로 더함
				count++;
			if (count > M)
				start = middle + 1;
			else
				end = middle - 1;
		}
		System.out.println(start);
	}
}
