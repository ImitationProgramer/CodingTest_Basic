package DataStructure.arrangementList;

import java.util.Scanner;

public class BaekJoon1546_avg {
	// 시험을 본 과목의 개수
	// 각 과목의 시험 성적
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subject = sc.nextInt();
		int[] scores = new int[subject];
		for (int i = 0; i < subject; i++) {
			scores[i] = sc.nextInt();
		}
		int max = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (max < scores[i])
				max = scores[i];
		}
		double avg = 0, total = 0;
		for (int i = 0; i < scores.length; i++) {
			total += scores[i] / (double) max * 100;
		}
		avg = total / subject;
		System.out.println(avg);
	}

}
