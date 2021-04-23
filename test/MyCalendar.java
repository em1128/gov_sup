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


import java.time.DayOfWeek;

import java.time.LocalDate;

import java.time.Month;


public class MyCalendar {
	static char dow[] = { '일', '월', '화', '수', '목', '금', '토' };
	public int year;
	public Month month;
	public LocalDate date;
	
	public MyCalendar() {
		this.date = LocalDate.now();
		this.year = date.getYear();
		this.month = date.getMonth();
	}
	public MyCalendar(LocalDate date) {
		this.date = date;
		this.year = date.getYear();
		this.month = date.getMonth();
	}

	public void print_month_first() {
		
		
		System.out.printf(this.year + "년 " + this.month + "\n");
		
		for (char c : dow)
			System.out.print(c + "\t"); // 한글요일 전체 출력
		System.out.println();
		
		switch (this.date.getDayOfWeek()) { // 달력 start
		case SUNDAY:
			for (int i = 1; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 0)
					System.out.println();
			}
			print_after_28(this.date.lengthOfMonth());// 29, 30, 31일 출력

			break;

		case MONDAY:
			System.out.println("\t1\t2\t3\t4\t5\t6");
			for (int i = 7; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 6)
					System.out.println();
			}
			print_after_28(this.date.lengthOfMonth());// 29, 30, 31일 출력

			break;

		case TUESDAY:

			System.out.println("\t\t1\t2\t3\t4\t5");
			for (int i = 6; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 5)
					System.out.println();
			}
			print_after_28(this.date.lengthOfMonth());// 29, 30, 31일 출력

			break;

		case WEDNESDAY:

			System.out.println("\t\t\t1\t2\t3\t4");
			for (int i = 5; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 4)
					System.out.println();
			}
			print_after_28(this.date.lengthOfMonth());// 29, 30, 31일 출력

			break;

		case THURSDAY:
			System.out.println("\t\t\t\t1\t2\t3");
			for (int i = 4; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 3)
					System.out.println();
			}
			print_after_28(this.date.lengthOfMonth());// 29, 30, 31일 출력
			break;

		case FRIDAY:
			System.out.println("\t\t\t\t\t1\t2");
			for (int i = 3; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 2)
					System.out.println();
			}
			print_after_28(this.date.lengthOfMonth(), DayOfWeek.FRIDAY);// 29, 30, 31일 출력
			break;

		case SATURDAY:
			System.out.println("\t\t\t\t\t\t1");
			for (int i = 2; i <= 28; i++) {
				System.out.printf("%d\t", i);
				if (i % 7 == 1)
					System.out.println();
			}
			print_after_28(this.date.lengthOfMonth(), DayOfWeek.SATURDAY);// 29, 30, 31일 출력
			break;
		default:
			System.out.println("Error : 시작일이 잘못됨!!!");
			break;
		}// 달력 end
		System.out.println();
	}

	private static void print_after_28(int month) {
		// 29,30,31일 출력
		if (month == 30)
			System.out.println("29\t30");
		else if (month == 31)
			System.out.println("29\t30\t31");
		else if (month == 29) // month==2, 윤년
			System.out.println("29");
	}

	private static void print_after_28(int month, DayOfWeek dow) {
		// 29,30,31일 출력
		if (dow == DayOfWeek.FRIDAY) {
			if (month == 30)
				System.out.println("29\t30");
			else if (month == 31)
				System.out.println("29\t30\n31");
			else if (month == 29) // month==2, 윤년
				System.out.println("29");
		}
		if (dow == DayOfWeek.SATURDAY) {
			if (month == 30)
				System.out.println("29\n30");
			else if (month == 31)
				System.out.println("29\n30\t31");
			else if (month == 29) // month==2, 윤년
				System.out.println("29");
		}
	}
	
	public void plusMinusMonth(int i) {
		this.date = this.date.plusMonths(i);
		this.year = date.getYear();
		this.month = date.getMonth();
	}

}