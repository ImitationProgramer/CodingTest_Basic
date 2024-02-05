package DataStructure.SumOfSections;

import java.util.Scanner;

// 이대로 하면 시간 초과로 0.5초 안에 모든 구간 합 계산을 끝낼 수 없다.
public class BaekJoon11659_SectionAdd {
	// 데이터의 개수, 질의 개수
	// 구간 합을 구할 대상 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nCnt, qCnt = 0;
		nCnt = sc.nextInt();
		qCnt = sc.nextInt();
		int[] nList = new int[nCnt];
		for (int i = 0; i < nList.length; i++) {
			nList[i] = sc.nextInt();
		}
		int a, b = 0;
		for (int i = 0; i < qCnt; i++) {
			int total = 0;
			a = sc.nextInt();
			b = sc.nextInt();
			for (int j = a; j <= b; j++) {
				total += nList[j - 1];
			}
			System.out.println(total);
		}
	}

}
