/*
성적을 입력받고 저장하는 프로그램을 작성하세요.
학생이름으로 성적을 검색해서 출력할 수 있어야 합니다.
출력 순서는 이름>총점>평균 순서로 출력합니다.

다음의 학생 데이터를 사용해서 입력하세요.
이름	학년	반	국어	영어	수학	총점	평균
홍길동 3	1	100	100	100	300	100
홍길서 3	2	 90	100	 80	270	 90
홍길남 3	2	 80	 90	100	270	 90
홍길븍 3	2	 70	 80	 90	240	 80


성적을 입력받는 메뉴는 다음과 같습니다.
=================================
성적 관리 프로그램 v1.0
---------------------------------
0. 이름으로 조회하기
1. 성적입력
2. 이름으로 검색하기
9. 종료하기
---------------------------------

0. 조회하기
=================================
이름	학년	반	국어	영어	수학	총점	평균
---------------------------------
홍길동 3	1	100	100	100	300	100
홍길서 3	2	 90	100	 80	270	 90
홍길남 3	2	 80	 90	100	270	 90
홍길븍 3	2	 70	 80	 90	240	 80

2. 이름으로 조회하기
>홍길서
=================================
이름	학년	반	국어	영어	수학	총점	평균
---------------------------------
홍길서 3	2	 90	100	 80	270	 90

 */
package test;

import java.io.IOException;

import java.util.Scanner;

public class ManageStudent {

	public static void main(String[] args) throws IOException {
		MyStudent[] st = new MyStudent[4];
		
		String input;
		
		int opt;
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		do {
			System.out.println("=================================\r\n"
					+ "성적 관리 프로그램 v1.0\r\n"
					+ "---------------------------------\r\n"
					+ "0. 전체 조회하기\r\n"
					+ "1. 성적입력\r\n"
					+ "2. 이름으로 검색하기\r\n"
					+ "9. 종료하기\r\n"
					+ "---------------------------------");
			opt = sc1.nextInt();
			if(opt == 0) {
				showAllStudent(st);
			}else if(opt == 1) {
				System.out.println("성적을 입력하세요.이름 학년 반 국어 영어 수학 (스페이스바로 구분)");
				input = sc2.nextLine();
				
				String spl[] = new String[6];
				spl = input.split(" ");
				
				inputGrade(spl, st);
				
			}else if(opt == 2) {
				System.out.println("이름으로 검색하세요.");
				input = sc2.nextLine();
				
				searchName(input, st);
			}
		}while(opt!=9);
		System.out.println("시스템 종료");
		sc1.close();
		sc2.close();
	}

	private static void searchName(String input, MyStudent[] st) {
		
		
		for (int i = 0; i < st.length; i++) {
			if(st[i] == null) {
				System.out.println("Error" + i);
				break;
			}
			else if(st[i].checkNameOfStudent(input)) {
				System.out.println("이름\t학년\t반\t국어\t영어\t수학\t총점\t평균");
				System.out.println(st[i].toString());
				break;
			}
			
		}
	}

	private static void inputGrade(String[] spl, MyStudent[] st) {
		
		for (int i = 0; i < st.length; i++) {
			if(st[i] == null) {
				st[i] = new MyStudent(spl[0],spl[1],spl[2],spl[3],spl[4],spl[5]);
				break;
			}
		}
		
	}

	private static void showAllStudent(MyStudent[] st) {
		System.out.println("이름\t학년\t반\t국어\t영어\t수학\t총점\t평균");
		for (MyStudent std : st) {
			if(std == null) break;
			System.out.println(std.toString());
		}
	}
	
	
}