package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ���ڿ���������������ϱ� {
	public static void main(String[] args) {
		String[] strings = 	{"sun", "bed", "car"};
		solution(strings, 1);
	}
	public static String[] solution(String[] strings, int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < strings.length; i++) {
			list.add(strings[i]);
		}
		list.sort(null);
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.charAt(n) - o2.charAt(n);
			}
		});
		
		String[] answer = new String[strings.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
