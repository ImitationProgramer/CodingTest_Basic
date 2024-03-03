package Arithmetic.EulersPhi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11689_EulersPhi {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * n(소인수 표현) result(결괏값) for(2 ~ n의 제곲근){ if(현재 값이 소인수라면){ 결괏값 = 결괏값 - 결괏값 / 현재값
		 * n에서 현재 소인수 내역을 제거하기(2^7 * 11 * 13 -> 현재 소인수가 2일 때 11 * 13으로 변경) } } if(n >
		 * 1){ // n이 마지막 소인수일 때 결괏값 = 결괏값 - 결괏값 / n } 결괏값 출력하기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long result = n;
		for (long p = 2; p <= Math.sqrt(n); p++) { // 제곱근까지만 진행하기
			if (n % p == 0) { // p가 소인수인지 확인하기
				result = result - result / p; // 결괏값 업데이트하기
				while (n % p == 0) { // 2^7*11이라면 2^7을 없애고 11만 남김
					n /= p;
				}
			}
		}
		if (n > 1) // 아직 소인수 구성이 남아 있을 때
			// 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스
			result = result - result / n;
		System.out.println(result);
	}

}
