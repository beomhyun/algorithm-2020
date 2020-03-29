package 백준;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 크게만들기2812 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		String str = sc.next();

		Map<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i) - '0', i);
		}
		StringBuilder answer = new StringBuilder();
		int k = 0;
		for (int key : map.keySet()) {
			int index = map.get(key);
			k++;
		}
		System.out.println(answer.toString());
	}
}
