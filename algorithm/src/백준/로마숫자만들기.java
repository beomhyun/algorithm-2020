package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 로마숫자만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		for (int i = 0; i < N; i++) {
			Set<Integer> newSet = new HashSet<Integer>();
			for (int num : set) {
				newSet.add(num + 1);
				newSet.add(num + 5);
				newSet.add(num + 10);
				newSet.add(num + 50);
			}
			set = newSet;
		}
		System.out.println(set.size());
	}
}