/*
 *음료수1 1000, 음료수2 500, 음료수3 400
 *화폐단위 1000 500 100
 *최대투입액 5000
 *1 >> 음료수1
 *0 >> 거스름 반환, 판매 종료
 *거스름은 내림차순 
 */
package test;

import java.io.IOException;
import java.util.Scanner;

public class java3 {

	public static void main(String[] args) throws IOException {

		int money = 0;
		int sel = 9;

		Scanner sc1 = new Scanner(System.in);

		DrinkMachine dMachine = new DrinkMachine();
		do {
			dMachine.menu_print();
			sel = sc1.nextInt();
			switch (sel) {
			case 9:
				break;
			case 0:
				// 입금

				System.out.println("입금> ");
				money += dMachine.input_money(sc1.nextInt());
				break;
			case 1, 2, 3:
				// 음료수 판매
				money = dMachine.sell_drink(sel, money);
				break;
			default:
				continue;

			}

			System.out.println("현재 투입 금액: " + money + "원\n");

		} while (sel != 9);
		// 거스름돈 반환
		dMachine.return_money(money);
		System.out.println();
		dMachine.result_print();
		sc1.close();

	}

	static class DrinkMachine {
		int drink_1 = 0, drink_2 = 0, drink_3 = 0;
		int price_1, price_2, price_3;

		public DrinkMachine() {
			this.price_1 = 1000;
			this.price_2 = 500;
			this.price_3 = 400;

		}

		public DrinkMachine(int p1, int p2, int p3) {
			this.price_1 = p1;
			this.price_2 = p2;
			this.price_3 = p3;
		}

		private int input_money(int nextInt) {
			// 입금 start
			int input_money = nextInt;

			if (input_money > 5000) {
				System.out.println("Error : 5000원 초과!!!");
				return 0;
			} else if (input_money <= 0) {
				System.out.println("Error : 입금이 안 됐습니다!!!");
				return 0;
			} else { // 입금 성공
				return input_money;
			}
			// 입금 end

		}

		private int sell_drink(int sel, int money) {
			// 음료수 판매 start
			if (sel == 1) {
				if (money < price_1) { // 음료수1 판매
					System.out.println("Error : 금액이 부족합니다!!!");
				} else {
					money -= price_1;
					System.out.println("음료수1 구매완료!");
					this.drink_1++;
				}

			} else if (sel == 2) { // 음료수2 판매
				if (money < price_2) {
					System.out.println("Error : 금액이 부족합니다!!!");
				} else {
					money -= price_2;
					System.out.println("음료수2 구매완료!");
					this.drink_2++;
				}

			} else if (sel == 3) { // 음료수3 판매
				if (money < price_3) {
					System.out.println("Error : 금액이 부족합니다!!!");
				} else {
					money -= price_3;
					System.out.println("음료수3 구매완료!");
					this.drink_3++;
				}

			} else {
				System.out.println("Error: 정확한 숫자를 입력하세요!!!");
			}
			// 음료수 판매 end
			return money;
		}

		private void return_money(int money) { // 거스름돈 반환 start
			System.out.println("거스름돈\n");
			int thousands = 0;
			int five_hundreds = 0;
			int hundreds = 0;

			if (money >= 1000) {
				thousands = money / 1000;
				money = money % 1000;
				System.out.println("1000원 지폐 : " + thousands);
			}

			if (money >= 500) {
				five_hundreds = money / 500;
				money = money % 500;
				System.out.println("500원 동전 : " + five_hundreds);
			}

			if (money >= 100) {
				hundreds = money / 100;
				money = money % 100;
				System.out.println("100원 동전 : " + hundreds);
			}
			// 거스름돈 반환 end
		}

		private void menu_print() { // 메뉴 출력

			System.out.println("0 - 입급");
			System.out.printf("1 - 음료수1 : %d원\n", this.price_1);
			System.out.printf("2 - 음료수2 : %d원\n", this.price_2);
			System.out.printf("3 - 음료수3 : %d원\n", this.price_3);
			System.out.println("9 - 거스름(종료)");
			System.out.println("------------------------------");

		}

		private void result_print() {
			System.out.println("선택된 메뉴항목");
			System.out.printf("1) 음료수1 개수:\t%d개\n", this.drink_1);
			System.out.printf("2) 음료수2 개수:\t%d개\n", this.drink_2);
			System.out.printf("3) 음료수3 개수:\t%d개\n", this.drink_3);
			System.out.println("==============================");
		}

	}

}