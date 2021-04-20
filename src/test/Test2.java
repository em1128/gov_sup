package test;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}; // 누를 번호
		String hand = "right"; // 오른손잡이
		System.out.println(Solution(numbers, hand)); //"LRLLLRLLRRL"
	}
	static String Solution(int[] numbers, String hand) {
		String answer="";
		int[] l_location=new int[numbers.length];
		l_location[0] = 10;
		int[] r_location=new int[numbers.length];
		r_location[0] = 12;
		int l=1,r=1;
		int l_distance,r_distance;
		for (int i = 0; i < numbers.length; i++) {
			if(isLeftside(numbers[i])) {
				answer+="L";
				l_location[l]=numbers[i];
				l++;
			}
			else if(isRightside(numbers[i])) {
				answer+="R";
				r_location[r]=numbers[i];
				r++;
			}
			else {
				System.out.printf("%d번째 숫자 %d \n",i+1,numbers[i]);
				System.out.print("왼손거리 : ");
				System.out.println(calculateDistance(l_location[l-1],numbers[i]));
				System.out.print("오른손거리 : ");
				System.out.println(calculateDistance(r_location[r-1],numbers[i]));
				if(i==5)System.out.printf("오른손 위치 : %d\n",r_location[r-1]);
				l_distance = calculateDistance(l_location[l-1],numbers[i]);
				r_distance = calculateDistance(r_location[r-1],numbers[i]);
				if(l_distance == r_distance) {
					
					if(hand.equals("left")) {
						answer+="L";
						l_location[l]=numbers[i];
						l++;
					}else if(hand.equals("right")) {
						answer+="R";
						r_location[r]=numbers[i];
						r++;
					}
				}
				else if(l_distance < r_distance) {
					answer+="L";
					l_location[l]=numbers[i];
					l++;
				}
				else{
					answer+="R";
					r_location[r]=numbers[i];
					r++;
				}
				
			}
			
		}
		
		return answer;
	}
	
	static boolean isLeftside(int number) {
		return (number==1 || number==4 || number==7)? true:false;
	}
	static boolean isRightside(int number) {
		return (number==3 || number==6 || number==9) ?  true: false;
	}
	static int calculateDistance(int starting, int destination) {
		int distance=0;
		int updown=0;
		int rightleft=0;
		if(starting == 0)
			starting = 11;
		
		
		if(destination==0)
			destination = 11;
		starting-=1;
		destination-=1;
		
		rightleft = (destination%3>starting%3)? destination%3-starting%3:starting%3-destination%3;
		System.out.print("좌우거리  " + rightleft);
		updown = (destination/3>starting/3)? destination/3-starting/3:starting/3-destination/3;
		System.out.println(" + 상하거리  " + updown);
		distance = rightleft + updown;
		return distance;
	}

}
