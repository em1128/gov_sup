package kakao;
import java.util.ArrayList;
public class test3 {
	public static void main(String[] args) {
		
		
		System.out.println(solution("{{2},{2,1},{2,1,4,3},{2,1,3}}"));
		
	}
	static int[] solution(String s) {
		int[] answer = new int[s.length()];
		System.out.println("Solution");
			
			splitBr(s);
			
		return answer;
		
	}
	private static int[] splitBr(String s) {
		// TODO Auto-generated method stub
		
		String cut_br=null;
		char[] clone = s.toCharArray();
		int start=0;
		int end=s.length();
		int[][] sliced_num = new int[s.length()-4][s.length()-4];
		int n=0;
		int m=0;
		ArrayList<Integer> ans_list = new ArrayList<Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			if(clone[i]=='{') {

				start = i+1;			
				
			}
			if(clone[i] == '}'&& i!=s.length()-1) {
				String[] arr = new String[s.length()];
				end = i;
				cut_br = s.substring(start,end);
				arr = cut_br.split(",");
				for (m=0; m < arr.length; m++) {

					sliced_num[n][m] = Integer.parseInt(arr[m]);

				}				
				n++;
			}
			
		}
		int count[]= new int[n];
		for (int i : count) {
			i=0;
		}
		for (int i = 0; i < sliced_num.length; i++) {
			
			for (int j = 0; j < sliced_num[i].length; j++) {
				
				if(sliced_num[i][j]!=0) {
					if(!ans_list.contains(sliced_num[i][j])) {
						ans_list.add(sliced_num[i][j]);
					}
					else {
						for(int k=0;k<ans_list.size();k++) {
							if(ans_list.get(k)==sliced_num[i][j]) {
								count[k]++;
							}
						}
					}
				}
			}
			
		}
		for (int i : count) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] answer = new int[ans_list.size()];
			for (int i = 0; i < ans_list.size(); i++) {
				answer[i] = ans_list.get(n-count[i]-1);
			}
			
			for (int i : answer) {
				System.out.print(i + " ");
			}
			return answer;
				
		
	}
	
	
}

