package test;

import java.time.LocalDate;
import java.util.Scanner;

public class CalendarExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		int input_y, input_m, input_d;
		
		System.out.println("년>");
		input_y = sc1.nextInt();
		System.out.println("월>");
		input_m = sc1.nextInt();
		System.out.println("일>");
		input_d = sc1.nextInt();
		MyCalendar ca = new MyCalendar(LocalDate.of(input_y, input_m, 1));
		
		ca.plusMinusMonth(-1);
		ca.print_month_first();
		
		ca.plusMinusMonth(+1);
		ca.print_month_first();
		
		ca.plusMinusMonth(+1);
		ca.print_month_first();
		
		sc1.close();
	}

}
