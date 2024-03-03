package Arithmetic.EuclideanAlgorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BaekJoon1850_FindGCD {

	public static void main(String[] args) throws IOException {
		/*
		 * a(1번째 수) b(2번째 수) 결괏값 = gcd(a,b) 결괏값만큼 1을 반복해 출력하기 // 출력 횟수가 많기 때문에
		 * BufferedWriter 사용 } // 최대 공약수 gcd() 함수 구현하기 gcd{ if(b가 0이면) a가 최대 공약수 else
		 * gcd(작은수, 큰수 % 작은 수) // 재귀 함수 형태로 구현하기 }
		 */
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long a = sc.nextLong();
		long b = sc.nextLong();
		long result = gcd(a, b);
		while (result > 0) {
			bw.write("1");
			result--;
		}
		bw.flush();
		bw.close();
	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
