package Arithmetic.PrimeNum;

import java.util.Scanner;

public class BaekJoon1456_FindAlmostPrimeNum {
	public static void main(String[] args) {
		/*
		 * Min(시작 수) Max(종료 수) A(소수 배열) for(2 ~ 10000000) { // 10^14의 제곱근인 10^7까지 반복하기 A
		 * 배열 초기화하기 // 각각의 인덱스값으로 초기화하기 } for(10000000의 제곱근까지 반복하기)ㅖ 소수가 아니면 넘어감 for(소수의
		 * 배숫값을 10000000까지 탐색하기){ 이 수가 소수가 아니라는 것을 표시하기 } } for(2 ~ 10000000){ A 배열에서
		 * 소수인 값일 때 temp = 현재 소수 // 현재 소수의 제곱근이 Max보다 작을 때를 기준으로 하지만 // 곱셈이 long의 범위를
		 * 넘어갈 수 있어 이항 정리로 처리하기 while(현재 소수 <= Max/temp) { if(현재 소수 >= Min/temp) 정답값 증가
		 * temp = temp * 현재 소수 } } 정답 출력하기
		 */
		Scanner sc = new Scanner(System.in);
		long Min = sc.nextLong();
		long Max = sc.nextLong();
		long[] A = new long[10000001];
		for (int i = 2; i < A.length; i++) {
			A[i] = i;
		}
		for (int i = 2; i <= Math.sqrt(A.length); i++) { // 제곱근까지만 수행하기
			if (A[i] == 0) {
				continue;
			}
			for (int j = i + i; j < A.length; j = j + i) { // 배수 지우기
				A[j] = 0;
			}
		}
		int count = 0;
		for (int i = 2; i < 10000001; i++) {
			if (A[i] != 0) {
				long temp = A[i];
				while ((double) A[i] <= (double) Max / (double) temp) {
					if ((double) A[i] >= (double) Min / (double) temp) {
						count++;
					}
					temp = temp * A[i];
				}
			}
		}
		System.out.println(count);
	}
}
