/*
 * 구구단
 */
package test;

import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
		gugudan1();

		Scanner sc1 = new Scanner(System.in);
		System.out.println("구구단을 선택하세요");
		System.out.println("> ");
		int n1 = sc1.nextInt();
		gugudan2(n1);
	}

	private static void gugudan2(int n1) {
		// TODO Auto-generated method stub
		// 선택한 구구단을 출력하기
		for (int i = 1; i <= 9; i++) {
			System.out.println(n1 + " x " + i + " = " + (n1 * i));
		}

	}

	private static void gugudan1() {
		// TODO Auto-generated method stub
		// 구구단 출력하기 2단~9단
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
		}
	}
}