package kakao;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class answer4 {
	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
				
		for (int a : solution(s)) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	    static int[] solution(String s) {
	        Set<String> set = new HashSet<>();
	        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
	        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
	        int[] answer = new int[arr.length];
	        int idx = 0;
	        for(String s1 : arr) {
	            for(String s2 : s1.split(",")) {
	                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
	            }
	        }
	        return answer;
	    }
	
}
