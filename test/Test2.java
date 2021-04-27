package test;

public class Test2 {
	static int[][] position= {
			{0,0},{0,1},{0,2},
			{1,0},{1,1},{1,2},
			{2,0},{2,1},{2,2},
			{3,0},{3,1},{3,2}
			};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}; // 누를 번호
		String hand = "right"; // 오른손잡이
		System.out.println(Solution(numbers, hand)); //"LRLLLRLLRRL"
	}
	static String Solution(int[] numbers, String hand) {
		String answer="";
		int[] l_location=new int[numbers.length+1];
		l_location[0] = 10;
		int[] r_location=new int[numbers.length+1];
		r_location[0] = 12;
		int l=1,r=1;
		int l_distance,r_distance;
		for (int i = 0; i < numbers.length; i++) {
			if(isLeftside(numbers[i])) {
				answer = answer.concat("L");
				l_location[l]=numbers[i];
				l++;
			}
			else if(isRightside(numbers[i])) {
				answer = answer.concat("R");
				r_location[r]=numbers[i];
				r++;
			}
			else {
				System.out.printf("%d번째 숫자 %d \n",i+1,numbers[i]);
				System.out.print("왼손거리 : ");
				l_distance = calculateDistance(l_location[l-1],numbers[i]);
				System.out.print("오른손거리 : ");
				r_distance = calculateDistance(r_location[r-1],numbers[i]);
				if(l_distance == r_distance) {
					
					if(hand.equals("left")) {
						System.out.println("왼손잡이");
						answer = answer.concat("L");
						l_location[l]=numbers[i];
						l++;
					}else if(hand.equals("right")) {
						System.out.println("오른손잡이");
						answer = answer.concat("R");
						r_location[r]=numbers[i];
						r++;
					}
				}
				else if(l_distance < r_distance) {
					answer = answer.concat("L");
					l_location[l]=numbers[i];
					l++;
				}
				else{
					answer = answer.concat("R");
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
		int dif_y=0;
		int dif_x=0;
		int[] s_pos,d_pos;
		if(starting == 0)
			starting = 11;		
		if(destination==0)
			destination = 11;
		starting-=1;
		destination-=1;
		
		s_pos = position[starting]; // 키패드 위치 설정
		d_pos = position[destination]; // 키패드 위치 설정
		
		dif_x = (d_pos[1]>s_pos[1])? (d_pos[1]-s_pos[1]) : -(d_pos[1]-s_pos[1]);
		System.out.print("좌우거리  " + dif_x);
		dif_y = (d_pos[0]>s_pos[0])? (d_pos[0]-s_pos[0]) : -(d_pos[0]-s_pos[0]);
		System.out.print(" + 상하거리  " + dif_y);
		distance = dif_x + dif_y;
		System.out.println(" = 총 거리 " + distance);
		return distance;
	}
	

}
