package DataStructure.SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon12891_DNAPW {
	// DNA 문자열의 길이, 부분 문자열의 길이
	// DNA 문자열
	// 부분 문자열에 포함돼야 할 A, C, G, T의 최소 개수
	static int checkArr[];
	static int myArr[];
	static int checkSecret;

	public static void main(String[] args) throws IOException {
		/*
		 * S(문자열 크기) P(부분 문자열의 크기) A(문자열 데이터) checkArr(비밀번호 체크 배열) myArr(현재 상태 배열)
		 * checkSecret(몇 개의 문자와 관련된 개수를 충족했는지 팓ㄴ단하는 변수) P 범위(0~P-1) 만큼 S배열에 적용하고, 유효한
		 * 비밀번호인지 판단하기 for(i를 P에서 S까지 반복) { j 선언(i-P) // 이 부분은 함수로 별도 구현하기 한 칸씩 이동하면서
		 * 제거되는 문자열과 새로 들어오는 문자열을 처리하기 유효한 비밀번호인지(checkSecret==4) 판단해 결괏값에 업데이트하기 } 결괏값
		 * 출력하기
		 * 
		 * 별도 함수 Add(문자 더하기 함수) { 새로 들어온 문자를 myArr에 업데이트하거나 check Secret 값 변경하기 }
		 * Remove(문자 빼기 함수) { 제거되는 문자를 myArr에 업데이트하거나 checkSecret 값 변경하기 }
		 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Result = 0;
		char A[] = new char[S];
		checkArr = new int[4];
		myArr = new int[4];

	}

}
