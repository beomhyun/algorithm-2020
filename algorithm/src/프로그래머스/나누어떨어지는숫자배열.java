package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 나누어떨어지는숫자배열 {
	  public int[] solution(int[] arr, int divisor) {
		  List<Integer> list = new ArrayList<Integer>();
		  for(int num : arr) {
			  if(num % divisor == 0) list.add(num);
		  }
		  if(list.size() == 0) list.add(-1);
		  list.sort(null);
		  
	      int[] answer = new int[list.size()];
	      for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
	      return answer;
	  }
}
