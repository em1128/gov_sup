package test;


public class test3 {
	public static void main(String[] args) {
		
		
		System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
	}
	static int[] solution(String s) {
		int[] answer = new int[s.length()];
		System.out.println("Solution");
//		for (int i : answer) {
			
			splitBr(s);
//		}
		return answer;
		
	}
	private static void splitBr(String original) {
		// TODO Auto-generated method stub
		
		String slice=null;
		char[] clone = original.toCharArray();
		int start=0;
		int end=original.length();
		int[][] sliced = new int[original.length()][original.length()];
		int n=0;
		for (int i = 0; i < original.length(); i++) {
			if(clone[i]=='{') {
				System.out.println("cut");
				start = i+1;			
				
			}
			if(clone[i] == '}'&& i!=original.length()-1) {
				String[] arr;
				end = i;
				slice = original.substring(start,end);
				arr = slice.split(",");
				for (int j = 0; j < arr.length; j++) {

					sliced[n][j] = Integer.parseInt(arr[j]);

				}
				
				
				n++;
			}
			
		}
		
		System.out.println(original);
	}
	
	
}
