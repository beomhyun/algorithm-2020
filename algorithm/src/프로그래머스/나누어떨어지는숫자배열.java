package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.List;

public class ����������¼��ڹ迭 {
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
