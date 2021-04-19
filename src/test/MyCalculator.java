/*
 *계산기 
*/
package test;

import java.io.IOException;
import java.util.Scanner;

public class MyCalculator {
	public static void main(String[] args) throws IOException {
		System.out.println();
		Scanner sc1 = new Scanner(System.in);
	
		int n1 = 1024;
		int n2 = 500;
		add(n1, n2);
		sub(n1, n2);
		mul(n1, n2);
		div(n1, n2);
		System.out.println();
		n1 = 100;
		n2 = 250;
		add(n1, n2);
		sub(n1, n2);
		mul(n1, n2);
		div(n1, n2);
		
	}

	private static void add(int n1, int n2) {
		// TODO Auto-generated method stub
		System.out.printf("덧셈 : %d + %d = %d\n",n1 ,n2 ,n1+n2);

	}
	private static void sub(int n1, int n2) {
		// TODO Auto-generated method stub
		if(n1>=n2) {
			System.out.printf("뺄셈 : %d - %d = %d\n",n1 ,n2 ,n1-n2);
		}
		else {
			System.out.printf("뺄셈 : %d - %d = %d\n",n2 ,n1 ,n2-n1);
		}
	}
	private static void mul(int n1, int n2) {
		// TODO Auto-generated method stub
		System.out.printf("곱셈 : %d x %d = %d\n",n1 ,n2 ,n1*n2);
	}
	private static void div(int n1, int n2) {
		// TODO Auto-generated method stub
		double m, n;
		if(n1>=n2)
		{
			m = n1/n2;
			n = n1%n2;
			System.out.printf("나눗셈 : %d / %d = %f\n",n1 ,n2 ,m);
			System.out.printf("\t나머지 : %f\n" ,n);
		}
		else {
			m = n2/n1;
			n = n2%n1;
			System.out.printf("나눗셈 : %d / %d = %f\n",n2 ,n1 ,m);
			System.out.printf("\t나머지 : %f\n",n);
		}

	}





}