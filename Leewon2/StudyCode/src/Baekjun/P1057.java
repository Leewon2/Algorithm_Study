/* 문제
 * 토너먼트를 진행하는데, N명의 참가자는 번호가 1번부터 N번까지 배정받는다.
 * 다음으로 인접한 번호끼리 스타를 한다.
 * 이긴 사람은 다음 라운드에 진출하고, 진 사람은 그 라운드에서 떨어진다.
 * 만약 그 라운드 참가자가 홀수라면, 마지막 번호를 가진 참가자는 자동 진출이다.
 * 다음 라운드에서 다시 참가자의 번호를 1번부터 매긴다.
 * 
 * 김지민은 우승에 관심이 없고 임한수와의 대결을 기대하고 있다.
 * 김지민과 임한수는 서로 만나기 전 까지 모두 이긴다고 가정했을 때,
 * 김지민과 임한수는 몇 라운드에서 대결하는지 출력해보자.
 * 
 * 
 * 조건
 * 참가자 수 N은 2 이상 10만 이하다.
 * 김지민과 임한수는 서로 다르다.
 * 서로 대결하지 않을 때는 -1을 출력한다.
 * 
 * 
 * 문제 해결 방법
 * 한 경기가 끝날 때 마다 절반씩 뚝 떨어져 나간다.
 * 1번과 2번이 경기해서 2번이 이기고, 3번과 4번이 경기해서 4번이 이기고, 5번과 6번이 경기해서 6번이 이긴다고 가정하자.
 * 다음 경기에서는 2번은 1번이 되고, 4번은 2번이 되고, 6번은 3번이 된다.
 * 즉, 다음 라운드가 되면 나누기 2를 하면 다음 대진표가 짜여진다.
 * 위의 경우는 짝수만 고려하였는데, 홀수인 경우는 나누기2를 한 다음 1을 더하면 된다.
 * 
 * 지민이와 한수를 2로 나눠보자.
 * 홀수라면, 2로 나눈 후 1을 더하고,
 * 짝수라면 그냥 2로 나눈다.
 * 
 * 홀수일 때, 1을 더하는 방법은 여러가지가 있지만 나머지를 이용해 구해보자.
 * 
 * 
 * 한번 나눌 때 마다 라운드 수를 늘리고, 지민이와 한수가 같아지는 순간을 확인해보자.
 * 
 * 
 */

package Baekjun;

import java.util.Scanner;

public class P1057 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 참가자 수 N을 입력 받는다.
		int N = sc.nextInt();

		// 지민이의 번호를 입력 받는다.
		int jimin = sc.nextInt();

		// 한수의 번호를 입력 받는다.
		int hansu = sc.nextInt();

		// 라운드 수를 저장한다.
		int cnt = 0;

//		##########하드코딩##########
		// 지민이와 한수가 같아질 때 가지 반복하자.
//		while (jimin != hansu) {
//			// 홀수라면???
//			if ((jimin & 1) == 1) {
//				// 나누기 2를 한 다음 1을 더한다.
//				jimin = jimin / 2 + 1;
//			}
//			// 짝수라면?
//			else {
//				// 2로 나눈다.
//				jimin /= 2;
//			}
//
//			// 한수도 홀수라면???
//			if ((hansu & 1) == 1) {
//				// 나누기 2를 한 다음 1을 더한다.
//				hansu = hansu / 2 + 1;
//			}
//			// 짝수라면??
//			else {
//				// 2로 나눈다.
//				hansu /= 2;
//			}
//			// 1회 작업이 끝나면 라운드 수를 늘린다.
//			cnt++;
//
//		}

//		##########Math함수를 이용한 코딩##########
//		##########자료형을 double로 바꿔야함##########
//		while (jimin != hansu) {
//			// 홀수라면???
//			hansu=Math.ceil(hansu/2);
//			jimin = Math.ceil(jimin/2);
//			cnt++;
//
//		}

		// 지민이와 한수가 같지 않다면 반복해보자.
		while (jimin != hansu) {
			// 라운드 하나가 지날 때 마다 2씩 나뉜다.
			// 홀수인 경우는 1을 더해줘야 하므로,,,
			// 2로나눈 후 나머지를 더해보자.
			hansu = hansu / 2 + hansu % 2;
			jimin = jimin / 2 + jimin % 2;
			cnt++;

		}

		// 라운드 수를 출력해보자.
		System.out.println(cnt);

	}
}