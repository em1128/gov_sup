/*
 * 배열에서 서로 다른 숫자 2개를 뽑아서 나올 수 있는 모든 합을 구하고
 * 중복없이 오름차순으로 정렬
 */
package test;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CodeTest {
    public static void main(String[] args) {
        
    	int[] answer = {};
    	int[] numbers = {0,1,2,3,4,5,6,7};
    	
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length;j++){
            	if(i==j) break;
                set.add(numbers[j]+numbers[i]);
            }    
        }
        ArrayList<Integer> list = new ArrayList<Integer>(set);	
        Collections.sort(list);
        
        answer = new int[list.size()];
        for(int l=0;l<list.size();l++){
            answer[l]=list.get(l);
        }
        
        System.out.print("[");
        for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
			if(i<answer.length-1)System.out.print(", ");
		}
        System.out.print("]");
    }
}