package DataStructure.Range.QuickSort;

public class BaekJoon11004_FindK {

	public static void main(String[] args) {
		/*
		 * N(숫자의 개수) K(K번째 수) A(숫자 데이터 저장 배열) for(N만큼 반복하기){ A 배열 저장하기 } 퀵 소트 실행하기 K번째
		 * 데이터 출력하기
		 * 
		 * [별도의 함수 구현 부분] 퀵 소트 함수(시작, 종료, K) { 피벗 구하기 함수(시작, 종료) if(피벗 == K) 종료 else
		 * if(K < 피벗) 퀵 소트 수행하기(시작, 피벗 - 1, K) else 퀵 소트 수행하기(피벗 + 1, 종료, K) } 피벗 구하기
		 * 함수(시작, 종료) { 데이터가 2개인 경우는 바로 비교하여 정렬 M(중앙값) 중앙값을 시작 위치와 swap pivot(피벗)을 시작 위치
		 * 값 A[S]로 저장 i(시작점), j(종료점) while(i <= j) { 피벗보다 큰 수가 나올 때까지 i++ 피벗보다 작은 수가 나올
		 * 때까지 j-- 찾은 i와 j 데이터를 swap } 피벗 데이터를 나눠진 두 그룹의 경계 index에 저장하기 경계 index 리턴
		 */
	}

}
