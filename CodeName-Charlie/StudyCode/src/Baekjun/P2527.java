
// 2차원 격자공간에 두 개의 꼭짓점 좌표로 표현되는 직사각형이 있다. 
// 직사각형은 왼쪽 아래 꼭짓점 좌표 (x, y)와 오른쪽 위 꼭짓점 좌표 (p, q)로 주어진다.
// 이 문제에서 모든 직사각형은 두 꼭짓점의 좌표를 나타내는 4개의 정수 x y p q 로 표현된다. 단 항상 x<p, y<q 이다.
// ...
// 두 개의 직사각형은 그 겹치는 부분의 특성에 따라 4가지 경우로 분류될 수 있다. 
// 두 직사각형의 겹치는 부분이 직사각형인지, 선분인지, 점인지, 아니면 전혀 없는 지를 판별해서 해당되는 코드 문자를 출력해야 한다.
// 공통부분이 직사각형인 경우 => a 출력, 공통부분이 선분인 경우 => b 출력, 공통부분이 점인 경우 => c 출력, 공통부분이 없는 경우 => d 출력, 

package Baekjun;

// 두 직사각형의 좌표를 입력 받는다.
// 조건문을 작성해, 입력 받은 좌표를 기준으로 공통부분을 판단해 답을 출력하도록 한다.

import java.util.Scanner;

public class P2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int example = 0; example < 4; example++) { // 입력 값을 4번 입력 받고 답을 4번 출력해야하기 때문에, for문을 통해 4번 반복하도록 설정한다.
			int x1 = sc.nextInt(); // 첫 번째 직사각형의 왼쪽 아래 꼭짓점의 x좌표를 입력 받는다.
			int y1 = sc.nextInt(); // 첫 번째 직사각형의 왼쪽 아래 꼭짓점의 y좌표를 입력 받는다.
			int p1 = sc.nextInt(); // 첫 번째 직사각형의 오른쪽 위 꼭짓점의 p좌표를 입력 받는다. 
			int q1 = sc.nextInt(); // 첫 번째 직사각형의 오른쪽 위 꼭짓점의 q좌표를 입력 받는다.
			int x2 = sc.nextInt(); // 두 번째 직사각형의 왼쪽 아래 꼭짓점의 x좌표를 입력 받는다.
			int y2 = sc.nextInt(); // 두 번째 직사각형의 왼쪽 아래 꼭짓점의 y좌표를 입력 받는다.
			int p2 = sc.nextInt(); // 두 번째 직사각형의 오른쪽 위 꼭짓점의 p좌표를 입력 받는다. 
			int q2 = sc.nextInt(); // 두 번째 직사각형의 오른쪽 위 꼭짓점의 q좌표를 입력 받는다.
			
			// a(공통부분이 직사각형)인 경우
			// 직사각형 내부에 점이 한 개 이상 들어가 있을 때,(꼭지점 4개가 모두 직사각형 내부에 들어가는 경우도 여기에 포함된다.)
			if((x1 < x2 && x2 < p1 && y1 < y2 && y2 < q1) 
					|| (x1 < p2 && p2 < p1 && y1 < q2 && q2 < q1) 
					|| (x1 < x2 && x2 < p1 && y1 < q2 && q2 < q1) 
					|| (x1 < p2 && p2 < p1 && y1 < y2 && y2 < q1)) {
				System.out.println("a"); // a를 출력한다.
			}
			// 하지만, 꼭지점 4개가 모두 직사각형 내부에 들어가는 경우에는 직사각형의 위치가 다를 경우도 고려해줘야한다.
			else if((x2 < x1 && x1 < p2 && y2 < y1 && y1 < q2) 
					|| (x2 < p1 && p1 < p2 && y2 < q1 && q1 < q2) 
					|| (x2 < x1 && x1 < p2 && y2 < q1 && q1 < q2) 
					|| (x2 < p1 && p1 < p2 && y2 < y1 && y1 < q2)) {
				System.out.println("a");
			}
			// 직사각형 내부에 점이 없을 때,
			// 이 때는 두 직사각형의 위치를 모두 고려할 필요가 없기 때문에, 두 가지 경우만 조건으로 설정해준다.
			else if((x2 <= x1 && y1 <= y2 && y2 < q1 && p1 <= p2 && y1 < q2 && q2 <= q1) // 선분이 겹치는 경우가 존재할 수 있기 때문에 등호를 섞어서 조건식을 설정한다.
					|| (x1 <= x2 && y2 <= y1 && y1 < q2 && p2 <= p1 && y2 < q1 && q1 <= q2)) {
				System.out.println("a");
			}
			// b(공통부분이 선분)인 경우
			// 1) 선분 위에 점이 있어야 한다, 
			// 2) 선분의 시작 점에는 점이 위치해도 되지만,
			// 3) 끝 점에 위치하면 안된다.(끝 점에 위치할 경우 공통부분이 점(c)이 되어버린다.)
			// 위를 고려하여 조건식을 작성하자.
			else if((x1 <= x2 && x2 < p1 && y1 == q2) 
					|| (y1 <= y2 && y2 < q1 && p1 == x2) 
					|| (x1 <= x2 && x2 < p1 && q1 == y2) 
					|| (y1 <= y2 && y2 < q1 && x1 == p2)) {
				System.out.println("b"); // b를 출력한다.
			}
			// 여기서도 직사각형의 위치가 다를 경우를 고려해주어야 한다.
			else if((x2 <= x1 && x1 < p2 && y2 == q1)  
					|| (y2 <= y1 && y1 < q2 && p2 == x1) 
					|| (x2 <= x1 && x1 < p2 && q2 == y1) 
					|| (y2 <= y1 && y1 < q2 && x2 == p1)) {
				System.out.println("b");
			}
			// c(공통부분이 점)인 경우(가장 간단하죠...?)
			// 해당하는 두 점의 x좌표와 y좌표가 각각 동일하다. 는 조건식을 쓴다.
			// 여기서는 직사각형의 위치가 다른 경우를 나누어 생각할 필요가 없다.
			else if((p1 == x2 && y1 == q2) 
					|| (p1 == x2 && q1 == y2) 
					|| (x1 == p2 && q1 == y2) 
					|| (x1 == p2 && y1 == q2)) {
				System.out.println("c"); // c를 출력한다.
			}
			// d(공통부분이 없음)인 경우
			else {
				System.out.println("d"); // d를 출력한다.
			}
		}
	}
}