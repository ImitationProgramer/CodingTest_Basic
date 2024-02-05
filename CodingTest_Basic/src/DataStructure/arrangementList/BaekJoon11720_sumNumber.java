package DataStructure.arrangementList;

import java.util.Scanner;

public class BaekJoon11720_sumNumber {
	// 숫자의 개수
	// 공백 없이 주어진 N개의 숫자
	public static void main(String[] args) {
		/*
		 * N 값 입력 받기 길이 N의 숫자를 입력받아 String형 변수 sNum에 저장하기 sNum을 다시 char[]형 변수 cNum에 변환하여
		 * 저장하기 int형 변수 sum 선언하기 for(cNum 길이만큼 반복하기) { 배열의 각 자릿값을 정수형으로 변환하며 sum에 더하여
		 * 누적하기 } sum 출력하기
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 입력값을 String 형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		int sum = 0;
		for (int i = 0; i < cNum.length; i++) {
			sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
		}
		System.out.println(sum);
	}

}
