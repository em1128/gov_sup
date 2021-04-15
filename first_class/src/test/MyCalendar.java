/*
달력을 출력하는 프로그램을 작성하세요.
1900년 1월 1일은 월요일입니다.
윤년을 적용하세요.
윤년은 4년으로 나눠지는 해이고, 단 100년으로 나눠지면 윤년이 아닙니다. 
그중에서 400으로 나눠지면 윤년입니다.
윤년은 2월 29일까지 입니다.
 
달력은 검색 기준일 기준으로 이전 달, 현재 달, 다음 달을 출력하세요.

검색날짜:
년도> 2021
월> 4
일> 20

달력 검색:
2021년 3월
일	월	화	수	목	금	토
	1	2	3	4	5	6
7	8	9	10	11	12	13
14	15	16	17	18	19	20
21	22	23	24	25	26	27
28	29	30	31

2021년 4월
일	월	화	수	목	금	토
				1	2	3
4	5	6	7	8	9	10
11	12	13	14	15	16	17
18	19	20	21	22	23	24
25	26	27	28	29	30

2021년 5월
일	월	화	수	목	금	토
						1
2	3	4	5	6	7	8
9	10	11	12	13	14	15
16	17	18	19	20	21	22
23	24	25	26	27	28	29
30	31						

 */
package test;

import java.io.IOException;

import java.util.Scanner;

public class MyCalendar {
	public static void main(String[] args) throws IOException {
		int year = 2021, month = 4;

		Scanner sc1 = new Scanner(System.in);
		System.out.println("년>");
		year = sc1.nextInt();
		System.out.println("월>");
		month = sc1.nextInt();

		print_month_first(month - 1, year);
		print_month_first(month, year);
		print_month_first(month + 1, year);

		sc1.close();
	}

	private static boolean isYoon(int year) { // 윤년 확인
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	private static int calculate_first(int month, int year) { // 시작요일 계산(숫자로 반환)
		int m_first = 1;

		if (year >= 1900) {
			for (int i = 1900; i < year; i++) {
				m_first++;
				if (isYoon(i))
					m_first++;
			}
			int sub_m = month - 1;
			if (sub_m >= 1)
				m_first += 31;
			if (sub_m >= 2) {
				if (isYoon(year))
					m_first += 29;
				else
					m_first += 28;
			}
			if (sub_m >= 3)
				m_first += 31;
			if (sub_m >= 4)
				m_first += 30;
			if (sub_m >= 5)
				m_first += 31;
			if (sub_m >= 6)
				m_first += 30;
			if (sub_m >= 7)
				m_first += 31;
			if (sub_m >= 8)
				m_first += 31;
			if (sub_m >= 9)
				m_first += 30;
			if (sub_m >= 10)
				m_first += 31;
			if (sub_m >= 11)
				m_first += 30;

			m_first %= 7;
		} else { // year<1900

			for (int i = 1899; i > year; i--) {

				m_first--;
				if (isYoon(i))
					m_first--;
			}
			if (month == 1) {
				m_first--;
				if (isYoon(year))
					m_first--;
			} else {
				int sub_m = 12 - month;

				if (sub_m >= 0)
					m_first -= 31;
				if (sub_m >= 1)
					m_first -= 30;
				if (sub_m >= 2)
					m_first -= 31;
				if (sub_m >= 3)
					m_first -= 30;
				if (sub_m >= 4)
					m_first -= 31;
				if (sub_m >= 5)
					m_first -= 31;
				if (sub_m >= 6)
					m_first -= 30;
				if (sub_m >= 7)
					m_first -= 31;
				if (sub_m >= 8)
					m_first -= 30;
				if (sub_m >= 9)
					m_first -= 31;
				if (sub_m >= 10) {
					if (isYoon(year))
						m_first -= 29;
					else
						m_first -= 28;
				}

			} // sub_m end

			m_first = (m_first % 7 == 0) ? (m_first % 7) : (m_first % 7 + 7);
		} // year<1900 end

		return m_first;
	}

	private static void print_month_first(int month, int year) {
		char m_first; // ?월1일의 요일
		char dow[] = { '일', '월', '화', '수', '목', '금', '토' };

		if (month == 0) {
			month = 12;
			year--;
		}
		if (month == 13) {
			month = 1;
			year++;
		}
		System.out.printf("%d년 %d월\n", year, month);
		for (char c : dow)
			System.out.print(c + "\t"); // 한글요일 전체 출력
		System.out.println();

		m_first = dow[calculate_first(month, year)];

		switch (m_first) { // 달력 start
		case '일':
			for (int i = 1; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 0)
					System.out.println();
			}
			print_after_28(month, year);// 29, 30, 31일 출력

			break;

		case '월':
			System.out.println("\t1\t2\t3\t4\t5\t6");
			for (int i = 7; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 6)
					System.out.println();
			}
			print_after_28(month, year); // 29, 30, 31일 출력

			break;

		case '화':

			System.out.println("\t\t1\t2\t3\t4\t5");
			for (int i = 6; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 5)
					System.out.println();
			}
			print_after_28(month, year);// 29, 30, 31일 출력

			break;

		case '수':

			System.out.println("\t\t\t1\t2\t3\t4");
			for (int i = 5; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 4)
					System.out.println();
			}
			print_after_28(month, year);// 29, 30, 31일 출력

			break;

		case '목':
			System.out.println("\t\t\t\t1\t2\t3");
			for (int i = 4; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 3)
					System.out.println();
			}
			print_after_28(month, year);// 29, 30, 31일 출력
			break;

		case '금':
			System.out.println("\t\t\t\t\t1\t2");
			for (int i = 3; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 2)
					System.out.println();
			}
			print_after_28('금', month, year);// 29, 30, 31일 출력
			break;

		case '토':
			System.out.println("\t\t\t\t\t\t1");
			for (int i = 2; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 1)
					System.out.println();
			}
			print_after_28('토', month, year);// 29, 30, 31일 출력
			break;
		default:
			System.out.println("Error : 시작일이 잘못됨!!!");
			break;
		}// 달력 end
		System.out.println();
	}

	private static void print_after_28(int month, int year) {
		// 29,30,31일 출력
		if (month == 4 || month == 6 || month == 9 || month == 11)
			System.out.println("29\t30");
		else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			System.out.println("29\t30\t31");
		else if (isYoon(year)) // month==2, 윤년
			System.out.println("29");
	}

	private static void print_after_28(char dow, int month, int year) {
		// 29,30,31일 출력
		if (dow == '금') {
			if (month == 4 || month == 6 || month == 9 || month == 11)
				System.out.println("29\t30");
			else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
				System.out.println("29\t30\n31");
			else if (isYoon(year)) // month==2, 윤년
				System.out.println("29");
		}
		if (dow == '토') {
			if (month == 4 || month == 6 || month == 9 || month == 11)
				System.out.println("29\n30");
			else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
				System.out.println("29\n30\t31");
			else if (isYoon(year)) // month==2, 윤년
				System.out.println("29");
		}
	}

}