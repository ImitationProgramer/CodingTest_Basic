package Arithmetic.PrimeNum;

import java.util.Scanner;

public class BaekJoon1747_FindMinPrimePelindrom {

	public static void main(String[] args) {
		/*
		 * N(어떤 수) A(소수 배열) for(2~10000001){ A 배열 초기화 // 인덱스를 자기 값으로 초기화하기 } for(A 배열
		 * 길이의 제곱근까지 반복하기){ 소수가 아니면 넘어감 for(소수의 배수 값을 10000001까지 탐색하기){ 이 수가 소수가 아니라는 것을
		 * 표시하기 } } while(true){ N부터 값을 1씩 증가시키면서 해당 값이 소수이면서 펠린드롬 수인지 판별하기 맞으면 반복문 종료하기
		 * } //펠린드롬 판별 함수 구현하기 Integer값을 char 배열로 변환하기 s(시작 인덱스), e(끝 인덱스) while(s < e)
		 * 만약 시작과 끝 인덱스에 해당하는 값이 다르면 return false; s++; e--; 반복문을 다 돌았으면 return true;
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[10000001]; // N의 범위까지 소수 구하기
		for (int i = 2; i < A.length; i++) {
			A[i] = i;
		}
		for (int i = 2; i < Math.sqrt(A.length); i++) { // 제곱근까지만 수행하기
			if (A[i] == 0) {
				continue;
			}
			for (int j = i + i; j < A.length; j = j + i) { // 배수 지우기
				A[j] = 0;
			}
		}
		int i = N;
		while (true) { // N부터 1씩 증가시키면서 소수와 펠린드롬 수가 맞는지 확인하기
			if (A[i] != 0) {
				int result = A[i];
				if (isPalindrome(result)) {
					System.out.println(result);
					break;
				}
			}
			i++;
		}
	}

	private static boolean isPalindrome(int target) { // 펠린드롬 수 판별 함수
		char temp[] = String.valueOf(target).toCharArray();
		int s = 0;
		int e = temp.length - 1;
		while (s < e) {
			if (temp[s] != temp[e])
				return false;
			s++;
			e--;
		}
		return true;
	}

}
