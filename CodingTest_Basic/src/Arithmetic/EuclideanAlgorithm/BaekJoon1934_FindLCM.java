package Arithmetic.EuclideanAlgorithm;

import java.util.Scanner;

public class BaekJoon1934_FindLCM {

	public static void main(String[] args) {
		/*
		 * t(테스트 케이스) for(t만큼 반복하기){ a(1번째 수) b(2번째 수) 결괏값 = a * b / gcd(a, b) 결괏값 출력하기
		 * } // 최대 공약수 gcd()함수 구현하기 gcd{ if(b가 0이면) a가 최대 공약수 else gcd(작은수, 큰 수 % 작은 수)
		 * // 재귀 함수 형태로 구현하기 }
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int result = a * b / gcd(a, b);
			System.out.println(result);
		}
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b); // 재귀 함수의 형태로 구현
	}

}
