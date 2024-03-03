package Arithmetic.ExtendEuclideanAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon21568_axbyc {

	public static void main(String[] args) throws IOException {
		/*
		 * a(1번째 수) b(2번째 수) c(3번째 수) 최대 공약수 = gcd(a,b) if(c가 최대 공약수의 배수가 아니면) -1 출력하기
		 * else{ 나머지(b)가 0이 될 때까지 재귀 함수를 호출하는 유클리드 호제법 함수 호출하기 결괏값에 c/최대 공약수의 값을 곱한 후 해당
		 * 값을 출력하기 } // 유클리드 호제법 함수 구현하기 Excute(a, b){ if(b == 0) 재귀 함수를 중단하고 return
		 * Excute(b, a % b) // 호제법 함수 호출하기(재귀 함수 형태) x = y`, y = x`- y` * 몫을 계산하는 역산 로직
		 * 구현하기 // 재귀에서 빠져나오는 영역에서 실행하면 자연스럽게 역순이 됨 }
		 * 
		 * // 최대 공약수 gcd() 함수 구현하기 gcd{ if(b가 0이면) a가 최대 공약수 else{ // 재귀 함수 형태로 구현하기
		 * gcd(작은 수, 큰 수 % 작은 수) } }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long gcd = gcd(a, b);
		if (c % gcd != 0) {
			System.out.println(-1);
		} else {
			int mok = (int) (c / gcd);
			long[] ret = Excute(a, b);
			System.out.println(ret[0] * mok + " " + ret[1] * mok);
		}
	}

	private static long[] Excute(long a, long b) {
		long[] ret = new long[2];
		if (b == 0) {
			ret[0] = 1;
			ret[1] = 0; // x=1,y=0으로 설정하고 리턴하기
			return ret;
		}
		long q = a / b;
		long[] v = Excute(b, a % b); // 재귀 형태로 유클리드 호제법 수행하기
		ret[0] = v[1]; // 역순으로 올라오면서 x,y 값을 계산하는 로직
		ret[1] = v[0] - v[1] * q;
		return ret;
	}

	private static long gcd(long a, long b) {
		while (b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}

}
