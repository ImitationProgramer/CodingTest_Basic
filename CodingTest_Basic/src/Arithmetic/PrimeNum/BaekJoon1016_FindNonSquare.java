package Arithmetic.PrimeNum;

import java.util.Scanner;

public class BaekJoon1016_FindNonSquare {

	public static void main(String[] args) {
		/*
		 * Min(최솟값) Max(최대값) Check(Min ~ Max 사이에 제곱수 판별 배열) for(i = 2 ~ Max 사이 반복, i * i
		 * 증가){ // 단순 탐색이 아닌 제곱수 형태로 증가 pow(제곱수) start_index(최솟값/제곱수) for(j =
		 * start_index ~ Max 사이 반복하기){ // 제곱수의 배수 형태로 탐색하기 j * pow가 Max보다 작을 때 최솟값, 최댓값
		 * 사이의 제곱수이므로 Check 배열에 저장하기 } } count(제곱이 아닌 수 카운트) for(0 ~ Max-Min){ Check
		 * 배열에서 제곱이 아닌 수라면 count 증가 } count 출력하기
		 */
		Scanner sc = new Scanner(System.in);
		long Min = sc.nextLong();
		long Max = sc.nextLong();
		// 최댓값과 최솟값의 차이만큼 배열 선언하기
		boolean[] Check = new boolean[(int) (Max - Min + 1)];
		// 2의 제곱수인 4부터 Max보다 작거나 같은 값까지 반복하기
		for (long i = 2; i * i <= Max; i++) {
			long pow = i * i;
			long start_index = Min / pow;
			if (Min % pow != 0)
				start_index++; // 나머지가 있으면 1을 더해야 Min보다 큰 제곱수에서 시작됨
			for (long j = start_index; pow * j <= Max; j++) { // 제곱수를 true로 변경하기
				Check[(int) ((j * pow) - Min)] = true;
			}
		}
		int count = 0;
		for (int i = 0; i <= Max - Min; i++) {
			if (!Check[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

}
